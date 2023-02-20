package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class APITest
{

    @Test
    public void apiSimpleGET()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

        RequestSpecification httpRequest = given();
        httpRequest.contentType("application/json");

        Response response = httpRequest.request(Method.GET, "users");
        String responseBody = response.getBody().asString();
        int status = response.getStatusCode();
        System.out.println("Status:"+status);

        Assert.assertEquals(status,200);

        System.out.println("Response Body is =>  " + responseBody);

    }

    @Test
    public void apiPOST()
    {
        RestAssured.baseURI ="https://jsonplaceholder.typicode.com/";

    /*    JSONObject requestParams = new JSONObject();
        requestParams.put("name", "velja");
        requestParams.put("username",  "veljam");
        String query = requestParams.toString();*/
        String query = "[\n" +
                "    {\n" +
                "        \"id\": 11,\n" +
                "        \"name\": \"Krishna Rungta\",\n" +
                "        \"username\": \"Bret\",\n" +
                "        \"email\": \"Sincere@april.biz\",\n" +
                "        \"address\": {\n" +
                "            \"street\": \"Kulas Light\",\n" +
                "            \"suite\": \"Apt. 556\",\n" +
                "            \"city\": \"Gwenborough\",\n" +
                "            \"zipcode\": \"92998-3874\",\n" +
                "            \"geo\": {\n" +
                "                \"lat\": \"-37.3159\",\n" +
                "                \"lng\": \"81.1496\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"phone\": \"1-770-736-8031 x56442\",\n" +
                "        \"website\": \"hildegard.org\",\n" +
                "        \"company\": {\n" +
                "            \"name\": \"Romaguera-Crona\",\n" +
                "            \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                "            \"bs\": \"harness real-time e-markets\"\n" +
                "        }\n" +
                "    }\n" +
                "]";

        System.out.println(query);

        RequestSpecification request = RestAssured.given();

        request.body(query);
        request.contentType("application/json");

        try
        {
            Response response = request.post("users");

            int statusCode = response.getStatusCode();
            System.out.println("status code:"+statusCode);
            Assert.assertEquals(201,statusCode);
            System.out.println(response.asString());

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    private static final String apiKey = "f399f648-e6ca-49b2-8cbd-0f657b3db451"; // ovde upises svoj APIkey
    private static final String xApiKey = "AQEyhmfxKYLObRNKw0m/n3Q5qf3VaY9UCJ14XWZE03G/k2NFisuRs7z7KhB9kBC+ZOWG3q8QwV1bDb7kfNy1WIxIIkxgBw==-93tbzoYe6VpJgQsHnyaxkV9JGBdIT2yjndUHlL7+OJM=-g6%6xG^I444pdqU#";

    @Test
    public void apiGET()
    {
        RestAssured.baseURI ="https://pro-api.coinmarketcap.com/v1/cryptocurrency";

        RequestSpecification httpRequest = given();
        httpRequest.contentType("application/json");
        httpRequest.header("X-CMC_PRO_API_KEY", apiKey);

        Response response = httpRequest.request(Method.GET, "/info?id=3843");
        String responseBody = response.getBody().asString();

        System.out.println("Response Body is =>  " + responseBody);

        JSONObject jsonObjectStatus = new JSONObject(responseBody).getJSONObject("status");
        System.out.println("status: "+jsonObjectStatus.toString());
        String error_message = jsonObjectStatus.get("error_message").toString();
        System.out.println(error_message);
        Assert.assertEquals(error_message,"null");

        JSONObject jsonObjectData = new JSONObject(responseBody).getJSONObject("data");
        System.out.println(jsonObjectData.toString());
        JSONObject jsonObjectID = jsonObjectData.getJSONObject("3843");
        System.out.println(jsonObjectID.toString());
        String symbol = jsonObjectID.getString("symbol");
        System.out.println(symbol);
        Assert.assertEquals(symbol,"BOLT");
        String dateAdded = jsonObjectID.getString("date_added");
        System.out.println(dateAdded);
        Assert.assertEquals(dateAdded, "2019-04-05T00:00:00.000Z");
        String logo = jsonObjectID.getString("logo");
        System.out.println(logo);
        Assert.assertEquals(logo, "https://s2.coinmarketcap.com/static/img/coins/64x64/3843.png");

        JSONObject jsonObjectURLs = jsonObjectData.getJSONObject("3843").getJSONObject("urls");
        System.out.println(jsonObjectURLs.toString());
        JSONArray urlsArray = jsonObjectURLs.getJSONArray("source_code");
        String source_code = urlsArray.get(0).toString();
        System.out.println(source_code);
        Assert.assertEquals("https://github.com/SyQic-Ops/bolt",source_code);

        JSONArray websiteArray = jsonObjectURLs.getJSONArray("website");
        String website = websiteArray.get(0).toString();
        System.out.println(website);
        Assert.assertEquals("https://bolt.global/",website);
    }


}

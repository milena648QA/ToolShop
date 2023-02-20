package api.coinMarket;

import io.restassured.http.Method;
import model.coinmarket.response.CoinMarket3843;
import model.coinmarket.response.CoinMarketGetBoltResponse;
import io.restassured.response.Response;
import lombok.Getter;
import model.coinmarket.response.CoinMarketStatus;
import model.coinmarket.response.CoinMarketUrls;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;

public class CoinMarketApi extends ApiBase
{
    private static final String boltPath= "/info?id=3843";

    @Getter
    private String responseBody;

    public CoinMarketGetBoltResponse getBoltResponse()
    {
        //@formatter:off

        Response response = requestSpecification.request(Method.GET, boltPath);
        //@formatter:on
        System.out.println("Bolt response: "+ response.getBody().asString());

        responseBody = response.getBody().asString();

        CoinMarketGetBoltResponse rm = new CoinMarketGetBoltResponse();
        rm.setStringResponse(responseBody);

        return rm;
    }

    public CoinMarketStatus getStatusResponse(CoinMarketGetBoltResponse bolt)
    {

        JSONObject statusJSON = new JSONObject(bolt.getStringResponse()).getJSONObject("status");

        CoinMarketStatus cms = new CoinMarketStatus();
        cms.setErrorMessaqe(statusJSON.get("error_message").toString());
        cms.setElapsed(statusJSON.getInt("elapsed"));
        cms.setCreditCount(statusJSON.getInt("credit_count"));
        cms.setErrorCode(statusJSON.getInt("error_code"));
        cms.setTimestamp(statusJSON.get("timestamp").toString());
        cms.setNotice(statusJSON.get("notice").toString());

        return cms;
    }

    public CoinMarket3843 get3843Response(CoinMarketGetBoltResponse bolt)
    {
        JSONObject jsonObjectData = new JSONObject(bolt.getStringResponse()).getJSONObject("data");
        //System.out.println("Data: "+jsonObjectData.toString());
        JSONObject jsonObjectID = jsonObjectData.getJSONObject("3843");
        //System.out.println("3843: "+jsonObjectID.toString());
        CoinMarket3843 cm3843 = new CoinMarket3843();
        cm3843.setSymbol(jsonObjectID.getString("symbol"));
        cm3843.setSelfReportedTags(jsonObjectID.get("self_reported_tags").toString());
        cm3843.setTagGroups(jsonObjectID.get("tag-groups").toString());
        cm3843.setTwitterUsername(jsonObjectID.get("twitter_username").toString());
        cm3843.setIsHidden(jsonObjectID.getInt("is_hidden"));
        cm3843.setDescription(jsonObjectID.getString("description"));
        cm3843.setDateAdded(jsonObjectID.getString("date_added"));
        cm3843.setLogo(jsonObjectID.getString("logo"));

        return cm3843;
    }

    public CoinMarketUrls getUrlsResponse(CoinMarketGetBoltResponse bolt)
    {
        JSONObject jsonObjectData = new JSONObject(bolt.getStringResponse()).getJSONObject("data");
        JSONObject jsonObjectID = jsonObjectData.getJSONObject("3843");
        JSONObject jsonObjectURLs = jsonObjectID.getJSONObject("urls");

        JSONArray urlsArray = jsonObjectURLs.getJSONArray("source_code");
        String source_code = urlsArray.get(0).toString();

        CoinMarketUrls urls = new CoinMarketUrls();
        urls.setSourceCode(source_code);
        JSONArray websiteArray = jsonObjectURLs.getJSONArray("website");
        String website = websiteArray.get(0).toString();

        urls.setWebsite(website);

        return urls;
    }

}

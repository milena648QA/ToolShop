package tests;

import api.coinMarket.CoinMarketApi;
import model.coinmarket.response.CoinMarket3843;
import model.coinmarket.response.CoinMarketGetBoltResponse;
import model.coinmarket.response.CoinMarketStatus;
import model.coinmarket.response.CoinMarketUrls;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import slack.Slack;
import slack.SlackChannel;

import java.io.IOException;

public class CoinMarketApiTest
{

    SoftAssert soft = new SoftAssert();
    CoinMarketApi cmAPI = new CoinMarketApi();

    public void assertAll()
    {
        try
        {
            soft.assertAll();
        }
        catch (AssertionError e)
        {
            System.out.println(e.getMessage());
            Slack.postSlackTextMessage(e.getMessage() , SlackChannel.QARevealed);
        }
    }

    @Test()
    public void getCoinMarketResponseTest()
    {
        CoinMarketGetBoltResponse bolt = cmAPI.getBoltResponse();
        CoinMarketStatus status = cmAPI.getStatusResponse(bolt);
        System.out.println("Error message: "+status.getErrorMessaqe());

        soft.assertTrue(status.getErrorMessaqe().contains("null"),"Error message is not null!");
/*        System.out.println("Elapsed: "+status.getElapsed());
        System.out.println("Credit count: "+status.getCreditCount());
        System.out.println("Error code: "+status.getErrorCode());
        System.out.println("Timestamp: "+status.getTimestamp());
        System.out.println("Notice: "+status.getNotice());*/
        CoinMarket3843 cm3843 = cmAPI.get3843Response(bolt);
        System.out.println("Symbol: "+cm3843.getSymbol());
        System.out.println("Date added: "+cm3843.getDateAdded());
        System.out.println("Logo: "+cm3843.getLogo());
/*        System.out.println("Self reported tags: "+cm3843.getSelfReportedTags());
        System.out.println("Tag groups: "+cm3843.getTagGroups());
        System.out.println("Twitter username: "+cm3843.getTwitterUsername());
        System.out.println("Is hidden: "+cm3843.getIsHidden());
        System.out.println("Description: "+cm3843.getDescription());*/
        soft.assertTrue(cm3843.getSymbol().contains("BOLT"),"Symbol BOLT is not found!");
        soft.assertEquals(cm3843.getDateAdded(), "2019-04-05T00:00:00.000Z");
        soft.assertEquals(cm3843.getLogo(), "https://s2.coinmarketcap.com/static/img/coins/64x64/3843.png");

        CoinMarketUrls cmUrls = cmAPI.getUrlsResponse(bolt);
        System.out.println("Source code: "+cmUrls.getSourceCode());
        System.out.println("Website: "+cmUrls.getWebsite());

        soft.assertEquals("https://github.com/SyQic-Ops/bolt", cmUrls.getSourceCode());
        soft.assertEquals("https://bolt.global/", cmUrls.getWebsite());

        assertAll();
    }
}

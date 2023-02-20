package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GoogleHomePage;

public class BrowserPOMTest extends BaseTest
{

    @Test
    public void googleSearchTest() throws InterruptedException
    {

        String term = "QA Revealed";

        GoogleHomePage homepage = new GoogleHomePage(driver);
        homepage.googleSearch(term);

        // "QA Revealed" exists in search results
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        WebElement searchResults = driver.findElement(By.id("search"));
        Assert.assertTrue("Google search test, term is not found on result page!",
                searchResults.getText().contains(term));
        Thread.sleep(3000);
    }

}

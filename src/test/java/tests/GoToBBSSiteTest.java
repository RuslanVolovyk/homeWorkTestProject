package tests;

import basetest.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;

import static basetest.BbsConstants.baseUrl;

public class GoToBBSSiteTest extends BaseTest {

    @Test
    public void testBBSSiteElementsPresent() {
        BbcMainPage bbsPageObject1 = new BbcMainPage(driver);
        Assert.assertTrue(bbsPageObject1.searchTextForm.isEnabled());
        Assert.assertTrue(bbsPageObject1.searchTextForm.isDisplayed());
    }

    @Test
    public void testBBSSite() {
        driver.get(baseUrl);
        String searchWord = "dog";
        BbcMainPage bbsPageObject2 = new BbcMainPage(driver);

        bbsPageObject2.sendTextIntoSearchTextForm(searchWord);
        bbsPageObject2.searchButtonClick();
        bbsPageObject2.clickOnLink();
    }
}

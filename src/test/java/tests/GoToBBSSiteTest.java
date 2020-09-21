package tests;

import basetest.BaseTest;
import com.sun.org.glassfish.gmbal.Description;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static basetest.BbsConstants.BASE_URL;


public class GoToBBSSiteTest extends BaseTest {

    @BeforeMethod
    public void openSite() {
        driver.get(BASE_URL);
    }

    @Description("Checks if the search text form is enabled on the page and if the search button is displayed there.")
    @Test(priority = 2)
    public void testBBSSiteElementsPresent() {
        BbcMainPage bbsMainPageObject1 = new BbcMainPage(driver);
        bbsMainPageObject1.searchTextFormIsDisplayed();
        bbsMainPageObject1.searchTextFormIsEnabled();
    }

    @Description("Checks if our search  made.")
    @Test(priority = 1)
    public void testBBSSite() {
        String searchWord = "dog";
        BbcMainPage bbcMainPageObject2 = new BbcMainPage(driver);
        BbcSearchPage bbcSearchPage1 = new BbcSearchPage(driver);

        bbcMainPageObject2.sendTextIntoSearchTextForm(searchWord);
        bbcMainPageObject2.searchButtonClick();
        bbcMainPageObject2.mainPageIsNotDisplayed();
        bbcSearchPage1.clickOnLink();
        bbcSearchPage1.searchPageIsNotDisplayed();
    }
}

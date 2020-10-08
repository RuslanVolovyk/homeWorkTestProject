package test;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BbcMainPage;
import pages.BbcSearchPage;

import static data.BbsConstants.BASE_URL;


public class GoToBBSSiteTest extends BaseTest {

    @BeforeMethod
    public void openSite() {
        setUp().get(BASE_URL);

    }

    @AfterMethod
    public void driverDestroy() {
        tearDown();
    }

    @Description("Checks if the search text form is enabled on the page and if the search button is displayed there.")
    @Test
    public void testBBSSiteElementsPresent() {
        BbcMainPage bbsMainPageObject1 = new BbcMainPage(driver);
        bbsMainPageObject1.searchTextFormIsDisplayed();
        bbsMainPageObject1.searchTextFormIsEnabled();
    }

    @Description("Checks if our search  made.")
    @Test
    @TmsLink("1")
    public void testBBSSite() {
        String searchWord = "dog";
        BbcMainPage bbcMainPageObject2 = new BbcMainPage(driver);
        BbcSearchPage bbcSearchPage1 = new BbcSearchPage(driver);

        bbcMainPageObject2.sendTextIntoSearchTextForm(searchWord);
        bbcMainPageObject2.searchButtonLeftMouseClick();
        bbcMainPageObject2.mainPageIsNotDisplayed();
        bbcSearchPage1.clickOnFirstLink();
        bbcSearchPage1.searchPageIsNotDisplayed();
    }
}

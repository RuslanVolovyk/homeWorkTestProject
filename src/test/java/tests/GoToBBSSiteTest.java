package tests;

import basetest.BaseTest;
import org.testng.annotations.Test;

import static basetest.BbsConstants.baseUrl;

public class GoToBBSSiteTest extends BaseTest {

    @Test
    public void testBBSSite() {
        driver.get(baseUrl);
        String searchWord = "dog";
        BbcMainPage bbsPageObject = new BbcMainPage(driver);

        bbsPageObject.sendTextIntoSearchTextForm(searchWord);
        bbsPageObject.searchButtonClick();
        bbsPageObject.clickOnLink();
    }
}

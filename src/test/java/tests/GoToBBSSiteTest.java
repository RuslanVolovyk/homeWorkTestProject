package tests;

import basetest.BaseTest;
import org.testng.annotations.Test;

public class GoToBBSSiteTest extends BaseTest {

    @Test
    public void testBBSSite() {
        driver.get(baseUrl);
        String searchWord = "dog";
        bbsPageObject bbsPageObject = new bbsPageObject(driver);

        bbsPageObject.sendTextIntoSearchTextForm(searchWord);
        bbsPageObject.searchButtonClick();
        bbsPageObject.clickOnLink();
    }
}

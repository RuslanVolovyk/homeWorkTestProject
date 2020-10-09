package test;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;

import pages.YandexMainPage;
import pages.YandexMarketPage;

import java.util.ArrayList;

import static data.YandexConstants.BASE_URL;

public class YandexPool2Test extends BaseTest {
    @BeforeMethod
    public void openSite() {
        setUp().get(BASE_URL);
    }

    @AfterMethod
    public void driverDestroy() {
        tearDown();
    }

    @Description("Yandex Market - adding to comparison 2 items")
    @Test
    @TmsLink("8")
    public void addingToComparison() {
        int number = 3;
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexMarketPage yandexMarketPage = new YandexMarketPage(driver);

        yandexMainPage.clickOnMarketLink();
        yandexMainPage.switchToTheMarketTab();
        yandexMarketPage.putNote8InSearchField();
        yandexMarketPage.clickOnSubmitButton();
        ArrayList<String> selectedItems = yandexMarketPage.putItemsToComparison(number);
        yandexMarketPage.clickOnCompareButton();
        ArrayList<String> comparedItems = yandexMarketPage.checkComparedItems(number);
        yandexMarketPage.checkComparedItems(selectedItems, comparedItems);
    }
}

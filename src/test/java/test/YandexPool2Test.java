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
    @Parameters({"searchedItem", "numberItemsForComparison"})
    @Test
    @TmsLink("8")
    public void addingToComparison(String searchedItem, int numberItemsForComparison) {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexMarketPage yandexMarketPage = new YandexMarketPage(driver);
        String description = "Смарт";

        yandexMainPage.clickOnMarketLink();
        yandexMainPage.switchToTheMarketTab();
        yandexMarketPage.putWordInSearchField(searchedItem);
        yandexMarketPage.clickOnSubmitButton();
        ArrayList<String> expectedItems = yandexMarketPage.getListItemsForComparison(numberItemsForComparison,
                description);
        yandexMarketPage.clickOnCompareButton();
        ArrayList<String> actualItems = yandexMarketPage.getListComparedItems(numberItemsForComparison);
        yandexMarketPage.checkComparedItems(expectedItems, actualItems);
    }
}

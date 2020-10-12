package test;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;

import pages.YandexMainPage;
import pages.YandexMarketPage;

import java.util.List;

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

    @DataProvider(name = "forComparison")
    public Object[][] createData() {
        return new Object[][]{
                {"Note 8", (3)},
                {"Note 9", (2)}
        };
    }

    @Description("Yandex Market - adding to comparison 2 items")
    @Test(dataProvider = "forComparison")
    @TmsLink("8")
    public void addingToComparison(String searchedItem, int numberItemsForComparison) {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexMarketPage yandexMarketPage = new YandexMarketPage(driver);
        String description = "Смарт";

        yandexMainPage.clickOnMarketLink();
        yandexMainPage.switchToTheMarketTab();
        yandexMarketPage.putWordInSearchField(searchedItem);
        yandexMarketPage.clickOnSubmitButton();
        List<String> expectedItems = yandexMarketPage.getListItemsForComparison(numberItemsForComparison,
                description);
        yandexMarketPage.clickOnCompareButton();
        List<String> actualItems = yandexMarketPage.getListComparedItems(numberItemsForComparison);
        yandexMarketPage.checkComparedItems(expectedItems, actualItems);
    }

    @Description("Yandex Market - deleting selected items")
    @Test
    @TmsLink("9")
    public void deleteFromComparison() {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexMarketPage yandexMarketPage = new YandexMarketPage(driver);
        String description = "Смарт";
        String searchedItem = "Note 8";
        int numberItemsForComparison = 2;

        yandexMainPage.clickOnMarketLink();
        yandexMainPage.switchToTheMarketTab();
        yandexMarketPage.putWordInSearchField(searchedItem);
        yandexMarketPage.clickOnSubmitButton();
        List<String> expectedItems = yandexMarketPage.getListItemsForComparison(numberItemsForComparison,
                description);
        yandexMarketPage.clickOnCompareButton();
        List<String> actualItems = yandexMarketPage.getListComparedItems(numberItemsForComparison);
        yandexMarketPage.checkComparedItems(expectedItems, actualItems);
        yandexMarketPage.deleteFromComparison();
        yandexMarketPage.checkIfRemoved(actualItems);
    }
}

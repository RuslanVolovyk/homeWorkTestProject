package test;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;

import pages.YandexMainPage;
import pages.YandexMarketPage;
import pages.YandexMusicPage;

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

    @Description("Yandex Market - sorting by price  dawn")
    @Test(invocationCount = 1)
    @TmsLink("10")
    public void sortingByPrice() {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexMarketPage yandexMarketPage = new YandexMarketPage(driver);

        yandexMainPage.clickOnMarketLink();
        yandexMainPage.switchToTheMarketTab();
        yandexMarketPage.clickOnElectronicLink();
        yandexMarketPage.clickOnActionsCameras();
        yandexMarketPage.clickOnActionsCameras();
        yandexMarketPage.clickOnSortByPrice();
        yandexMarketPage.clickOnSortByPrice();
        yandexMarketPage.checkSortingOfItems();
    }

    @Description("Yandex Market - sorting by a tag")
    @Test(invocationCount = 1)
    @TmsLink("11")
    public void sortingByTag() {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexMarketPage yandexMarketPage = new YandexMarketPage(driver);
        int widthLimit = 50;

        yandexMainPage.clickOnMarketLink();
        yandexMainPage.switchToTheMarketTab();
        yandexMarketPage.clickOnHomeAppliancesLink();
        yandexMarketPage.clickOnFridgesLink();
        yandexMarketPage.selectWidthTo50(widthLimit);
        yandexMarketPage.checkFridgesWidth(widthLimit);
    }

    @Description("Yandex mMusic - finding an artist")
    @Test(invocationCount = 10)
    @TmsLink("12")
    public void findingMusic() {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexMusicPage yandexMusicPage = new YandexMusicPage(driver);
        String searchWord = "Metal";
        String artist = "Metallica";

        yandexMainPage.clickOnMusic();
        yandexMusicPage.switchToTheMusicTab();
        yandexMusicPage.closeAd();
        yandexMusicPage.makeSearch(searchWord);
        yandexMusicPage.chooseArtist(artist);
        yandexMusicPage.checkArtistTitle(artist);
        yandexMusicPage.checkArtisOfPopularAlbums(artist);
    }
}

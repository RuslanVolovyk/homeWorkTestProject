package pages;

import core.ActionByActions;
import core.ClickOn;
import core.Helper;
import core.JsActions;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class YandexMusicPage extends PageObjectCreator implements ClickOn, JsActions, ActionByActions, Helper {

    public YandexMusicPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='d-icon deco-icon d-icon_cross-big  local-icon-theme-black']")
    WebElement closeAdButton;

    @FindBy(xpath = "//div[contains(@class, 'd-input_suggest')]/input")
    WebElement searchMusicField;

    @FindBy(xpath = "//div[contains(@class, 'd-suggest__items_type_artist')]//div[@class ='d-suggest-item__title-main']")
    List<WebElement> foundArtists;

    @FindBy(xpath = "//a[contains(@title,'Metallica') and contains(@class,'d-link')]")
    List<WebElement> popularAlbumsList;

    @FindBy(xpath = "//div[@class='d-generic-page-head__main-top']/h1")
    WebElement actualArtistTitle;

    @Step("switch to the music tab")
    public void switchToTheMusicTab() {
        switchToTheLastTab(driver);
    }

    @Step("close advertisement")
    public void closeAd() {
        clickOnMouse(closeAdButton);
    }

    @Step("input search text into the search music field")
    public void makeSearch(String word) {
        clickOnMouse(searchMusicField);
        putTextIntoField(searchMusicField, word);
        new WebDriverWait(driver, 20).withMessage("found no results ").until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.partialLinkText(word)));
    }

    @Step("choose the artist from the list")
    public void chooseArtist(String requiredArtist) {
        if (foundArtists.size() != 0) {
            for (WebElement element : foundArtists) {
                if (getElementValue(element).contains(requiredArtist)) {
                    new WebDriverWait(driver, 10).withMessage("not present artist ").
                            until(ExpectedConditions.elementToBeClickable(element));
                    clickMouse(driver, element);
                    break;
                }
            }
        }
    }

    @Step("Check the selected artist title")
    public void checkArtistTitle(String expectedArtist) {
        new WebDriverWait(driver, 20).withMessage("the searched artist title is not present").
                until(ExpectedConditions.visibilityOf(actualArtistTitle));
        Assert.assertEquals(getElementValue(actualArtistTitle), expectedArtist, "the artist is not the " +
                expectedArtist);
    }

    @Step("Check if the popular albums belong to the expected artist")
    public void checkArtisOfPopularAlbums(String expectedArtist) {
        for (WebElement element : popularAlbumsList)
            Assert.assertEquals(getElementValue(element), expectedArtist, "the author is not " + expectedArtist);
    }
}

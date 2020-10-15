package pages;

import core.ActionByActions;
import core.ClickOn;
import core.Helper;
import core.JsActions;
import io.qameta.allure.Step;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
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

    public void elementValueIsAssessable(WebElement element) {
        boolean flag;
        do try {
            getElementValue(element);
            flag = false;
        } catch (StaleElementReferenceException e) {
            flag = true;
        }
        while (flag);
    }

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
    }

    @Step("choose the artist from the list")
    public void chooseArtist(String requiredArtist) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(StaleElementReferenceException.class);

        wait.until(driver -> new WebDriverWait(driver, 20).withMessage("searched result is missing").
                until(ExpectedConditions.visibilityOfAllElements(foundArtists)));
        if (foundArtists.size() != 0) {
            for (WebElement element : foundArtists) {
                elementValueIsAssessable(element);
                if (getElementValue(element).contains(requiredArtist)) {
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

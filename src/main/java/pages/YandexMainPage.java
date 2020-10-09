package pages;

import core.ClickOn;
import core.Helper;
import core.JsActions;
import data.NavigationLinksUrlsYandex;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class YandexMainPage extends PageObjectCreator implements ClickOn, JsActions, Helper {

    public YandexMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-id ='market']")
    WebElement marketLink;

    @FindBy(className = "b-langs")
    WebElement langButton;

    @FindBy(xpath = "//*[@class='menu__list-item']//a[contains(@href, 'lang')]/span")
    List<WebElement> langMenu;

    @FindBy(xpath = "//a[contains(@class, 'home-link_bold_yes')]")
    WebElement linkToPost;

    @FindBy(className = "geolink")
    WebElement geolinkSwitch;

    @FindBy(id = "city__front-input")
    WebElement cityChangeField;

    @FindBy(xpath = "//a[@data-id='more']")
    WebElement moreLink;

    @FindBy(xpath = "//div[@class ='services-new__more-popup-content']//a[@data-id and not (@style ='display: none;')]/div[@class='services-new__item-title']")
    List<WebElement> moreList;

    @FindBy(xpath = "//div[contains(text(),'Лондон')]")
    WebElement selectLondon;

    @FindBy(xpath = "//div[contains(text(),'Париж')]")
    WebElement selectParis;

    @Step("clicking on the link to the post authorization page")
    public void clickLinkToPostByMouse() {
        clickOnMouse(linkToPost);
    }

    @Step("check if a new tab is opened ")
    public void checkNewTab() {
        SoftAssert softAssert = new SoftAssert();

        for (NavigationLinksUrlsYandex someLink : NavigationLinksUrlsYandex.values()) {
            WebElement elementLink = driver.findElement(By.xpath("//a[@data-id ='" + someLink + "']"));
            clickOnMouse(elementLink);
            ArrayList<String> tabs = new ArrayList<>((driver).getWindowHandles());
            driver.switchTo().window(tabs.get(+1));
            new WebDriverWait(driver, 20)
                    .withMessage("a new tab is not opened")
                    .until(ExpectedConditions.urlContains(someLink.toString()));
            String currentUrl = driver.getCurrentUrl();
            softAssert.assertTrue(driver.getTitle().equals(someLink.getTitle()), "the: '" + driver.getTitle() +
                    "' is not equals to '" + someLink.getTitle() + "'\n");
            softAssert.assertTrue(currentUrl.contains(someLink.toString()), "tab+ " + currentUrl + " opened");
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
        softAssert.assertAll();
    }

    @Step("clicking on the language button")
    public void checkSwitchEnglish() {
        clickOnMouse(langButton);
    }

    @Step("checking languages")
    public void checkLanguages() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(langMenu));
        int langMenuSize = langMenu.size();
        for (int i = 0; i < langMenuSize; i++) {
            String elementLanguage = langMenu.get(i).getText();
            if (elementLanguage.contains("En")) {
                clickOnMouse(langMenu.get(i));
                break;
            }
            if (i == langMenuSize - 1) {
                clickOnMouse(langMenu.get(i));
                YandexLanguagePage yandexLanguagePage = new YandexLanguagePage(driver);
                yandexLanguagePage.clickOnLanguageButton();
                yandexLanguagePage.selectEnglish();
                yandexLanguagePage.clickSaveButton();
            }
        }
    }

    @Step("clicking on geolink")
    public void clickOnGeolink() {
        clickOnMouse(geolinkSwitch);
    }

    @Step("put London into the location field")
    public void putLondon() {
        cityChangeField.clear();
        putTextIntoField(cityChangeField, "Лондон В");
        new WebDriverWait(driver, 10)
                .withMessage("a popup list is not shown ")
                .until(ExpectedConditions.elementToBeClickable(selectLondon));
        new Actions(driver).moveToElement(cityChangeField).sendKeys(Keys.ENTER).perform();
    }

    @Step("put Paris into the location field")
    public void putParis() {
        cityChangeField.clear();
        putTextIntoField(cityChangeField, "Париж Ф");
        new WebDriverWait(driver, 10)
                .withMessage("a popup list is not shown ")
                .until(ExpectedConditions.elementToBeClickable(selectParis));
        new Actions(driver).moveToElement(cityChangeField).sendKeys(Keys.ENTER).perform();
    }

    @Step("clicking on morelink")
    public void clickOnMorelink() {
        clickOnMouse(moreLink);
    }

    @Step("get the list of addition services")
    public String getStringListMoreElements() {
        StringBuffer listMoreLocation = new StringBuffer();

        for (WebElement moreElement : moreList) {
            listMoreLocation.append(moreElement.getText());
        }
        return listMoreLocation.toString();
    }

    @Step("check the more lists of London and Paris")
    public void checkLists(String location1, String location2) {
        Assert.assertEquals(location1, location2, "The more lists are not equal!");
    }

    @Step("click on the market link")
    public void clickOnMarketLink() {
        clickOnMouse(marketLink);
    }

    @Step("switch to the market tab")
    public void switchToTheMarketTab() {
       switchToTheLastTab(driver);
    }
}
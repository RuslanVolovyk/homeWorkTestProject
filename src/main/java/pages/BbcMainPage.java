package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BbcMainPage extends core.PageObjectCreator implements ClickOn {

    public BbcMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='orb-search-q']")
    WebElement searchTextForm;

    @FindBy(xpath = "//button[@id='orb-search-button']")
    WebElement searchButton;

    @Step("clicking on the search button")
    public void searchButtonLeftMouseClick() {
        clickLeftButtonOfMouse(searchButton);
    }

    @Step("getting a title of the page")
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Step("putting a word into the search text box")
    public void sendTextIntoSearchTextForm(String word) {
        searchTextForm.sendKeys(word);
    }

    @Step("checking if the search text box form is enable")
    public void searchTextFormIsEnabled() {
        Assert.assertTrue(searchTextForm.isEnabled(), "ERROR The required search text form: "+ searchTextForm +
                " is absent!");
    }

    @Step("checking if the search text box form is displayed")
    public void searchTextFormIsDisplayed() {
        Assert.assertTrue(searchTextForm.isDisplayed(), "ERROR The wonted search form: " +searchTextForm +
                " is invisible!");
    }

    @Step("checking if the home page is not displayed")
    public void mainPageIsNotDisplayed() {
        Assert.assertNotEquals(getPageTitle(), "BBC - Homepage", "ERROR The " +getPageTitle()+
                " is displayed!");
    }
}

package tests;

import basetest.PageObjectCreator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.*;

public class BbcMainPage extends PageObjectCreator {

    public BbcMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='orb-search-q']")
    WebElement searchTextForm;

    @FindBy(xpath = "//button[@id='orb-search-button']")
    WebElement searchButton;

    @Step("clicking on the search button")
    public void searchButtonClick() {
        searchButton.click();
    }

    @Step("getting a title of the page")
    public String getTitle() {
        return super.driver.getTitle();
    }

    @Step("putting a word into the search text box")
    public void sendTextIntoSearchTextForm(String word) {
        searchTextForm.sendKeys(word);
    }

    @Step("checking if the search text box form is enable")
    public void searchTextFormIsEnabled() {
        assertTrue(searchTextForm.isEnabled(), "The required search text form is absent.");
    }

    @Step("checking if the search text box form is displayed")
    public void searchTextFormIsDisplayed() {
        assertTrue(searchTextForm.isDisplayed(), "Sorry,the search button is invisible!");
    }

    @Step("checking if the home page is not displayed")
    public void mainPageIsNotDisplayed() {
        assertNotEquals(getTitle(), "BBC - Homepage", "Something come up, we are on the main page again.");
    }
}

package tests;

import basetest.PageObjectCreator;
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

    public void searchButtonClick() {
        searchButton.click();
    }

    public String getTitle() {
        return super.driver.getTitle();
    }

    public void sendTextIntoSearchTextForm(String word) {
        searchTextForm.sendKeys(word);
    }

    public void searchTextFormIsEnabled() {
        assertTrue(searchTextForm.isEnabled(), "The required search text form is absent.");
    }

    public void searchTextFormIsDisplayed() {
        assertTrue(searchTextForm.isDisplayed(), "Sorry,the search button is invisible!");
    }

    public void mainPageIsNotDisplayed() {
        assertNotEquals(getTitle(), "BBC - Homepage", "Something come up, we are on the main page again.");
    }
}

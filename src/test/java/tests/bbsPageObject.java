package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bbsPageObject {
    WebDriver driver;

    public bbsPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='orb-search-q']")
    WebElement searchTextForm;

    @FindBy(xpath = "//button[@id='orb-search-button']")
    WebElement searchButton;

    @FindBy(css = "a")
    WebElement firstSelectorA;

    public void searchButtonClick() {
        searchButton.click();
    }

    public void sendTextIntoSearchTextForm(String word) {
        searchTextForm.sendKeys(word);
    }

    public void clickOnLink() {
        firstSelectorA.click();
    }
}

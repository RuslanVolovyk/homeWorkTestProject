package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BbcSearchPage extends core.PageObjectCreator {

    public BbcSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    WebElement firstSelectorA;


    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnLink() {
        firstSelectorA.click();
    }

    @Step("checking if the search page is not displayed")
    public void searchPageIsNotDisplayed() {
        Assert.assertTrue((getTitle().contains("BBC - Search result for")), "Something come up, we are on the main page again.");
    }
}

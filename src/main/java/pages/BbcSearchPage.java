package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BbcSearchPage extends core.PageObjectCreator implements ClickOn {

    public BbcSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    WebElement firstLinkSelector;


    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickOnFirstLink() {
        clickLeftButtonOfMouse(firstLinkSelector);
    }

    @Step("checking if the search page is not displayed")
    public void searchPageIsNotDisplayed() {
        Assert.assertTrue((getPageTitle().contains("BBC - Search result for")), "ERROR The BBC - search page is" +
                " shown! The page title is: " + getPageTitle());
    }
}

package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static data.YandexConstants.LOGIN;

public class YandexMailPage extends PageObjectCreator implements ClickOn {

    public YandexMailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "user-account__name")
    WebElement userName;

    @FindBy(className = "light-popup")
    WebElement userMenu;

    @FindBy(xpath = "//li[5]//span[@class='menu__text']")
    WebElement signOutLink;

    @Step("check the user name")
    public void checkUserName() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(userName));
        Assert.assertEquals(userName.getText(), LOGIN, "The user is not " + LOGIN);
    }

    @Step("click on user menu")
    public void clickOnUserMenu() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(userName));
        clickOnMouse(userName);
    }

    @Step("check the visibility of the user menu")
    public void checkUserMenuVisibility() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(userMenu));
        Assert.assertTrue(userMenu.isDisplayed(), "The user menu is invisible");
    }

    @Step("click on sign-out link")
    public void clickOnSignOutLink() {
        clickOnMouse(signOutLink);
    }
}

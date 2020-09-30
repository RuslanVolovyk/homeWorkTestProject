package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static data.YandexConstants.LOGIN;

public class YandexMailPage extends PageObjectCreator implements ClickOn {
    SoftAssert softAssert = new SoftAssert();

    public YandexMailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "user-account__name")
    WebElement userName;

    @FindBy(className = "light-popup")
    WebElement userMenu;

    @FindBy(partialLinkText = "Выйти из сервисов")
    WebElement signOutLink;

    @Step("check the user name")
    public void checkUserName() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(userName));
        softAssert.assertEquals(userName.getText(), LOGIN, "The user is not " + LOGIN);
    }

    @Step("click on user menu")
    public void clickOnUserMenu() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(userName));
        clickOnMouse(userName);
    }

    @Step("check the visibility of the user menu")
    public void checkUserMenuVisibility() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(userMenu));
        softAssert.assertTrue(userMenu.isDisplayed(), "The user menu is invisible");
    }

    @Step("click on sign-out link")
    public void clickOnSignOutLink() {
        clickOnMouse(signOutLink);
    }
}

package pages;

import core.ClickOn;
import core.JsActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.Set;

import static data.YandexConstants.*;

public class YandexAuthorizationsPage extends PageObjectCreator implements ClickOn, JsActions {

    SoftAssert softAssert = new SoftAssert();

    public YandexAuthorizationsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='passp-field-login']")
    WebElement loginInputField;

    @FindBy(className = "Textinput-Hint")
    WebElement errorMessage;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    WebElement passwordInputField;

    @FindBy(className = "Button2_type_submit")
    WebElement loginButton;

    @Step("switch to the new log-in passport tab ")
    public void switchToPassportTab() {
        Set<String> availableTabWindows = driver.getWindowHandles();
        if (availableTabWindows.size() != 1)
            for (String tabName : availableTabWindows)
                driver.switchTo().window(tabName);
    }

    @Step("clicking on the log-in button")
    public void leftMouseClickOnButtonIn() {
        clickOnMouse(loginButton);
    }

    @Step("input the 'andersentester' data into the log-in field")
    public void putLogin() {
        new WebDriverWait(driver, 20)
                .withMessage("login field not found")
                .until(ExpectedConditions.elementToBeClickable(loginInputField));
        putTextIntoField(loginInputField, LOGIN);
    }

    @Step("input the 'andersentester' data into the log-in field")
    public void putWrongLogin() {
        new WebDriverWait(driver, 20)
                .withMessage("login field not found")
                .until(ExpectedConditions.elementToBeClickable(loginInputField));
        putTextIntoField(loginInputField, WRONGLOGIN);
    }

    @Step("input the 'password123' value into the password field")
    public void putPassword() {
        putTextIntoField(passwordInputField, PASSWORD);
    }

    @Step("input the 'Nopassword123' wrong value into the password field")
    public void putWrongPassword() {
        putTextIntoField(passwordInputField, WRONGPASSWORD);
    }

    @Step("check an error message")
    public void checkErrorMessage() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(errorMessage));
        softAssert.assertTrue(errorMessage.isDisplayed(), "The wrong data input message is not shown ");
    }

    @Step("check the current URL")
    public void checkUrl() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(loginButton));
        softAssert.assertTrue(loginButton.isDisplayed(), "The user is not signed out ");
    }
}
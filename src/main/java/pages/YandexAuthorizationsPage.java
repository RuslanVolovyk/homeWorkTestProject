package pages;

import core.ClickOn;
import core.JsActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static data.YandexConstants.*;

public class YandexAuthorizationsPage extends PageObjectCreator implements ClickOn, JsActions {

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
    public void switchToTheLastTab() {
        switchToTheLastTab();
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

    @Step("check presence of  the error message 'wrong password'")
    public void checkWrongPasswordMessage() {
        SoftAssert softAssert = new SoftAssert();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(errorMessage));
        softAssert.assertTrue(errorMessage.isDisplayed(), "The wrong data input message is not shown ");
        softAssert.assertEquals(getElementValue(errorMessage), "Неверный пароль", "Error message is different");
        softAssert.assertAll();
    }

    @Step("check if any user signed")
    public void checkIfUserSigned() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(loginButton));
        Assert.assertTrue(loginButton.isDisplayed(), "The user is not signed out ");
    }

    @Step("check presence of the error message 'wrong account name'")
    public void checkWrongAccountMessage() {
        SoftAssert softAssert = new SoftAssert();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(errorMessage));
        softAssert.assertTrue(errorMessage.isDisplayed(), "The wrong data input message is not shown ");
        softAssert.assertEquals(getElementValue(errorMessage), "Такого аккаунта нет", "Error message is different");
        softAssert.assertAll();
    }
}
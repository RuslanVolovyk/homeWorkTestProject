package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static data.YandexConstants.*;

public class YandexAuthorizationsPage extends PageObjectCreator implements ClickOn {

    public YandexAuthorizationsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='passp-field-login']")
    WebElement loginInputField;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    WebElement passwordInputField;

    @FindBy(className = "Button2_type_submit")
    WebElement loginButton;

    @Step("clicking on the log-in button")
    public void leftMouseClickOnButtonIn() {
        clickLeftButtonOfMouse(loginButton);
    }

    @Step("input the 'andersentester' log-in into the log-in field")
    public void putLoginInput() {
        WebDriverWait wait100 = new WebDriverWait(driver, 300);
        WebElement emailField = wait100.until(ExpectedConditions.visibilityOf(loginInputField));
        loginInputField.sendKeys(LOGIN);
    }

    @Step("input the 'AutotestUser' log-in into the log-in field")
    public void putPasswordInput() {
        passwordInputField.sendKeys(PASSWORD);
    }


}


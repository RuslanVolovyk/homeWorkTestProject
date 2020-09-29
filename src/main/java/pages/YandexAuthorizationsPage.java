package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static data.YandexConstants.*;

public class YandexAuthorizationsPage extends PageObjectCreator implements ClickOn {


    public YandexAuthorizationsPage(WebDriver driver) {
        super(driver);
    }

    @Step("switch to the new log-in passport tab ")
    public void switchToPassportTab() {
        Set<String> availableTabWindows = driver.getWindowHandles();
        if (availableTabWindows.size() != 1)
            for (String tabNames : availableTabWindows)
                driver.switchTo().window(tabNames);
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

    @Step("input the 'andersentester' data into the log-in field")
    public void putLoginInput() {
        new WebDriverWait(driver, 20)
                .withMessage("login field not found")
                .until(ExpectedConditions.elementToBeClickable(loginInputField));
        loginInputField.sendKeys(LOGIN);
    }

    @Step("input the 'password123' value into the password field")
    public void putPasswordInput() {
        passwordInputField.sendKeys(PASSWORD);
    }
}
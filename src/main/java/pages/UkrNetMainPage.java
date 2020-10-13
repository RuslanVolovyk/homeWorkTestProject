package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static data.UkrNetConstans.*;

public class UkrNetMainPage extends PageObjectCreator implements ClickOn {

    public UkrNetMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='id-input-login']")
    WebElement loginField;

    @FindBy(xpath = "//input[@id='id-input-password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='form__submit']")
    WebElement submitButton;

    @FindBy(xpath = "//p[@id='id-user-email']")
    WebElement userId;

    @Step("input the login 'maksdid' into the login field ")
    public void inputLoginInLoginField() {
        loginField.sendKeys(NAME);
    }

    @Step("switch to the login iFrame ")
    public void switchToLoginIframe() {
        driver.switchTo().frame("mail widget");
    }

    @Step("input the password 'maclaut1' into the password field ")
    public void inputPasswordInPasswordField() {
        passwordField.sendKeys(PASSWORD);
    }

    @Step("clicking on the submit button")
    public void leftMouseClickOnButtonIn() {
        clickOnMouse(submitButton);
    }

    @Step("check the user name")
    public void checkUserName() {

        new WebDriverWait(driver, 50)
                .withMessage("user id not found")
                .until(ExpectedConditions.visibilityOf(userId));
        System.out.println("User name is: " + userId.getText());
        Assert.assertTrue(userId.getText().contains(NAME), "The user is not " + NAME);
    }
}

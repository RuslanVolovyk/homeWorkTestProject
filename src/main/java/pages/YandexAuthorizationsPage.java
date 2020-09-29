package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static data.YandexConstants.*;

public class YandexAuthorizationsPage extends PageObjectCreator implements ClickOn {



    public YandexAuthorizationsPage(WebDriver driver) {
        super(driver);
    }

    @Step("find element the log-in input field")
    public void getLoginInputField() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        loginInputField = (WebElement) js.executeScript("return document.getElementById('passp-field-login');");
//        loginInputField = (WebElement) js.executeScript("return document.getElementsByClassName('passp-field-login')[0];");
        System.out.println(loginInputField.toString());
    }

    @Step("switch to the login form ")
    public void switchToLoginForm() {
        driver.switchTo().window("post");
    }


    @Step("find the login form ")
    public void findToLoginForm() {
        System.out.println((driver.findElement(By.xpath("//div[@id='root']//form")).getLocation()));
    }


    @FindBy(xpath = "//*[@type='text']")
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
//        new WebDriverWait(driver, 20)
//                .withMessage("login field not found")
//                .until(ExpectedConditions.visibilityOf(loginInputField.get(0)));
//        loginInputField.get(0).sendKeys(LOGIN);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='enter the value here';", loginInputField);
    }

    @Step("input the 'AutotestUser' log-in into the log-in field")
    public void putPasswordInput() {
        passwordInputField.sendKeys(PASSWORD);
    }
}

///html//input[@id='passp-field-login']
//        /html//input[@id='passp-field-login']
//        input#passp-field-login

//*[@id="root"]/div/div/div[2]/div/div/div[2]/div[3]/div/div/div[1]/form/div[1]/div[1]/label
package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static data.YandexConstants.LOGIN;

public class YandexMailPage extends PageObjectCreator {

    public YandexMailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "user-account__name")
    WebElement userInsignia;

    @Step("check the user name")
    public void checkUserName() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(userInsignia));
        Assert.assertEquals(userInsignia.getText(), LOGIN, "The user is not " + LOGIN);
    }
}

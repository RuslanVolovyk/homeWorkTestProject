package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static data.YandexConstants.LOGIN;

public class YandexMailPage extends PageObjectCreator{

    public YandexMailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "user-account__name")
    WebElement userInsignia;

    @Step("check the user name")
    public  void checkUserName(){
        System.out.println("User name is: " +userInsignia.getText());
        Assert.assertEquals(userInsignia.getText(), LOGIN, "The user is not "+ LOGIN );
    }
}

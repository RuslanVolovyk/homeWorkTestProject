package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMainPage extends PageObjectCreator implements ClickOn {

    public YandexMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@class, 'home-link_bold_yes')]")
    WebElement linkToPost;

    @Step("clicking on the link to the post authorization page")
    public void clicktLinkToPostLeftMouseClick() {
        clickLeftButtonOfMouse(linkToPost);
    }
}



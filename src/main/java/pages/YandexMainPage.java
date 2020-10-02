package pages;

import core.ClickOn;
import data.NavigationLinksUrlsYandex;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class YandexMainPage extends PageObjectCreator implements ClickOn {

    public YandexMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@class, 'home-link_bold_yes')]")
    WebElement linkToPost;

    @Step("clicking on the link to the post authorization page")
    public void clickLinkToPostByMouse() {
        clickOnMouse(linkToPost);
    }

    @Step("check if a new tab is opened ")
    public void checkNewTab() {
        SoftAssert softAssert = new SoftAssert();

        for (NavigationLinksUrlsYandex someLink : NavigationLinksUrlsYandex.values()) {
            WebElement elementLink = driver.findElement(By.xpath("//a[@data-id ='" + someLink + "']"));
            clickOnMouse(elementLink);
            ArrayList<String> tabs = new ArrayList<>((driver).getWindowHandles());
            driver.switchTo().window(tabs.get(+1));
            new WebDriverWait(driver, 20)
                    .withMessage("a new tab is not opened")
                    .until(ExpectedConditions.urlContains(someLink.toString()));
            String currentUrl = driver.getCurrentUrl();
            softAssert.assertTrue(driver.getTitle().equals(someLink.getTitle()), "the: '" + driver.getTitle() +
                    "' is not equals to '" + someLink.getTitle() + "'\n");
            softAssert.assertTrue(currentUrl.contains(someLink.toString()), "tab+ " + currentUrl + " opened");
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
        softAssert.assertAll();
    }
}





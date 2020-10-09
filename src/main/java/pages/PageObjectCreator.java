package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public abstract class PageObjectCreator {

    protected WebDriver driver;

    public PageObjectCreator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getElementValue(WebElement element) {
        return element.getText();
    }

    public void switchToTheLastTab() {
        Set<String> availableTabWindows = driver.getWindowHandles();
        if (availableTabWindows.size() > 1)
            for (String tabName : availableTabWindows)
                driver.switchTo().window(tabName);
    }
}

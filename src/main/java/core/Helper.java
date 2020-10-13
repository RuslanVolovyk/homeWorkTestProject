package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public interface Helper {

    default String getElementValue(WebElement element) {
        return element.getText();
    }

    default void switchToTheLastTab(WebDriver driver) {
        Set<String> availableTabWindows = driver.getWindowHandles();
        if (availableTabWindows.size() > 1)
            for (String tabName : availableTabWindows)
                driver.switchTo().window(tabName);
    }
}

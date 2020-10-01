package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public interface ActionByActions {

    default void clickMouse(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.click(element).perform();
    }
}

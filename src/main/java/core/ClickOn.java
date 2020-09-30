package core;

import org.openqa.selenium.WebElement;

public interface ClickOn {

    default void clickOnMouse(WebElement element) {
        element.click();
    }
}
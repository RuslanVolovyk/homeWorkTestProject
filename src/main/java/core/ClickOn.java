package core;

import org.openqa.selenium.WebElement;

public interface ClickOn {

    default void clickLeftButtonOfMouse(WebElement element) {
            element.click();
    }
}
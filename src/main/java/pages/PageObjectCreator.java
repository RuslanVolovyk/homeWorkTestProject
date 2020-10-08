package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObjectCreator {

    protected WebDriver driver;

    public PageObjectCreator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getElementValue(WebElement element) {
        return element.getText();
    }
}

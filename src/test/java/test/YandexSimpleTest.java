package test;

import core.MultiToneChrome;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import data.YandexConstants.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class YandexSimpleTest {
    private WebDriver driver;

    private JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        driver = MultiToneChrome.getInstance().driver;
        js = (JavascriptExecutor) driver;

//        // Maximize the browser's window
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testJavaScriptExecution() throws Exception {
        // Navigation
        // driver.get(baseUrl);
        js.executeScript("window.location = BASE_URL;");

        // driver.get() method waits for the page to load completely before going to the next statement
        // Adding Thread.sleep() because we are opening URL using js.executeScript() and it does not wait for the page to load completely
        // If we do not add wait, then Selenium WebDriver will immediately try to find the element and it might have issues with just a little slow connection
        Thread.sleep(3000);
        // Finding element
        // WebElement textBox = driver.findElement(By.id("name"));
//        WebElement lpostLink = (WebElement) js.executeScript("return document.getElementById('name');");
//        textBox.sendKeys("test");
    }



}

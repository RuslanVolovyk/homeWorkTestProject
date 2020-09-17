package basetest;

import core.SingletonChrome;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public static final String baseUrl = "https://bbc.com";

    @BeforeClass
    public void setUp() {
        SingletonChrome instanceDriver = SingletonChrome.initDriver();
        driver = instanceDriver.getDriver();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

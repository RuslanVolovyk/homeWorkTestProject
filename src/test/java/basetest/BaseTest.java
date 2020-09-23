package basetest;

import core.SingletonChrome;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        SingletonChrome instanceDriver = SingletonChrome.initDriver();
        driver = instanceDriver.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}

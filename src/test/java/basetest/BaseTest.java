package basetest;

import core.SingletonChrome;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static core.SingletonChrome.getInstance;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = getInstance().getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}

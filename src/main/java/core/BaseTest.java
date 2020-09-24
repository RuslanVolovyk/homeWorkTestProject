package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static core.MultiToneChrome.getInstance;

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

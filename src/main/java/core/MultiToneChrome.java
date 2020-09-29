package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MultiToneChrome extends WebDriverOptions {

    public WebDriver driver;
    private static ThreadLocal<MultiToneChrome> driverThread = new ThreadLocal<>();

    private MultiToneChrome() {
    }

    public static MultiToneChrome getInstance() {
        if (driverThread.get() == null) {
            synchronized (MultiToneChrome.class) {
                driverThread.set(new MultiToneChrome());
            }
        }
        return driverThread.get();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = initialDriver();
            return driver;
        } else {
            return driver;
        }
    }

    public void destroy() {
        if (driver != null) {
            getDriver().quit();
            driver = null;
        }
    }

    private synchronized WebDriver initialDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/web-drivers/chromedriver");
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS).setScriptTimeout(10, TimeUnit.SECONDS);
        return driver;
    }
}

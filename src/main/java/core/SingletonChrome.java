package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonChrome extends WebDriverOptions {

    private SingletonChrome() {
    }

    public static SingletonChrome getInstance() {
        if (driverThread.get() == null) {
            synchronized (SingletonChrome.class) {
                driverThread.set(new SingletonChrome());
            }
        }
        return driverThread.get();
    }

    private static ThreadLocal<SingletonChrome> driverThread = new ThreadLocal<>();

    public WebDriver driver;

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
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/web-drivers/chromedriver2.exe");
        driver = new ChromeDriver(getChromeOptions());
        return driver;
    }
}

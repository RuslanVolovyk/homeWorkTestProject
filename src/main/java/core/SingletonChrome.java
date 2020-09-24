package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonChrome extends WebDriverOptions {

    private static SingletonChrome instance = null;
    private WebDriver driver;

    private SingletonChrome() {
    }

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/web-drivers/chromedriver2.exe");
        driver = new ChromeDriver(getChromeOptions());
        return driver;
    }

    public static SingletonChrome initDriver() {
        if (instance == null)
            instance = new SingletonChrome();
        return instance;
    }
}

package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonChrome extends WebDriverOptions {

    private static SingletonChrome instance = null;
    private WebDriver driver;

    private SingletonChrome() {
    }

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "web-drivers/chromedriver");
        driver = new ChromeDriver(getChromeOptions());
        return driver;
    }

    public static SingletonChrome startDriver() {
        if (instance == null)
            instance = new SingletonChrome();
        return instance;
    }
}

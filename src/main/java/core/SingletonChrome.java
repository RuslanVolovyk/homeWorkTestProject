package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonChrome {

    private static SingletonChrome instance = null;
    private WebDriver driver;

    private SingletonChrome() {
    }

    public WebDriver openBrowser() {

        WebDriverOptions.chromeStartOption();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;

    }

    public static SingletonChrome startDriver() {
        if (instance == null)
            instance = new SingletonChrome();

        return instance;

    }


}

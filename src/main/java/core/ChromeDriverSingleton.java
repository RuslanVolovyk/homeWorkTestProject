package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeDriverSingleton {

    private static ChromeDriverSingleton instance;

    ChromeDriverSingleton(){
    }

    public static ChromeDriverSingleton getInstance(){
        if (instance == null)
            instance = new ChromeDriverSingleton();
        return instance;
    }

//
    public WebDriver startDriver(){
        System.setProperty("webdriver.chrome.driver", "/home/maksym/web_drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
        }

}

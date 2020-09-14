package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class StartFirefoxSelenium {
    public static void main(String[] args) {

        String baseURL = "https://bbc.com";
        System.setProperty("webdriver.gecko.driver", "/home/maksym/web_drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"orb-search-q\"]")).sendKeys("java");




    }

}

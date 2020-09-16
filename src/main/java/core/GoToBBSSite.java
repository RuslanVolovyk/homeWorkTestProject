package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoToBBSSite {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        String baseURL = "https://bbc.com";
        SingletonChrome chromeDriver = SingletonChrome.initDriver();

        driver = chromeDriver.getDriver();
        driver.get(baseURL);
        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys("java");
        driver.findElement(By.xpath("//button[@id='orb-search-button']")).click();
        driver.findElement(By.cssSelector("a")).click();
        Thread.sleep(2000);
        driver.close();
    }
}

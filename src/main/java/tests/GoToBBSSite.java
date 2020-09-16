package tests;

import core.SingletonChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoToBBSSite {

    WebDriver driver;
    String baseUrl;

    @BeforeClass
    public void setUp() {
        SingletonChrome instanceDriver = SingletonChrome.initDriver();
        driver = instanceDriver.getDriver();
        baseUrl = "https://bbc.com";
    }

    @Test
    public void testBBSSite() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys("java");
        driver.findElement(By.xpath("//button[@id='orb-search-button']")).click();
        driver.findElement(By.cssSelector("a")).click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

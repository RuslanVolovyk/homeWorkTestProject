package tests;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GoToBBSSiteTest extends BaseTest {

    @Test
    public void testBBSSite() {
        String baseUrl = "https://bbc.com";
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys("java");
        driver.findElement(By.xpath("//button[@id='orb-search-button']")).click();
        driver.findElement(By.cssSelector("a")).click();
    }

}

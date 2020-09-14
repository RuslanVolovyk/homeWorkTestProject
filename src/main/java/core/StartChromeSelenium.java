package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class StartChromeSelenium {

    public  static  void  main (String [] args) throws Exception{

        String baseURL = "https://bbc.com";

        ChromeDriverSingleton driver1 = new ChromeDriverSingleton();
        WebDriver driver =driver1.startDriver();


        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"orb-search-q\"]")).sendKeys("java");
        driver.findElement(By.xpath("//*[@id=\"orb-search-button\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a")).click();
        Thread.sleep(5000);
        driver.close();




    }
}

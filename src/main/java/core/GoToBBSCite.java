package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoToBBSCite {

    public static void main(String[] args) {

        WebDriver driver;
        String baseURL = "https://bbc.com";
        SingletonChrome instanceDriver = SingletonChrome.startDriver();

        driver = instanceDriver.openBrowser();
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys("java");
        driver.findElement(By.xpath("//button[@id='orb-search-button']")).click();
        driver.findElement(By.cssSelector("a")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}


//    WebDriver driver;

//    @BeforeMethod
//    public  void setDriver(){
//        SingletonChrome instanceDriver = SingletonChrome.startDriver();
//        driver = instanceDriver.openBrowser();
//    }
//
//    @Test
//    public void test1(){
//        driver.get(baseURL);
//        driver.findElement(By.xpath("//*[@id=\"orb-search-q\"]")).sendKeys("java");
//        driver.findElement(By.xpath("//*[@id=\"orb-search-button\"]")).click();
////        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("a")).click();
////        Thread.sleep(5000);
//        driver.close();
//
//    }
//
//    @AfterMethod
//    public void tearDawn(){
//        driver.quit();
//    }
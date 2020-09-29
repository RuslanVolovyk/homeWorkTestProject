package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OpenOpera {

    static  WebDriver driver;

    public  static  void main(String[] args){
        System.setProperty("webdriver.opera.driver","/home/maksym/IdeaProjects/homeWorkTestProject/web-drivers/operadriver");
        driver =new OperaDriver();
        driver.manage().window().maximize();
        driver.get("https://yandex.by");
        driver.quit();
    }
}

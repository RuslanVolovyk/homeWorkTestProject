package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OpenOpera {
    public  static  void main(String[] args){
        System.setProperty("webdriver.opera.driver","/home/maksym/IdeaProjects/homeWorkTestProject/web-drivers/operadriver");
        WebDriver driver1 =new OperaDriver();
        driver1.manage().window().maximize();
        driver1.get("https://yandex.by");
        driver1.quit();
    }
}

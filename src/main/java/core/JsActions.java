package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsActions {
     private JavascriptExecutor js = null;
     private WebDriver driver = null;

    public void setupJs(){
        js =(JavascriptExecutor) driver;

    }


}

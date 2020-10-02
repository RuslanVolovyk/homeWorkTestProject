package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface JsActions {

    default WebElement findElementWithJsById(WebDriver driver, String elementId) {
        String javascript = "document.getElementById('" + elementId + "')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript(javascript);
    }

    default void clickLeftMouseWithJs(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    default void inputTextWithJs(WebDriver driver, WebElement element, String text){
        String javascript ="arguments[0].value ='"+text+"';" ;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(javascript, element);

    }

    default void setWebElementAttributeWithJs(WebDriver driver, WebElement element, String attribute){
        String javascript ="arguments[0]..setAttribute(arguments[1], arguments[2]);" ;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(javascript, element);

    }

}
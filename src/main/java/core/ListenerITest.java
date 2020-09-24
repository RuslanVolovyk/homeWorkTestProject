package core;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;


public class ListenerITest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Now starting test " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Successfully completed test: " + result.getName());
        MultiToneChrome.getInstance().destroy();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*** test execution " + result.getMethod().getMethodName() + " failed!");
        saveScreenShot(MultiToneChrome.getInstance().driver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Name: " + result.getName() + "skipped!");
        MultiToneChrome.getInstance().destroy();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Name: " + result.getName() + " failed but within success percentage");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Name: " + context.getName() + " are starting.");
        ITestNGMethod[] methods = context.getAllTestMethods();
        System.out.println("This methods will be executed in this test tag:");
        for (ITestNGMethod method : methods)
            System.out.println(method.getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test  " + context.getName() + " on finish");

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public void saveScreenShot(WebDriver driver) {
        Allure.getLifecycle().addAttachment("Failure screenshot", "image/png", "",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }

    @Attachment(value = "(0)", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}
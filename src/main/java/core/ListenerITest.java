package core;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;


public class ListenerITest implements ITestListener, ISuiteListener, IInvokedMethodListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart-> Test Name: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess-> Test Name: " + result.getName());
        MultiToneChrome.getInstance().destroy();
    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        System.out.println("*** Ups.. test execution " + result.getMethod().getMethodName() + " failed...");
//        System.out.println("Screenshot captured for test case: " + result.getMethod());
//        saveScreenShot();
//        saveTextLog(result.getMethod() + "failed and screenshot taken!!");
//    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*** Ups.. test execution " + result.getMethod().getMethodName() + " failed...");
        // WebDriver driver = SingletonChrome.initDriver().getDriver();
        // saveScreenShot(driver);
        MultiToneChrome.getInstance().destroy();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped-> Test Name: " + result.getName());
        MultiToneChrome.getInstance().destroy();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage-> Test Name: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onTestSkipped-> Test Name: " + context.getName());
        ITestNGMethod[] methods = context.getAllTestMethods();
        System.out.println("This methods will be executed in this test tag:");
        for (ITestNGMethod method : methods)
            System.out.println(method.getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish-> Test Name: " + context.getName());

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public void saveScreenShot(WebDriver driver) {
        Allure.getLifecycle().addAttachment("Failure screenshot", "image/png", "", ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));

    }

    @Attachment(value = "(0)", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void onStart(ISuite iSuite) {

    }

    @Override
    public void onFinish(ISuite iSuite) {
        MultiToneChrome.getInstance().destroy();
    }
}

//    @Override
//    public void afterStepUpdate(StepResult result) {
//        byte[] screenShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
//        Allure.getLifecycle().addAttachment(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png", screenShot);
//    }
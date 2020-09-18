package tests;

import org.testng.*;

public class ListenerITest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart-> Test Name: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess-> Test Name: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure-> Test Name: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped-> Test Name: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage-> Test Name: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
//        Before <test> tag of xml file
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
}

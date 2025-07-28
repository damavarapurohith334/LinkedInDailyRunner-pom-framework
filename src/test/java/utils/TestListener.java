package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;

public class TestListener extends BaseTest implements ITestListener {

//    private static ExtentReports extent = ExtentReportManager.getReportInstance();
    // Thread safe instance for parallel execution
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test execution finished: " + context.getName());
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
//        extent.createTest(result.getName());
        test.log(Status.INFO, "Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Get the driver from BaseTest or result
        WebDriver driver = BaseTest.driver;
        String methodName = result.getName();
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, methodName);
        System.out.println("Screenshot captured for failed test: " + screenshotPath);

        // Optionally, log link to ExtentReports or TestNG report:
        // For ExtentReports
        base.BaseTest.test.addScreenCaptureFromPath(screenshotPath);
        // For TestNG default report
        org.testng.Reporter.log("<a href='" + screenshotPath + "'>Screenshot</a>");
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
        test.log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getName());
        test.log(Status.WARNING, "Test failed but within success percentage");
    }
}
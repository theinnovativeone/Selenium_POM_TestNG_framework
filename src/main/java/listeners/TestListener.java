package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import base.BasePage;
import reporter.ExtentManager;
import reporter.ExtentTestManager;

public class TestListener implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(Status.INFO, "Test started: " + result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context) {
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
	
	public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed!!!! " + result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed!!!! " + result.getMethod().getMethodName());

		ExtentTestManager.getTest().log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(Status.INFO, "Error stack trace for the test: " + result.getThrowable());

		String testclassName = result.getTestClass().getName();
		String testmethodName = result.getName();
		String screenshotName = testmethodName + ".png";
		String fileseparator = System.getProperty("file.separator");
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		String screenshotTargetPath = System.getProperty("user.dir") + fileseparator + "Current_test_results" + fileseparator + "Screenshots" + fileseparator + testclassName + "_" + timestamp + fileseparator + screenshotName;

		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");

//		capture a screenshot using getScreenshot method (defined in Base Page)
		String targetPath = null;
		try {
			targetPath = BasePage.getScreenshot(driver, result.getMethod().getMethodName(), screenshotTargetPath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

//		attach the screenshot taken with extent report
		ExtentTestManager.getTest().info("Screenshot for failed test case: ", MediaEntityBuilder.createScreenCaptureFromPath(targetPath).build());

	}
}

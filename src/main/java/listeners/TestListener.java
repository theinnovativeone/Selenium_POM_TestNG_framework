package listeners;

import java.io.IOException;
import Utils.Utilities;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import reporter.ExtentManager;
import reporter.ExtentTestManager;

public class TestListener implements ITestListener{

	private static final Logger logger = LogManager.getLogger(TestListener.class);
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(Status.INFO, "Test started: " + result.getMethod().getMethodName());
		logger.info("Test started: " + result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context) {
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
	
	public void onTestSuccess(ITestResult result) {
		logger.info("Test passed: " + result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Test failed: " + result.getMethod().getMethodName());

		ExtentTestManager.getTest().log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(Status.INFO, "Error stack trace for the test: " + result.getThrowable());

		String testclassName = result.getTestClass().getName();
		String testmethodName = result.getName();
		String screenshotName = testmethodName + ".png";
		String fileseparator = System.getProperty("file.separator");
		
		String screenshotTargetPath = System.getProperty("user.dir") + fileseparator + "Current_test_results" + fileseparator + "Screenshots" + fileseparator + testclassName + "_" + Utilities.getTimestamp() + fileseparator + screenshotName;

		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");

//		capture a screenshot using getScreenshot method (defined in Base Page)
		String targetPath = null;
		try {
			targetPath = Utilities.getScreenshot(driver, result.getMethod().getMethodName(), screenshotTargetPath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

//		attach the screenshot taken with extent report
		ExtentTestManager.getTest().info("Screenshot for failed test case: ", MediaEntityBuilder.createScreenCaptureFromPath(targetPath).build());
	}
}

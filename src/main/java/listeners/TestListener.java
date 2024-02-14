package listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BasePage;

public class TestListener implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed!! " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		
		String testclassName = result.getTestClass().getName();
		String testmethodName = result.getName();
		String screenshotName = testmethodName + ".png";
		String fileseparator = System.getProperty("file.separator");
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		String screenshotTargetPath = System.getProperty("user.dir") + fileseparator + "FailedScreenshots" + fileseparator + testclassName + "_" + timestamp + fileseparator + screenshotName;
		
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		try {
			BasePage.getScreenshot(driver, result.getMethod().getMethodName(), screenshotTargetPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

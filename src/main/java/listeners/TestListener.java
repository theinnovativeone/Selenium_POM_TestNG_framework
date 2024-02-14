package listeners;

import java.io.IOException;
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
		LocalDateTime currentDateTime = LocalDateTime.now(); 
//		String targetPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "FailedScreenshots" + System.getProperty("file.separator") + result.getTestClass().getName() + "_" + currentDateTime + System.getProperty("file.separator") + result.getName() + ".png";
		
		String targetPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "FailedScreenshots" + System.getProperty("file.separator") + result.getName() + ".png";
		System.out.println("current time is: " + targetPath);
		
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		try {
			BasePage.getScreenshot(driver, result.getMethod().getMethodName(), targetPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BasePage;

public class TestListener implements ITestListener{
	
	public void onTestPass(ITestResult result) {
		System.out.println("Test passed!! " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		String targetPath = ".//FailedScreenshots//" + result.getName() + ".png";
		
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

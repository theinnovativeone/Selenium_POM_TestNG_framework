package tests;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.LogoutPage;
import reporter.ExtentTestManager;

public class LogoutTests extends BaseTest{

	private static final Logger logger = LogManager.getLogger(LogoutTests.class);
	LoginPage lp;
	LogoutPage lgp;
	
	@Test (groups = {"Regression", "Sanity"})
	public void Logout() {
		lp = new LoginPage(driver);
		lgp = new LogoutPage(driver);
		
		lp.login();
		logger.info("Logged in successfully!");
		ExtentTestManager.getTest().log(Status.INFO, "Logged in successfully!");

		lgp.logout();
		logger.info("Clicked on Logout option from the main menu");
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Logout option from the main menu");

		logger.info("Verify that if logout is successful!");
		ExtentTestManager.getTest().log(Status.INFO, "Verify that if logout is successful!");
		Assert.assertTrue(lp.isOnLoginPage());
	}
	
}

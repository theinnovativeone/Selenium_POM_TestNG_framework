package tests;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import reporter.ExtentTestManager;

public class LoginTests extends BaseTest{

	private static final Logger logger =LogManager.getLogger(LoginTests.class);
	LoginPage lp;
	
	@Test
	public void loginValidCreds() {
		lp = new LoginPage(driver);
		lp.goToSignIn();
		logger.info("Navigated to the sign in page");
		ExtentTestManager.getTest().log(Status.INFO, "Navigated to the sign in page");

		lp.enterEmail("validEmail");
		logger.info("Entered valid email in the Email field");
		ExtentTestManager.getTest().log(Status.INFO, "Entered valid email in the Email field");

		lp.clickOnContinue();
		logger.info("Clicked on Continue button");
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Continue button");

		lp.enterPassword("validPassword");
		logger.info("Entered valid password in the Password field");
		ExtentTestManager.getTest().log(Status.INFO, "Entered valid password in the Password field");

		lp.clickOnSignIn();
		logger.info("Clicked on Sign in button");
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Sign in button");

		logger.info("Verify if login is successful with valid email and password");
		ExtentTestManager.getTest().log(Status.INFO, "Verify if login is successful with valid email and password");
		Assert.assertTrue(lp.isOnHomePage());
	}
	
	@Test
	public void loginEmailFieldBlank() {
		lp = new LoginPage(driver);

		lp.goToSignIn();
		logger.info("Navigated to the sign in page");
		ExtentTestManager.getTest().log(Status.INFO, "Navigated to the sign in page");

		lp.clickOnContinue();
		logger.info("Clicked on Continue button");
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Continue button");

		logger.info("Verify that login should be failed if email field is blank");
		ExtentTestManager.getTest().log(Status.INFO, "Verify that login should be failed if email field is blank");
		Assert.assertTrue(lp.isEmailErrorMessagePresent());
	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTests extends BaseTest{

	LoginPage lp;
	
	@Test
	public void loginValidCreds() {
		lp = new LoginPage(driver);
		lp.goToSignIn();
		lp.enterEmail("validEmail");
		lp.clickOnContinue();
		lp.enterPassword("validPassword");
		lp.clickOnSignIn();	
		Assert.assertTrue(lp.isOnHomePage());
	}
	
	@Test
	public void loginEmailFieldBlank() {
		lp = new LoginPage(driver);
		lp.goToSignIn();
		lp.clickOnContinue();
		Assert.assertTrue(lp.isEmailErrorMessagePresent());
	}
	
}

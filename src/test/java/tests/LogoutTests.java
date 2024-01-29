package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTests extends BaseTest{
	
	LoginPage lp;
	LogoutPage lgp;
	
	@Test
	public void Logout() {
		lp = new LoginPage(driver);
		lgp = new LogoutPage(driver);
		
		lp.login();
		lgp.logout();
		
		Assert.assertTrue(lp.isOnLoginPage());
	}
	
}

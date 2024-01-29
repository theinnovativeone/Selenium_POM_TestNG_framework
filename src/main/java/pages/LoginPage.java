package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage{
	
	protected final WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement signoption;
	
	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement emailfield;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueCTA;  
	
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement passwordfield;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signIn;
	
	@FindBy(xpath = "//div[contains(text(),\"Enter your email or mobile phone number\")]")
	WebElement emailErrMsg;
	
	public void goToSignIn() {
		clickIt(signoption);
	}
	
	public void enterEmail(String validEmail) {
		enterText(emailfield, validEmail);
	}
	
	public void clickOnContinue() {
		clickIt(continueCTA);
	}

	public void enterPassword(String validPassword) {
		enterText(passwordfield, validPassword);
	}
	
	public void clickOnSignIn() {
		clickIt(signIn);
	}
	
	public void login() {
		clickIt(signoption);
		enterText(emailfield, "validEmail");
		clickIt(continueCTA);
		enterText(passwordfield, "validPassword");
		clickIt(signIn);
	}
	
	public boolean isOnHomePage() {
		return driver.getTitle().contains("Online Shopping site in India");
	}
	
	public boolean isOnLoginPage() {
		return driver.getTitle().contains("Amazon Sign In");
	}
	
	public boolean isEmailErrorMessagePresent() {
		return isPresent(emailErrMsg);
	}
}

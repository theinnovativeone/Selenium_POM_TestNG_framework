package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LogoutPage extends BasePage{
	
	protected final WebDriver driver;
	
	@FindBy(xpath = "//a[@id=\"nav-link-accountList\"]") WebElement mainMenu;
	@FindBy(xpath = "//span[contains(text(),'Sign Out')]") WebElement signOut;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		mouseHover(mainMenu, driver);
		mouseHover(signOut, driver);
		clickIt(signOut);
	}
}

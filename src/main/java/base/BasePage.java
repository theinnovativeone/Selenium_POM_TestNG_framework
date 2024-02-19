package base;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import Utils.PropertyFileReader;

public class BasePage {
	
	public String readFromFile(String data) {
		return PropertyFileReader.getTestData(data);
	}
	
	public void clickIt(WebElement locator) {
		locator.click();
	}
	
	public void enterText(WebElement locator, String text) {
		locator.sendKeys(readFromFile(text));
	}
	
	public void sendTextExcel(WebElement locator, String text) {
		locator.sendKeys(text);
	}
	
	public boolean isPresent(WebElement locator) {
		return locator.isDisplayed();
	}
	
	public void mouseHover(WebElement locator, WebDriver driver) {
		Actions action = new Actions(driver);
//		to mouse hover over an element
		action.moveToElement(locator).perform();
	}
	
	public String getElementText(WebElement locator) {
		return locator.getAttribute("value");
	}

	
//	public boolean checkSortingLowToHigh(List<WebElement> listLocator, WebElement locator) {
//		
//	}
}

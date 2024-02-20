package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

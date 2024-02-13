package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import base.BasePage;

public class AddToCartPage extends BasePage{
	protected final WebDriver driver;
	
	public AddToCartPage(ITestContext context) {
		this.driver = (WebDriver) context.getAttribute("WebDriver");;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#add-to-cart-button.a-button-input") WebElement AddToCartBTN;
	
//	@FindBy(xpath = "//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='rightCol']/div[@id='desktop_buybox']/div[@id='buybox']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[16]/div[1]/span[1]/span[1]/span[1]/input[1]") WebElement AddToCartBTN;
	
	@FindBy(xpath = "//span[@class=\"a-truncate-cut\"]") WebElement addedProductTitle;
	
	@FindBy(xpath = "//input[@aria-labelledby=\"attach-sidesheet-view-cart-button-announce\"]") WebElement goTOCartBTN;
	
	public void clickOnAddToCart(ITestContext context) {
//		clickIt(AddToCartBTN);
		System.out.println("get text of element on clickOnAddTOCart: " + AddToCartBTN.getText());

		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click;", AddToCartBTN);
	}
	
	public void goTOCart(ITestContext context) {
		System.out.println("get text of element on goTOCart: " + goTOCartBTN.getText());

//		clickIt(goTOCartBTN);
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click;", goTOCartBTN);
	}
	public String getProductTitleInCart() {
		String title = getElementText(addedProductTitle);
		return title;
	}
	
}

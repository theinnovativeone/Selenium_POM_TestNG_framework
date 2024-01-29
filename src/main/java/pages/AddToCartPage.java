package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class AddToCartPage extends BasePage{
	protected final WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id=\"add-to-cart-button\"]") WebElement AddToCartBTN;
	
	@FindBy(xpath = "//span[@class=\"a-truncate-cut\"]") WebElement addedProductTitle;
	
	@FindBy(xpath = "//a[@href=\"/cart?ref_=sw_gtc\"]") WebElement goTOCartBTN;
	
	public void clickOnAddToCart() {
		clickIt(AddToCartBTN);
	}
	
	public void goTOCart() {
		clickIt(goTOCartBTN);
	}
	public String getProductTitleInCart() {
		String title = getElementText(addedProductTitle);
		return title;
	}
	
}

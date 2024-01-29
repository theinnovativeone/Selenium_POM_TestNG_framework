package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import base.BasePage;

public class ProductDetailsPage extends BasePage{

	protected final WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(css = "div#a-section a-spacing-base") WebElement pdp;
	
	@FindBy(xpath = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]")
	WebElement pdp;
	
	@FindBy(xpath = "//span[@id='productTitle']") 
	WebElement pdpTitle;
	
	public void openPDP(ITestContext context) throws InterruptedException {
		
		Thread.sleep(2000);
		clickIt(pdp);
		System.out.println("opened pdp");
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	}
	
	public String getProductTitleOnPDP() {
		return getElementText(pdpTitle);
	}
}

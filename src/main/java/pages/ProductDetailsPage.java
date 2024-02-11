package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import base.BasePage;

public class ProductDetailsPage extends BasePage{

	protected final WebDriver driver;
	
	public ProductDetailsPage(ITestContext context) {		
		this.driver = (WebDriver) context.getAttribute("WebDriver");
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(css = "div#a-section a-spacing-base") WebElement pdp;
	
//	@FindBy(xpath = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]")
//	WebElement pdp;
	
	@FindBy(xpath = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/a[1]/div[1]/img[1]")
	WebElement pdp;
	
	@FindBy(xpath = "//span[@id='productTitle']") 
	WebElement pdpTitle;
	
	public void openPDP(ITestContext context) throws InterruptedException {
		
		Thread.sleep(2000);
		
		System.out.println("get the text of element pdp: " + pdp.getText());
		clickIt(pdp);

		System.out.println("opened pdp");
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		System.out.println("opened pdp 2");
		System.out.println("New page title on openPDP: " + driver.getTitle());

	}
	
	public String getProductTitleOnPDP(ITestContext context) {
		
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		System.out.println("Inside function getProductTitleOnPDP()!!");
		System.out.println("New page title on getProductTitleOnPDP: " + driver.getTitle());
//		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		
		String title = getElementText(pdpTitle);
		return title;
	}
}

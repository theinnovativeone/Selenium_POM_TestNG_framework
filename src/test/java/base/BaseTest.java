package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

	protected WebDriver driver = null;
	protected String browsername = null;
	
	@BeforeMethod
	public void setUp(ITestContext context) {
		browsername = "edge";
		driver = getDriver(browsername);
		context.setAttribute("WebDriver", driver);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	@AfterMethod
	public void teardown() {
//		if (null != driver) {
//			driver.quit();
//		}
		
		if (null != driver) {
			driver.close();
		}
		if (driver == null) {
	        driver.quit();
	    }
	}
	
	private static WebDriver getDriver(String browserName) {
	
		if (browserName.equalsIgnoreCase("chrome")) {
			return new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			return new EdgeDriver();
		}
		
		return null;
	}
}

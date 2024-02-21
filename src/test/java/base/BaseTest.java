package base;

import Utils.PropertyFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	protected static WebDriver driver = null;
	protected String browsername = null;
	
	@BeforeMethod
	public void setUp(ITestContext context) {

		browsername = PropertyFileReader.getConfigData("browser");
		driver = getDriver(browsername);
		logger.info("Initialized the driver");

		context.setAttribute("WebDriver", driver);

		driver.manage().window().maximize();
		logger.info("Maximized the window");

		driver.get(PropertyFileReader.getConfigData("url"));
		logger.info("Opened the test url: " + PropertyFileReader.getConfigData("url"));
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
		logger.info("Closed the driver instance");
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

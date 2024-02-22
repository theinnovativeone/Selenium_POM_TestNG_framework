package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import java.sql.DriverManager;
import java.time.Duration;

public class WaitUtilities {

    public static void smartWait(ITestContext context) throws InterruptedException {
        String t= "true";
        if (t.trim().toLowerCase().equals("true")) {
            waitForPageLoaded(context);
        }
        Thread.sleep(4000);
    }

    /**
     * Wait for a page to load within the given time (in seconds)
     */
    public static void waitForPageLoaded(ITestContext context) {
        WebDriver driverr = (WebDriver) context.getAttribute("WebDriver");
        WebDriverWait wait = new WebDriverWait(driverr, Duration.ofSeconds(40), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driverr;

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
//            LogUtils.info("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load. (" + "40" + "s)");
            }
        }
    }
}

package reporter;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();
	
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long)(Thread.currentThread().getId()));
	}
	
	public static synchronized void endTest() {
		extent.flush();
	}
	
	public static synchronized ExtentTest startTest(String testname) {
		ExtentTest test = extent.createTest(testname);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
}

package reporter;

import java.io.File;

import Utils.PropertyFileReader;
import Utils.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
    private static String reportName = "Test-Automation-Report" + Utilities.getTimestamp() + ".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") + fileSeperator + "Current_test_results";
    private static String reportFileLocation =  reportFilepath + fileSeperator + reportName;
	
	public static ExtentReports getInstance() {
		if(extent == null) {
			createInstance();
		}
		return extent;
	}
	
	public static ExtentReports createInstance() {
		String reportPath = getReportPath(reportFilepath);
		
		System.out.println("reportpath: " + reportPath);
		System.out.println("reportFilepath: " + reportFilepath);
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle(reportName);
		reporter.config().setReportName(reportName);
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Browser Name", PropertyFileReader.getConfigData("browser"));
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("App URL", PropertyFileReader.getConfigData("url"));
		
		return extent;
	}
	
	private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
}

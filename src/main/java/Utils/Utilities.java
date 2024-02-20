package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    public static String getScreenshot(WebDriver driver, String testmethodName, String targetPath) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
        File destfile = new File(targetPath);
        FileUtils.copyFile(srcfile, destfile);
        return targetPath;
    }

    public static String getTimestamp(){
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");

        return timestamp.format(ts);
    }
}

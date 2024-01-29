package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	public static String getValue = "";

	public static String getTestData(String val) {
		File file=new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testData.properties");
		FileInputStream fis=null;
		Properties prop=null;
		
		try {
		 fis = new FileInputStream(file);
		 prop= new Properties();
		 prop.load(fis);
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		catch (IOException e) {
			e.printStackTrace();
			}
		getValue=prop.getProperty(val);
		return getValue;
	}
}

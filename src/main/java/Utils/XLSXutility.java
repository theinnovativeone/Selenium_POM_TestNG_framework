package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXutility {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String path;
	FileInputStream fi;
	
	public XLSXutility(String path) {
		this.path = path;
	}
	
	public int getRowsCount(String sheetname) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		int row = sheet.getLastRowNum();	
		workbook.close();
		fi.close();
		return row;	
	}
	
	public int getColCount(String sheetname, int rownum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		int cell = row.getLastCellNum();
		
		workbook.close();
		fi.close();
		return cell;
	}
	
	public String getCellData(String sheetname, int rownum, int cellnum) throws IOException{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		DataFormatter  formatter = new DataFormatter();
		String data;
		
		try{
			data = formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data = "";
		}
		
		workbook.close();
		fi.close();
		return data;
				
	}
}

package tests;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import Utils.XLSXutility;
import base.BaseTest;
import pages.SearchingPage;

public class SearchingTests extends BaseTest {
	
//	private static final Logger logger = Logger.getLogger(JavaClass.class.getName());
	private static Logger logger = LogManager.getLogger(SearchingTests.class);
	
	SearchingPage sp;
	
  @Test(dataProvider = "searchkey")
  public void verifySearch(String searchkey, ITestContext context) throws InterruptedException {
	  sp = new SearchingPage(context);
	  logger.log(Level.INFO,  "Searching the keyword: Console log printed!!");

	  sp.search(searchkey);
	 
	  Assert.assertEquals(sp.getKeywordTypedInSearchBox(), sp.getKeywordForWhichSearchResultsAreShown());
	  logger.log(Level.INFO,  "Test is passed: Console log printed!!");
	  logger.error("error! {}", "Console log printed - INFO!!");
  }
  
  @DataProvider(name = "searchkey")
  public String[][] getdata() throws IOException{ 
	  
	  String path = ".//DataFiles//searchData.xlsx";
	  XLSXutility xlutil = new XLSXutility(path);
	  int row = xlutil.getRowsCount("Sheet1");
	  int col = xlutil.getColCount("Sheet1", 1);
	  
	  String searchdata[][] = new String[row][col];
	  
	  for(int i = 1; i<=row; i++) {
		  for(int j=0; j<col; j++) {
			  searchdata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
		  }
	  }
	  return searchdata;
  }
}

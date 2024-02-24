package tests;

import java.io.IOException;

import com.aventstack.extentreports.Status;
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
import reporter.ExtentTestManager;

public class SearchingTests extends BaseTest {
	private static final Logger logger = LogManager.getLogger(SearchingTests.class);
	SearchingPage sp;

  @Test(dataProvider = "searchkey", groups = "Regression")
  public void verifySearch(String searchkey, ITestContext context) throws InterruptedException {

	  sp = new SearchingPage(context);

	  sp.search(searchkey);
	  logger.info("Searched the keyword: " + searchkey );
	  ExtentTestManager.getTest().log(Status.INFO, "Searched the keyword: " + searchkey );

	  logger.info("Verify if correct results are displayed after search");
	  ExtentTestManager.getTest().log(Status.INFO, "Verify if correct results are displayed after search");
	  Assert.assertEquals(sp.getKeywordTypedInSearchBox(), sp.getKeywordForWhichSearchResultsAreShown());
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

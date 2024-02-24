package tests;

import java.io.IOException;
import java.text.ParseException;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utils.XLSXutility;
import base.BaseTest;
import pages.SearchingPage;
import pages.SortingPage;
import reporter.ExtentTestManager;

public class SortingTests extends BaseTest{

	private static final Logger logger = LogManager.getLogger(SortingTests.class);
	SearchingPage sp;
	SortingPage st;

	@Test(dataProvider = "searchkey", groups = {"Regression", "Sanity"})
	public void sortingLowToHighPrice(String searchkey, ITestContext context) throws InterruptedException, ParseException {

		sp = new SearchingPage(context);
		st = new SortingPage(context);

		sp.search(searchkey);
		logger.info("Searched the keyword: " + searchkey);
		ExtentTestManager.getTest().log(Status.INFO, "Searched the keyword: " + searchkey);

		st.chooseLowToHighPrice();
		logger.info("Chosen Low to High Price option from Sorting dropdown");
		ExtentTestManager.getTest().log(Status.INFO, "Chosen Low to High Price option from Sorting dropdown");

		logger.info("Verify if products get sorted from low to high price");
		ExtentTestManager.getTest().log(Status.INFO, "Verify if products get sorted from low to high price");
		Assert.assertTrue(st.isSortedByPrice());
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

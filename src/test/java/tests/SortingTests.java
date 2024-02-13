package tests;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.XLSXutility;
import base.BaseTest;
import pages.SearchingPage;
import pages.Sorting;

public class SortingTests extends BaseTest{

	SearchingPage sp;
	Sorting st;
	
	@Test(dataProvider = "searchkey")
	public void sortingLowToHighPrice(String searchkey, ITestContext context) throws InterruptedException, ParseException {
		sp = new SearchingPage(context);
		st = new Sorting(context);
				
		sp.search(searchkey);
		
		st.chooseLowToHighPrice();
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

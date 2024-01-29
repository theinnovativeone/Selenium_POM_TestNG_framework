package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.XLSXutility;
import base.BaseTest;
import pages.SearchingPage;

public class SearchingTests extends BaseTest {
	
	SearchingPage sp;
	
  @Test(dataProvider = "searchkey")
  public void verifySearch(String searchkey) throws InterruptedException {
	  sp = new SearchingPage(driver);
	  
	  sp.search(searchkey);
	 
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

package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.XLSXutility;
import base.BaseTest;
import pages.AddToCartPage;
import pages.ProductDetailsPage;
import pages.SearchingPage;

public class AddToCartTests extends BaseTest{

	SearchingPage sp;
	ProductDetailsPage pdp;
	AddToCartPage acp;
	
	@Test(dataProvider = "searchkey")
	public void addToCart(String searchkey, ITestContext context) throws InterruptedException {
		sp = new SearchingPage(driver);
		pdp = new ProductDetailsPage(driver);
		acp = new AddToCartPage(driver);
		
		sp.search(searchkey);
		pdp.openPDP(context);
		
		Thread.sleep(5000);
		String ProductTitleOnPDP = pdp.getProductTitleOnPDP();
		System.out.println("ProductTitleOnPDP " + ProductTitleOnPDP);
		acp.clickOnAddToCart();
		
		acp.goTOCart();
		
		String ProductTitleInCart = acp.getProductTitleInCart();
		System.out.println("ProductTitleInCart " + ProductTitleInCart);

		Assert.assertEquals(ProductTitleOnPDP, ProductTitleInCart);
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

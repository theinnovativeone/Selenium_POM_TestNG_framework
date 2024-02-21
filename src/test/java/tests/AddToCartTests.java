package tests;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.XLSXutility;
import base.BaseTest;
import pages.AddToCartPage;
import pages.ProductDetailsPage;
import pages.SearchingPage;
import reporter.ExtentTestManager;

public class AddToCartTests extends BaseTest{

	private static final Logger logger = LogManager.getLogger(AddToCartTests.class);
	SearchingPage sp;
	ProductDetailsPage pdp;
	AddToCartPage acp;
	
	@Test(dataProvider = "searchkey")
	public void addToCart(String searchkey, ITestContext context) throws InterruptedException {
		sp = new SearchingPage(context);
		pdp = new ProductDetailsPage(context);
		acp = new AddToCartPage(context);

		sp.search(searchkey);
		logger.info("Searched the keyword: " + searchkey);
		ExtentTestManager.getTest().log(Status.INFO, "Searched the keyword" + searchkey);

		pdp.openPDP(context);
		logger.info("Opened the product page");
		ExtentTestManager.getTest().log(Status.INFO, "Opened the product page");

		Thread.sleep(5000);
		String ProductTitleOnPDP = pdp.getProductTitleOnPDP(context);
		logger.info("Product title on PDP: " + ProductTitleOnPDP);
		ExtentTestManager.getTest().log(Status.INFO, "Product title on PDP: " + ProductTitleOnPDP);

		Thread.sleep(5000);
		acp.clickOnAddToCart(context);
		logger.info("Clicked on Add To Cart button");
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Add To Cart button");

		Thread.sleep(5000);
		acp.goTOCart(context);
		logger.info("Clicked on Go to Cart button");
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Go to Cart button");

		String ProductTitleInCart = acp.getProductTitleInCart();
		logger.info("Product title on Cart page: " + ProductTitleOnPDP);
		ExtentTestManager.getTest().log(Status.INFO, "Product title on Cart page: " + ProductTitleOnPDP);

		logger.info("Verify if the same product is added to the cart which was opened");
		ExtentTestManager.getTest().log(Status.INFO, "Verify if the same product is added to the cart which was opened");
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

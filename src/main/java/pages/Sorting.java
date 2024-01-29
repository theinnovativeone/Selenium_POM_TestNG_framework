package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class Sorting extends BasePage{
	
	protected final WebDriver driver;
	
//	@FindBy(xpath = "//span[@class='a-price-whole']") WebElement priceList;
	By priceList = By.cssSelector("span.a-price-whole");
	
	@FindBy(xpath = "//span[@id='a-autoid-0-announce']") WebElement sortingMenu;
	
	@FindBy(xpath = "//a[@id='s-result-sort-select_1']") WebElement sortingLowToHigh;
	
	public Sorting(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void chooseLowToHighPrice() {
		clickIt(sortingMenu);
		clickIt(sortingLowToHigh);
	}
	
	public boolean isSortedByPrice() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> listOfPrices = driver.findElements(priceList);
		List<Integer> listOfPricesInt = new ArrayList<Integer>();
		
		System.out.println(" WebElement number of items in List of prices: " + listOfPrices.size());

		System.out.println(" Actual List of prices: \n");
		for(WebElement element:listOfPrices) {
			Integer price = Integer.parseInt(element.getText());
			listOfPricesInt.add(price);
			System.out.println(price + "\t" + "p");
//			System.out.println("p");
		}
		System.out.println("p out");
		int i =0;
		int j = i+1;
		int k = j + 1;
		
		while(i< listOfPricesInt.size()- 2) {
			if((listOfPricesInt.get(i) <= listOfPricesInt.get(j)) && (listOfPricesInt.get(j) <= listOfPricesInt.get(k))) {
				i++;
				j++;
				k++;
			}
			else return false;
		}
		return true;
	}
}

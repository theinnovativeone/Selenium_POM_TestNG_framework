package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class SearchingPage extends BasePage{

	protected final WebDriver driver;
	
	@FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]") WebElement searchBox;
	
	@FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]") WebElement searchIcon;
	
	@FindBy(css = "span.a-color-state.a-text-bold") WebElement searchResultsKeyword;
	
	public SearchingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search(String searchkey) {
//		enterText(searchBox, "searchKeyword");
		sendTextExcel(searchBox, searchkey);
		clickIt(searchIcon);
	}
	
	public String getKeywordTypedInSearchBox() {
		
		String keyword = getElementText(searchBox);
		System.out.println("getKeywordTypedInSearchBox: " + keyword);
		return keyword;
	}
	
	public String getKeywordForWhichSearchResultsAreShown() throws InterruptedException {
		Thread.sleep(2000);
		
		String keyword = getElementText(searchResultsKeyword);
		System.out.println("getKeywordForWhichSearchResultsAreShown: " + keyword);

		return keyword;
	}
}

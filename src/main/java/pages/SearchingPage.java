package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import base.BasePage;

public class SearchingPage extends BasePage{

	protected final WebDriver driver;
	
	@FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]") WebElement searchBox;
	
	@FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]") WebElement searchIcon;
	
	@FindBy(css = "span.a-color-state.a-text-bold") WebElement searchResultsKeyword;
	
	public SearchingPage(ITestContext context) {
		this.driver = (WebDriver) context.getAttribute("WebDriver");;
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
		
		String keyword = (String) searchResultsKeyword.getAttribute("innerHTML");
		int len = keyword.length();
		keyword = keyword.substring(1, len - 1);
		System.out.println("getKeywordForWhichSearchResultsAreShown: " + keyword);

		return keyword;
	}
}

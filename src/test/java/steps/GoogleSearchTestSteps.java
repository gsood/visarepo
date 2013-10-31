package steps;

import infrastructure.driver.WebPage;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GoogleSearchTestSteps {

	

	private WebPage page;
	
	
	@BeforeStory
	public void beforeStory() {
		page  = WebPage.CHROME_DRIVER;
	}

	@AfterStory
	public void afterStory() {
		page.destroyChromeDriver();
	}
	
	@Given("user is on page $url")
	public void loadStartPage(String url) {
		page.gotoPage(url);
	}
	
	@When("user searches for $searchTerm")
	public void search(String searchTerm) {
		page.searchFor(searchTerm);
	}
	
	@Then("user gets results")
	public void resultsFound() {
		page.elementWithXPathExists("//div[@id='search']//ol[@id='rso']/li");
	}

	@Then("search result on position $position is $resultString")
	public void checkSearchResultOnPosition(int position, String resultString) {
		page.elementWithXPathContainsText("//div[@id='search']//ol[@id='rso']/li[" + position+ "]//em", resultString);
	}
	
	@When("user clicks on search result number $position")
	public void clickOnResultAndWaitForResultPagetoLoad(int position) {
		page.clickOnElementWithXPathAndWaitForXPath("//div[@id='search']/div/ol/li[" + position+ "]//em");
		
	}

	@Then("user is taken to $url")
	public void checkCurrentUrl(String url) {
		page.assertPageUrl(url);
		
	}

	@Then("user gets page with text $text")
	public void checkPageContainsText(String text) {
		page.containsText(text);
		
	}
	
	
	
}

package infrastructure.driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Assumes "webdriver.chrome.driver" is set

public enum WebPage {
	CHROME_DRIVER(new ChromeDriver());
	
	private static final int TEN_SECONDS_TIMEOUT = 10;
	private WebDriver webDriver;
	private WebDriverWait wait;

	private WebPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		wait = new WebDriverWait(webDriver, TEN_SECONDS_TIMEOUT);
	}
	
	public void gotoPage(String url) {
		webDriver.get(url);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main']")));
	}

	public void searchFor(String searchTerm) {
		WebElement searchBox = webDriver.findElement(By.xpath("//input[@name='q']"));
		searchBox.sendKeys(searchTerm);
		searchBox.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='res']")));
	}
	

	public void elementWithXPathContainsText(String xpath, String text) {
		WebElement element = webDriver.findElement(By.xpath(xpath));
		assertTrue(element.getText().contains(text));
	}

	public void clickOnElementWithXPathAndWaitForXPath(String xpath) {
		WebElement element = webDriver.findElement(By.xpath(xpath));
		
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html")));
	}

	public void assertPageUrl(String url) {
		assertEquals(webDriver.getCurrentUrl(), url);
	}

	public void elementWithXPathExists(String xpath) {
		WebElement element = webDriver.findElement(By.xpath(xpath));		
		assertNotNull(element);
		
	}

	public void containsText(String text) {
		assertTrue(webDriver.getPageSource().contains(text));
		
	}

	
	
	
	
	
	
	
	
	
	
	
}

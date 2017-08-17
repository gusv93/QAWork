package Search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSearch {

	private WebDriver driver;
	
	@DataProvider
	public Object[][] testData()
	{
		return new Object[][] {
			new Object[] {"—умка"},
			new Object[] {"”ниверсальный пульт ƒ” LOGITECH Harmony 950"},
			new Object[] {"133383"},
			new Object[] {"0"},
			new Object[] {"null"},
			new Object[] {"qweqwe"},
			new Object[] {" "},
			new Object[] {"123"},
			new Object[] {"-55"},
			new Object[] {"<script>alert('XSS');</script>"},
			new Object[] {"”нивер"},
			new Object[] {"&&"},
			new Object[] {"||z"},
			new Object[] {"планшет"},
			new Object[] {"ѕланшет"},
			new Object[] {"ѕлјнЎе“"},
			new Object[] {"%123"},
			new Object[] {"Tablet"},
			
		};
	}
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\јвтоматизаци€\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://can.ua/");;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	@Test(dataProvider="testData")
	public void TestSearchField(String testDataValues)
	{
		SearchField sf = new SearchField(driver);
		sf.findSearchFieldById("search-text");
		sf.enterData(testDataValues);
		sf.clearField();
		
		
		
		
	}
}

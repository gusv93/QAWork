package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchField {
	
	private WebDriver driver;
	private String searchField;
	
	public SearchField(WebDriver driver) {
		this.driver=driver;
	}


	public void findSearchFieldById(String s)
	{
		
		this.searchField=s;
		driver.findElement(By.id(s));
	}


	public void enterData(String testData) {
		WebElement field=driver.findElement(By.id(searchField));
		field.sendKeys(testData);
		field.submit();
		
	}


	public void clearField() {
		driver.findElement(By.id(searchField)).clear();
		
	}

}

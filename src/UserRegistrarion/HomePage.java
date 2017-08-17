package UserRegistrarion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class HomePage {

	private WebDriver driver;
	private String popup;
	private String singUpButton;
	private String registrationFields;
	private List<WebElement> listOhFields;
	private String regButton;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public void callUpPopupXpath(String p) {
		this.popup=p;
		driver.findElement(By.xpath(p)).click();
		
	}
	
	public void singUpbuttonXpath(String suButton) {
		this.singUpButton=suButton;
		driver.findElement(By.xpath(suButton)).click();
	}

	public void listOfInputs(String rf) {
		this.registrationFields=rf;
		listOhFields = driver.findElements(By.xpath(rf));
	}
	
	public void enterUserData(String name, String phone, String password, String email) {
	
			WebElement userName = listOhFields.get(0);
			userName.sendKeys(name);
			WebElement userPhone = listOhFields.get(1);
			userPhone.sendKeys(phone);
			WebElement userPass = listOhFields.get(2);
			userPass.sendKeys(password);
			WebElement userEmail = listOhFields.get(3);
			userEmail.sendKeys(email);
		
	}
	

	public void pressRegistrButton(String rb) {
		
		
		
		this.regButton=rb;
		driver.findElement(By.xpath(rb)).click();
		
		WebElement regDone = driver.findElement(By.xpath("//div[@class='done-reg']//h3"));
		boolean chekReg=regDone.isDisplayed();
		/*SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(chekReg);*/
		
		
		
	}
	


	

}

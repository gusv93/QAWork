package UserRegistrarion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistraionUser {

	WebDriver driver;
	@DataProvider
	public Object[][] testData(){
		
		return new Object [][] {
			new Object [] {"Test","1","qweqwe","testemail@gmail.com"},
		};
	}
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
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
	public void DoRegistrationPositiv(String name, String phone, String password, String email) throws InterruptedException
	{
		HomePage home = new HomePage(driver);
		home.callUpPopupXpath("//a[@name='signin']");
		home.singUpbuttonXpath("//div[@class='text-wrap']//a[@name='dosignup']");
		home.listOfInputs("//form[@name='signup-form']/div[@class='item']//input");
		home.enterUserData(name,phone,password,email);
		home.pressRegistrButton("//button[text()='регистрация']");
	
		
	}
	

}

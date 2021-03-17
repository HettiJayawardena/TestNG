package TestNG_Chrome;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class JedoxTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C://Users/jayawardena/Desktop/harini/selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.get("https://www.jedox.com/de/");
		
	}
	
	@Test
	public void jedoxTitleTest() {
		
		String title = driver.getTitle();
		System.out.print(title);
		
		Assert.assertEquals(title, "Enterprise Performance Management und BI kombiniert in einer Software", "title does not match");
			
	}
	
	
	@Test
	public void jedoxsignupbutton() {
		
	    boolean btn = driver.findElement(By.xpath("//*[@id=\"menu-item-65188\"]/a/span")).isDisplayed();		
		Assert.assertTrue(btn);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionsExamples {
     
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}
	@Test(priority=1)
	void logotest()
	{
     WebElement logo=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));
     Assert.assertTrue( logo.isDisplayed());
     
	}
	@Test(priority=2)
	void homepagetitle()
	{
	String title=driver.getTitle();
	Assert.assertEquals("Google",title);
	}
	@AfterClass
	void lasttest()
	{
		driver.quit();
	}
}

package automation_core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class QaBase {
	
protected WebDriver driver;
	
	public void initializeBrowser(String browser)
	{
		
		if(browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new RuntimeException("Invalid browser");			
		}
		driver.get("https://qalegend.com/billing/public/login");

		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	
	public void setUp()
	{
		initializeBrowser("Chrome");
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		
		//driver.close();
	}

}

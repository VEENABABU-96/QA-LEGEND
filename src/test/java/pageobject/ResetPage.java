package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	
	WebDriver driver;
	public ResetPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="email")
	WebElement email_field;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement send_button;
	
	
	
	

}

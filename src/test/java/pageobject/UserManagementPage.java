package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;

public class UserManagementPage {
	
	WebDriver driver;
	
	public UserManagementPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]")
	WebElement user_option;
	
	
	
	public UserPage clickUsersOption()

	{
		user_option.click();
		return new UserPage(driver);
	}

	//public void ifElementIsEnabled()
	public boolean ifElementIsEnabled()
	{
		WebElementUtility.checkIsEnabled(user_option);
		return WebElementUtility.checkIsEnabled(user_option);
	}
	
	
	
	
}

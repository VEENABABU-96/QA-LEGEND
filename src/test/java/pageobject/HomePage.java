package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//section[@class='content-header']")
	WebElement login_message;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	WebElement endtour_button;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement user_logout;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement logout_button;
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement user_management;
	
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]")
	WebElement user_option;
	
	@FindBy(xpath="//div[@class='pull-left']//a[@class='btn btn-default btn-flat']")
	WebElement profile_option;

	@FindBy(xpath="//input[@id='first_name']")
	WebElement new_FirstName;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement new_LastName;

	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement update_button;
	
	
	
	
	
	public String getLoginText()
	{
		String user_message =login_message.getText();
		return user_message;
	}
	
	public String getHomePageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public UserManagementPage clickOnUserManagement()
	{
		user_management.click();
		return new UserManagementPage(driver);
	}
	
	public AddUserPage clickUsersOption()

	{
		user_option.click();
		return new AddUserPage(driver);
	}
	
	public void clickUserLogout()
	{
		user_logout.click();
	}

	public LoginPage clickLogoutButton()
	{
		logout_button.click();
		return new LoginPage(driver);
	}

	public void enterEndtour()
	{
		endtour_button.click();
	}
	public void clickOnProfileOption()
	{
		profile_option.click();
	}

	public void editFirstName(String new_firstname)
	{
		new_FirstName.clear();
		new_FirstName.sendKeys(new_firstname);
	}
	public void editLastName(String new_lastname)
	{
		new_LastName.clear();
		new_LastName.sendKeys(new_lastname);
	}

	public void clickonUpdateButton()
	{
		update_button.click();
	}

	public String getUserProfileText()
	{
		String profile_text=user_logout.getText();
		return profile_text;
	}
	
	

}

package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AddUserPage {
	WebDriver driver;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement add_user;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname_field;

	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastname_field;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email_field;

	@FindBy(xpath="//select[@id='role']")
	WebElement role_dropdown;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username_option;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement userpassword_field;

	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement confirmpassword_field;

	@FindBy(xpath="//button[@id='submit_user_button']")
	WebElement save_button;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement search_field;

	@FindBy(className="toast-success")
	WebElement success_message;
	
	
	public void clickAddUserButton()
	{
		add_user.click();
	}

	public void enterFirstName(String firstname)
	{
		firstname_field.sendKeys(firstname);
	}

	public void enterLastName(String last_name)
	{
		lastname_field.sendKeys(last_name);
	}
	public void enterEmail(String email)
	{
		email_field.sendKeys(email);
	}

	public void selectFromDropdown()
	{
	
		Select select=new Select(role_dropdown);
		select.selectByIndex(3);
	}

	public void enterUserName(String username)
	{
		username_option.sendKeys(username);
	}

	public void enterPassword(String password)
	{
		userpassword_field.sendKeys(password);
	}
	public void enterConfirmPassword(String password)
	{
		confirmpassword_field.sendKeys(password);
	}

	public UserPage enterSaveButton()
	{
		save_button.click();
		return new UserPage(driver);
	}


	public void searchOnSearchField(String username)
	{
		search_field.sendKeys(username);
	}

	public void waitForTextToBeInvisible()
	{
		WaitUtility.waitForElementToBeInvisible(driver, success_message);
	}
	
	
	
	
}

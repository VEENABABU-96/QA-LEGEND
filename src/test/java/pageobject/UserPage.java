package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class UserPage {
	
	WebDriver driver;
	public UserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement add_user;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement search_field;

	@FindBy(className="toast-success")
	WebElement success_message;
	
	//@FindBy(xpath="//td[@class='sorting_1']")
	@FindBy(xpath="//table[@id='users_table']//tbody//td[1]")
	WebElement search_row;
	
	
	
	public AddUserPage clickAddUserButton()
	{
		add_user.click();
		return new AddUserPage(driver);
	}
	
	public void searchOnSearchField(String username)
	{
		search_field.sendKeys(username);
	}
	
	public void waitForTextToBeInvisible()
	{
		WaitUtility.waitForElementToBeInvisible(driver, success_message);
	}
	
	public String getSearchUser()
	{
		String user=search_row.getText();
		//System.out.println(user);
		return user;
	}

}

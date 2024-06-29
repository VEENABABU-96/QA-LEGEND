package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;
import utilities.WebElementUtility;

public class UserManagementPage {

	WebDriver driver;

	public UserManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-user']//following-sibling::span")
	WebElement user_option;

	public UserPage clickUsersOption()

	{
		user_option.click();
		return new UserPage(driver);
	}

	public boolean ifElementIsEnabled() {
		WebElementUtility.checkIsEnabled(user_option);
		return WebElementUtility.checkIsEnabled(user_option);
	}

	public void waitForButtonToBeInvisible() {
		WaitUtility.waitForElementToBeInvisible(driver, user_option);
	}

}

package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class UserPage {

	WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement add_user;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement search_field;

	@FindBy(className = "toast-success")
	WebElement success_message;

	@FindBy(xpath = "//tr[@class='odd']//td[1]")
	WebElement search_row;

	@FindBy(xpath = "//table[@id='users_table']//tr//td[4]")
	WebElement email_field;

	public AddUserPage clickAddUserButton() {
		add_user.click();
		return new AddUserPage(driver);
	}

	public void searchOnSearchField(String value) {

		WaitUtility.waitForElementToBeVisile(driver, search_field);
		search_field.sendKeys(value);
	}

	public String waitForTextToBeInvisible() {
		String msg_text = success_message.getText();
		WaitUtility.waitForElementToBeInvisible(driver, success_message);
		return msg_text;
	}

	public String getSearchUser() {
		WaitUtility.waitForElementToBeVisile(driver, email_field);
		String user = email_field.getText();
		return user;
	}

}

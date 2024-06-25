package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.QaBase;
import constants.Constants;
import pageobject.AddUserPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.QaExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends QaBase {
	@Test
	public void verifyAddUser()
	{
		String username=QaExcelUtility.readStringData(0, 0, "LoginPage");
		String password=QaExcelUtility.readIntegerData(0, 1, "LoginPage");
		
		String firstname= RandomDataUtility.getFirstName();
		String lastname=RandomDataUtility.getLastName();
		String email= firstname+Constants.DOT+lastname+Constants.GMAIL;
		String passworduser =firstname+Constants.AT+lastname;
		String username_value = firstname+Constants.DOT+lastname;
		
		
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		home.enterEndtour();
		home.clickOnUserManagement();
		AddUserPage adduser=home.clickUsersOption();
		adduser.clickAddUserButton();
		adduser.enterFirstName(firstname);
		adduser.enterLastName(lastname);
		adduser.enterEmail(email);
		adduser.selectFromDropdown();
		adduser.enterUserName(username_value);
		adduser.enterPassword(passworduser);
		adduser.enterConfirmPassword(passworduser);
		adduser.enterSaveButton();
		adduser.searchOnSearchField(username_value);
		
		

	}
	@Test
	public void verifyNewlyRegisteredUser()
	{
		
		String username=QaExcelUtility.readStringData(0, 0, "LoginPage");
		String password=QaExcelUtility.readIntegerData(0, 1, "LoginPage");
		
		String firstname= RandomDataUtility.getFirstName();
		String lastname=RandomDataUtility.getLastName();
		String email= firstname+Constants.DOT+lastname+Constants.GMAIL;
		String passworduser =firstname+Constants.AT+lastname;
		String username_value = firstname+Constants.DOT+lastname;
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		home.enterEndtour();
		home.clickOnUserManagement();
		AddUserPage adduser=home.clickUsersOption();
		adduser.clickAddUserButton();
		adduser.enterFirstName(firstname);
		adduser.enterLastName(lastname);
		adduser.enterEmail(email);
		adduser.selectFromDropdown();
		adduser.enterUserName(username_value);
		adduser.enterPassword(passworduser);
		adduser.enterConfirmPassword(passworduser);
		adduser.enterSaveButton();
		adduser.waitForTextToBeInvisible();
		adduser.searchOnSearchField(username_value);
				
	}
	}



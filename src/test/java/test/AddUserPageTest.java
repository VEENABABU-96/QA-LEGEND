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
import constants.Messages;
import pageobject.AddUserPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.UserManagementPage;
import pageobject.UserPage;
import utilities.QaExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends QaBase {
	@Test
	public void verifyAddUser()
	{
		String username=QaExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=QaExcelUtility.readIntegerData(0, 1, Constants.LOGINPAGE);
		
		String first_name= RandomDataUtility.getFirstName();
		String last_name=RandomDataUtility.getLastName();
		String email= first_name+Constants.DOT+last_name+Constants.GMAIL;
		String user_name=first_name+Constants.DOT+last_name;
		String passworduser =first_name+Constants.AT+last_name;
		
		
		
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		home.enterEndtour();
		home.clickOnUserManagement();
		AddUserPage adduser=home.clickUsersOption();
		adduser.clickAddUserButton();
		UserManagementPage usermanage=home.clickOnUserManagement();
		UserPage user=usermanage.clickUsersOption();
		AddUserPage addusers=user.clickAddUserButton();		
		adduser.enterFirstName(first_name);
		adduser.enterLastName(last_name);
		adduser.enterEmail(email);
		adduser.selectFromDropdown();
		adduser.enterUserName(user_name);
		adduser.enterPassword(passworduser);
		adduser.enterConfirmPassword(passworduser);
		adduser.enterSaveButton();
		adduser.searchOnSearchField(username);
		user.searchOnSearchField(username);
		//String expected_usertext=username;
		String actual_usertext=user.getSearchUser();
		System.out.println(actual_usertext);
		//user.getSearchUser();
		//Assert.assertEquals(actual_usertext, expected_usertext, Messages.LOGIN_FAILED);
		
		

	}
	@Test
	public void verifyNewlyRegisteredUser()
	{
		
		String username=QaExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=QaExcelUtility.readIntegerData(0, 1, Constants.LOGINPAGE);
		
		String first_name= RandomDataUtility.getFirstName();
		String last_name=RandomDataUtility.getLastName();
		String email= first_name+Constants.DOT+last_name+Constants.GMAIL;
		String user_name=first_name+Constants.DOT+last_name;
		String passworduser =first_name+Constants.AT+last_name;
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		home.enterEndtour();
		home.clickOnUserManagement();
		AddUserPage adduser=home.clickUsersOption();
		adduser.clickAddUserButton();
		UserManagementPage usermanage=home.clickOnUserManagement();
		UserPage user=usermanage.clickUsersOption();
		AddUserPage addusers=user.clickAddUserButton();	
		adduser.enterFirstName(first_name);
		adduser.enterLastName(last_name);
		adduser.enterEmail(email);
		adduser.selectFromDropdown();
		adduser.enterUserName(user_name);
		adduser.enterPassword(passworduser);
		adduser.enterConfirmPassword(passworduser);
		adduser.enterSaveButton();
		adduser.waitForTextToBeInvisible();
		user.waitForTextToBeInvisible();
		home.clickUserLogout();
		home.clickLogoutButton();
		login.enterUserName(username);
		login.enterPassword(passworduser);
		login.clickOnLoginButton();
		String actual_message=home.getLoginText();
		String expected_message=Messages.GREETINGS+first_name+Constants.CHARACTER;
		Assert.assertEquals(actual_message, expected_message, Messages.LOGIN_FAILED);
		
				
	}
	}



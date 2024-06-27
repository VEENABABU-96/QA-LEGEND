package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.QaBase;
import constants.Constants;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.UserManagementPage;
import utilities.QaExcelUtility;

public class UserManagementPageTest extends QaBase {
	@Test
	public void verifyUsersOptionIsEnabled()
	{
	
	String username=QaExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
	String password=QaExcelUtility.readIntegerData(0, 1, Constants.LOGINPAGE);
	
	LoginPage login=new LoginPage(driver);
	login.enterUserName(username);
	login.enterPassword(password);
	HomePage home=login.clickOnLoginButton();
	home.enterEndtour();
	UserManagementPage usermanage=home.clickOnUserManagement();
	usermanage.ifElementIsEnabled();
	boolean user_isenabled=usermanage.ifElementIsEnabled();
	Assert.assertTrue(user_isenabled);
}
}
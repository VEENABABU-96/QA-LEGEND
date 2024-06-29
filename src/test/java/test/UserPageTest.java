package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.QaBase;
import constants.Constants;
import constants.Messages;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.UserManagementPage;
import pageobject.UserPage;
import utilities.QaExcelUtility;

public class UserPageTest extends QaBase{
	
	@Test
	public void verifySearchUser()
	{
		String username=QaExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=QaExcelUtility.readIntegerData(0, 1, Constants.LOGINPAGE);
		String email_id=QaExcelUtility.readStringData(0, 0, Constants.USERPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		home.enterEndtour();
		UserManagementPage usermanage=home.clickOnUserManagement();
		UserPage user=usermanage.clickUsersOption();
		user.searchOnSearchField(email_id);
		String actual_user=email_id;
		String expecetd_user=user.getSearchUser();
		Assert.assertEquals(actual_user, expecetd_user, Messages.USER_MISMATCH);
		
		
	}
}

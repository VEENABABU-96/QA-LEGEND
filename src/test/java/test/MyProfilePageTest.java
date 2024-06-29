package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.QaBase;
import constants.Constants;
import constants.Messages;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.QaExcelUtility;
import utilities.RandomDataUtility;

public class MyProfilePageTest extends QaBase {
	@Test
	public void verifyEditProfile() {
		String username = QaExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password = QaExcelUtility.readIntegerData(0, 1, Constants.LOGINPAGE);
		String new_lastname = RandomDataUtility.getLastName();
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home = login.clickOnLoginButton();
		home.enterEndtour();
		home.clickUserLogout();
		home.clickOnProfileOption();
		home.editLastName(new_lastname);
		home.clickonUpdateButton();
		String actual_editname = home.getUserProfileText();
		String expected_editname = Constants.PROFILENAME + new_lastname;
		Assert.assertEquals(actual_editname, expected_editname, Messages.HOME_FAILEDPROFILEUPDATION);

	}

}

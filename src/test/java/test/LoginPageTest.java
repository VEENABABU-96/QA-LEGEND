package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import automation_core.QaBase;
import constants.Constants;
import constants.Messages;
import dataprovider.DataProviders;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.QaExcelUtility;

public class LoginPageTest extends QaBase {
	@Test
	public void verifyUserLoginwithValidCredentials()
	{
		
		String username=QaExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=QaExcelUtility.readIntegerData(0, 1, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		
		String actual_msg=home.getLoginText();
		String expected_msg=QaExcelUtility.readStringData(0, 2, Constants.LOGINPAGE);
		Assert.assertEquals(actual_msg, expected_msg, Messages.LOGIN_FAILED);
	}
	@Test(dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)
	public void verifErrorMessageWhileUserLoginwithInvalidCredentials(String username, String password)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		String actual_errormessage=login.getErrorMessage();
		String expected_errormessage=QaExcelUtility.readStringData(0, 3, Constants.LOGINPAGE);
		Assert.assertEquals(actual_errormessage, expected_errormessage, Messages.LOGIN_SUCCESS);
		
		

	}
	

}

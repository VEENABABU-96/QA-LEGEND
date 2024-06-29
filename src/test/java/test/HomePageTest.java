package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.QaBase;
import constants.Constants;
import constants.Messages;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.QaExcelUtility;
import utilities.RandomDataUtility;

public class HomePageTest extends QaBase {
	@Test
	public void verifyHomePageTitle() {

		String username = QaExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password = QaExcelUtility.readIntegerData(0, 1, Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home = login.clickOnLoginButton();
		String homepage_title = home.getHomePageTitle();
		String expected_title = QaExcelUtility.readStringData(0, 1, Constants.HOMEPAGE);
		Assert.assertEquals(homepage_title, expected_title, Messages.HOME_TITLEMISMATCH);
	}

	@Test
	public void verifyUserLoginDate() {

		String username = QaExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password = QaExcelUtility.readIntegerData(0, 1, Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home = login.clickOnLoginButton();
		String actual_logindate = home.getLoginDate();
		String expected_logindate = home.getCurrentDate();
		Assert.assertEquals(actual_logindate, expected_logindate, "LOGINDATE MISMATTCHED");

	}
}

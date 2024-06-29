package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.QaBase;
import constants.Constants;
import constants.Messages;
import pageobject.LoginPage;
import pageobject.ResetPage;
import utilities.QaExcelUtility;

public class ResetPageTest extends QaBase {
	@Test(groups = "Sanity")

	public void verifyResetPassword() {
		String email = QaExcelUtility.readStringData(0, 0, Constants.RESETPAGE);
		LoginPage login = new LoginPage(driver);
		ResetPage reset = login.clickOnForgotPassword();
		reset.enterEmailAddress(email);
		reset.enterResetPassword();
		String actual_message = reset.getConformationMessage();
		String expected_message = QaExcelUtility.readStringData(0, 1, Constants.RESETPAGE);
		Assert.assertEquals(actual_message, expected_message, Messages.INVALID_EMAIL);

	}

	@Test(groups = "Smoke")
	public void verifyErrorMessageWithInvalidEmailidOnForgotPassword() {
		String email = QaExcelUtility.readStringData(1, 0, Constants.RESETPAGE);
		LoginPage login = new LoginPage(driver);
		ResetPage reset = login.clickOnForgotPassword();
		reset.enterEmailAddress(email);
		reset.enterResetPassword();
		String actual_errormessage = reset.getErrorMessage();
		String expected_errormessage = QaExcelUtility.readStringData(1, 1, Constants.RESETPAGE);
		Assert.assertEquals(actual_errormessage, expected_errormessage, Messages.VALID_EMAIL);
	}

}

package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.QaBase;

import utilities.QaExcelUtility;


public class ResetPageTest extends QaBase  {
	@Test
	public void verifyErrorMessagewithInvalidMailId()
	{
	
	WebElement forgot_pwd=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
	forgot_pwd.click();
	
	WebElement email_field=driver.findElement(By.id("email"));
	String reset_mail=QaExcelUtility.readStringData(0, 0, "ResetPasswordPage");
	email_field.sendKeys(reset_mail);
	
	WebElement send_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	send_button.click();
	
	WebElement warn_msg=driver.findElement(By.xpath("//span[@class='help-block']"));
	String actualwarningmsg=warn_msg.getText();
	String expectedwarningmsg=QaExcelUtility.readStringData(0, 1, "ResetPasswordPage");
	Assert.assertEquals(actualwarningmsg, expectedwarningmsg, "Valid Email Address");
	}
	@Test
	public void verifyResetPassword()
	{
		
		WebElement forgot_pwd=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgot_pwd.click();
		WebElement email_field=driver.findElement(By.id("email"));
		String reset_mail=QaExcelUtility.readStringData(1, 0, "ResetPasswordPage");
		email_field.sendKeys(reset_mail); 
		WebElement send_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		send_button.click();
		WebElement success_msg=driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String actual_msg=success_msg.getText();
		String expectmsg=QaExcelUtility.readStringData(1, 1, "ResetPasswordPage");
		Assert.assertEquals(actual_msg, expectmsg, "Invalid id");
		
	}
	
}

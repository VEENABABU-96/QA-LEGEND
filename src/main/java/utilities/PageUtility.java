package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectByValue(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectDropdownByVisibleText(WebElement element,String visibleText)
	{
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void selectByIndex(WebElement element,int value)
	{
		Select select= new Select(element);
		select.selectByIndex(value);
	}
	
	public static void verifySimpleAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void verifyConfirmationAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public static void verifyPromptAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();

	}

	public static void verifyRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public static void verifyDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public static void verifyDragAndDrop(WebDriver driver, WebElement source_element, WebElement target_element) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source_element, target_element).build().perform();
	}

	public static void verifyDragAndOffset(WebDriver driver, WebElement source_element) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(source_element, 50, 100).build().perform();
	}

	public static void verifyMouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	} 

}

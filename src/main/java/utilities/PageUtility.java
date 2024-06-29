package utilities;

import org.openqa.selenium.WebElement;
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

}

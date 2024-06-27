package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
	
	public static boolean checkIsDisplayed(WebElement element)
	{
		boolean check=element.isDisplayed();
		System.out.println(check);
		return check;
	}

	public static boolean checkIsSelected(WebElement element)
	{
		boolean check=element.isSelected();
		System.out.println(check);
		return check;
	}

	public static boolean checkIsEnabled(WebElement element)
	{
		boolean check=element.isEnabled();
		System.out.println(check);
		return check;
	}
	
	

}

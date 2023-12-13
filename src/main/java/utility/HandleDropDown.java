package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown 
{
	public static void handleSelectClass(WebElement ele,String value)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(value);	
	}

}

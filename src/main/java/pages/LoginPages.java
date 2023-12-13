package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPages extends TestBase
{
	//object repository
		@FindBy(xpath="//input[@name='user-name']") private WebElement userNameTextBox;
		@FindBy(xpath="//input[@name='password']") private WebElement passwordTextBox;
		@FindBy(xpath="//input[@class='submit-button btn_action']") private WebElement loginBtn;
		
		//constructor to initialize the Web element (current class member)
		public LoginPages()
		{
			PageFactory.initElements(driver,this);
		}
		
		public String loginTOApplication() throws IOException
		{
			//userNameTextBox.sendKeys("standard_user");
			userNameTextBox.sendKeys(ReadData.readProperFile("username"));
			//passwordTextBox.sendKeys("secret_sauce");
			passwordTextBox.sendKeys(ReadData.readProperFile("password"));
			loginBtn.click();
			return driver.getCurrentUrl();
		}
		public String verifyTitleOfApp()
		{
			return driver.getTitle();
		}
		public String verifyURL()
		{
			return driver.getCurrentUrl();
		}

}

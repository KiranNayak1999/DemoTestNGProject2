package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class CheckOutPage1 extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement checkOutLable;
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameLable;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastNameLable;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipCodeLable;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	
	public CheckOutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckOutPage1URL()
	{
		return  driver.getCurrentUrl();
	}
	
	public String verifyCheckOutPage1Lable()
	{
		return checkOutLable.getText();
	}
	
	public String inputCheckOutInfo() throws EncryptedDocumentException, IOException
	{
		//firstNameLable.sendKeys("Harry"); //0,1
		firstNameLable.sendKeys(ReadData.readExcel(0, 1));
		//lastNameLable.sendKeys("Potter"); //0,2
		lastNameLable.sendKeys(ReadData.readExcel(0, 2));
		//zipCodeLable.sendKeys("1234");  //0,3
		zipCodeLable.sendKeys(ReadData.readExcel(0, 3));
		continueBtn.click();
		return driver.getCurrentUrl();
	}

}

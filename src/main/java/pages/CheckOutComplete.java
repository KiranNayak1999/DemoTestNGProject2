package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutComplete extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement CheckOutCompleteLable;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement ponyImage;
	@FindBy(xpath="//h2[@class='complete-header']") private WebElement thankYouLable;
	@FindBy(xpath="//div[@class='complete-text']") private WebElement yourOrderLable;
	
	public CheckOutComplete()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckOutCompleteURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyCheckOutCompleteLable()
	{
		return CheckOutCompleteLable.getText();
	}
	
	public boolean verifyponyImage()
	{
		return ponyImage.isDisplayed();
	}
	
	public String verifythankYouLable()
	{
		return thankYouLable.getText();
	}
	
	public String verifyyourOrderLable()
	{
		return yourOrderLable.getText();
	}
}

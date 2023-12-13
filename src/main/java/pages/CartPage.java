package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement yourCartLable;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button ']") private WebElement checkoutBtn;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();
	}
	public String verifyyourCartLable()
	{
		return yourCartLable.getText();
	}
	public void clickCheckOutBtn()
	{
		checkoutBtn.click();
	}

}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage2 extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement checkOutPage2Lable;
	@FindBy(xpath="//div[@class='summary_info_label'][1]") private WebElement paymentInfoLable;
	@FindBy(xpath="//div[@class='summary_info_label'][2]") private WebElement shippingInfoLable;
	@FindBy(xpath="//div[@class='summary_info_label'][3]") private WebElement totalAmountLable;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium cart_button']") private WebElement finishBtn;
	
	public CheckOutPage2()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycheckOutPage2Lable()
	{
		return checkOutPage2Lable.getText();
	}
	
	public String verifypaymentInfoLable()
	{
		return paymentInfoLable.getText();
	}
	
	public String verifyshippingInfoLable()
	{
		return shippingInfoLable.getText();
	}
	
	public String verifytotalAmountLable()
	{
		return totalAmountLable.getText();
	}
	
	public void clickFinishBtn()
	{
		finishBtn.click();
	}
}

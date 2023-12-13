package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutComplete;
import pages.CheckOutPage1;
import pages.CheckOutPage2;
import pages.InventoryPage;
import pages.LoginPages;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CheckOutCompleteTest extends TestBase
{
	LoginPages login;
	InventoryPage invent;
	CartPage cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	CheckOutComplete complete;
	
	@BeforeMethod (alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initilization();
		login=new LoginPages();
		invent=new InventoryPage();
		cart=new CartPage();
		check1=new CheckOutPage1();
		complete=new CheckOutComplete();
		login.loginTOApplication();
		invent.add6Product();
		invent.ClickcartCount();
		cart.clickCheckOutBtn();
		check1.inputCheckOutInfo();
		check2.clickFinishBtn();
	}
	
	@Test (enabled = true, groups= "Sanity")
	public void verifyCheckOutCompleteURLTest() throws EncryptedDocumentException, IOException
	{
		//String expURL="https://www.saucedemo.com/checkout-complete.html";
		String expURL=ReadData.readExcel(4, 0);  //4,0
		String actURL=complete.verifyCheckOutCompleteURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Url of complete page is = " + actURL);
	}
	
	@Test (enabled = true, groups= "Smoke")
	public void verifyCheckOutCompleteLableTest() throws EncryptedDocumentException, IOException
	{
		//String expLable="Checkout: Complete!";
		String expLable=ReadData.readExcel(4, 1);  //4,1
		String actLable=complete.verifyCheckOutCompleteLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("lable is = " + actLable);
	}
	
	@Test (enabled = true, groups= "Smoke")
	public void verifyponyImageTest()
	{
		boolean result=complete.verifyponyImage();
		Assert.assertEquals(result, true);
		Reporter.log("Image is = " + result);
	}
	
	@Test (enabled = true, groups= "Smoke")
	public void verifythankYouLableTest() throws EncryptedDocumentException, IOException
	{
		//String expLable="Thank you for your order!";
		String expLable=ReadData.readExcel(4, 2);  //4,2
		String actLable=complete.verifythankYouLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("thank you lable = " + actLable);	
	}
	
	@Test (enabled = true, groups= "Smoke")
	public void verifyyourOrderLableTest() throws EncryptedDocumentException, IOException
	{
		//String expLable="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String expLable=ReadData.readExcel(4, 3);   //4,3
		String actLable=complete.verifyyourOrderLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("your lable = " + actLable);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenShot.screenShot(it.getName());
		}
		driver.close();
	}
}

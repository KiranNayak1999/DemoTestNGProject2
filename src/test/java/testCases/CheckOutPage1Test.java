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
import pages.CheckOutPage1;
import pages.InventoryPage;
import pages.LoginPages;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CheckOutPage1Test extends TestBase
{
	LoginPages login;
	InventoryPage invent;
	CartPage cart;
	CheckOutPage1 check1;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initilization();
		login=new LoginPages();
		invent=new InventoryPage();
		cart=new CartPage();
		check1=new CheckOutPage1();
		login.loginTOApplication();
		invent.add6Product();
		invent.ClickcartCount();
		cart.clickCheckOutBtn();
	}
	
	@Test (enabled = true, groups= "Sanity")
	public void verifyCheckOutPage1URLTest() throws EncryptedDocumentException, IOException
	{
		//String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String expURL=ReadData.readExcel(2, 0);  //2,0
		String actURL=check1.verifyCheckOutPage1URL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Checkout Page 1 URL = " + actURL);
	}
	
	@Test (enabled = true, groups= "Smoke")
	public void verifyCheckOutPage1LableTest() throws EncryptedDocumentException, IOException
	{
		//String expLable="Checkout: Your Information";
		String expLable=ReadData.readExcel(2, 1);   //2,1
		String actLable=check1.verifyCheckOutPage1Lable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Checkout Page 1 Lable = " + actLable);
	}
	
	@Test (enabled = true, groups= "Sanity")
	public void verifyinputCheckOutInfoTest() throws EncryptedDocumentException, IOException
	{
		//String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String expURL=ReadData.readExcel(2, 2);  //2,2
		String actURL=check1.inputCheckOutInfo();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Checkout Page 2 URL = " + actURL);
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

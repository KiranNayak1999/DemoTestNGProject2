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
import pages.CheckOutPage2;
import pages.InventoryPage;
import pages.LoginPages;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CheckOutPage2Test extends TestBase
{
	LoginPages login;
	InventoryPage invent;
	CartPage cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	
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
		check1.inputCheckOutInfo();
	}
	
	@Test (enabled = true, groups= "Smoke")
	public void verifycheckOutPage2LableTest() throws EncryptedDocumentException, IOException
	{
		//String expLable="Checkout: Overview";
		String expLable=ReadData.readExcel(3, 0);
		String actLable=check2.verifycheckOutPage2Lable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("CheckOut page 2 checkout Lable is = " + actLable);
	}
	
	@Test (enabled = true, groups= "Smoke")
	public void verifyshippingInfoLableTest() throws EncryptedDocumentException, IOException
	{
		//String expLable="Shipping Information";
		String expLable=ReadData.readExcel(3, 1);
		String actLable=check2.verifyshippingInfoLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("CheckOut page 2 shipping Lable is = " + actLable);
	}
	
	
	@Test (enabled = true, groups= "Smoke")
	public void verifypaymentInfoLableTest() throws EncryptedDocumentException, IOException
	{
		//String expLable="Payment Information";
		String expLable=ReadData.readExcel(3, 2);
		String actLable=check2.verifypaymentInfoLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("CheckOut page 2 payment Lable is = " + actLable);
	}
	
	@Test (enabled = true, groups= "Smoke")
	public void verifytotalAmountLableTest() throws EncryptedDocumentException, IOException
	{
		//String expLable="Price Total";
		String expLable=ReadData.readExcel(3, 3);
		String actLable=check2.verifytotalAmountLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("CheckOut page 2 Amount Lable is = " + actLable);
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

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
import pages.InventoryPage;
import pages.LoginPages;
import utility.CaptureScreenShot;
import utility.ReadData;

public class CartPageTest extends TestBase
{
	LoginPages login;
	InventoryPage invent;
	CartPage cart;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initilization();
		login=new LoginPages();
		invent=new InventoryPage();
		cart=new CartPage();
		login.loginTOApplication();
		invent.add6Product();
		invent.ClickcartCount();
	}
	
	@Test (enabled = true, groups= "Sanity")
	public void verifyCartPageURLTest() throws EncryptedDocumentException, IOException
	{
		//String expURL="https://www.saucedemo.com/cart.html";
		String expURL=ReadData.readExcel(0, 4);  //0,4
		String actURL=cart.verifyCartPageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of Cart Page = " + actURL);
	}
	
	@Test (enabled = true, groups= "Smoke")
	public void verifyyourCartLableTest() throws EncryptedDocumentException, IOException
	{
		//String expLable="Your Cart";
		String expLable=ReadData.readExcel(0, 5);  //0,5
		String actLable=cart.verifyyourCartLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Lable of Your Cart = " + actLable);	
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

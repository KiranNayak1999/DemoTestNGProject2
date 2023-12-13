package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPages;
import utility.CaptureScreenShot;
import utility.ReadData;

public class LoginTestPages extends TestBase
{
	LoginPages login;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initilization();
		login=new LoginPages();
	}
	
	@Test (enabled = true, priority=1, dependsOnMethods = "verifyURLTest", groups={"Smoke","Sanity"})
	public void verifyTitileTest() throws EncryptedDocumentException, IOException
	{
		//String expectedTitle="Swag Labs";
		String expectedTitle=ReadData.readExcel(1, 0);
		String actualTitle=login.verifyTitleOfApp();
		Assert.assertEquals(expectedTitle, actualTitle);
		Reporter.log("Verify Title of Application" + actualTitle);
	}
	
	@Test (enabled = true, priority=0, groups="Sanity")
	public void verifyURLTest() throws EncryptedDocumentException, IOException
	{
		//String expectedURL="https://www.saucedemo.com/";
		String expectedURL=ReadData.readExcel(1, 1);
		String actualURL=login.verifyURL();
		Assert.assertEquals(expectedURL, actualURL);
		Reporter.log("Verify First URL of Application" + actualURL);
	}
	
	@Test (enabled = true, priority=2, dependsOnMethods = "verifyURLTest", groups={"Regression", "Sanity"})
	public void loginToApplicationTest() throws IOException
	{
		//String expURL="https://www.saucedemo.com/inventory.html";
		String expURL=ReadData.readExcel(1, 2);
		String actURL=login.loginTOApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Verify URL Of Login Page " + actURL);
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

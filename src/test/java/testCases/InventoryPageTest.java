package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.InventoryPage;
import pages.LoginPages;
import utility.CaptureScreenShot;
import utility.ReadData;

public class InventoryPageTest extends TestBase
{
	LoginPages login;
	InventoryPage invent;

@BeforeMethod(alwaysRun = true)
public void setUp() throws InterruptedException, IOException
{
	initilization();
	login=new LoginPages();
	invent=new InventoryPage();
	login.loginTOApplication();
}

@Test (enabled = true, groups="Smoke")
public void verifyProductLableTest() throws EncryptedDocumentException, IOException
{
	//String explable="Products";
	String explable=ReadData.readExcel(1, 3);
	String actLable=invent.verifyProductLable();
	Assert.assertEquals(explable, actLable);
	Reporter.log("Lable Title = " + actLable);
}

@Test (enabled = true, groups="Smoke")
public void verifyTwitterLogoTest()
{
	boolean result=invent.verifyTwitterLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of TwitterLogo" + result);
}

@Test (enabled = true, groups="Smoke")
public void verifyFbLogoTest()
{
	boolean result=invent.verifyFbLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of FbLogo" + result);
}

@Test (enabled = true, groups="Smoke")
public void verifyLinkedinLogoTest()
{
	boolean result=invent.verifyLinkedinLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of LinkedinLogo" + result);
}

@Test (enabled = true, groups={"Regression","Sanity"})
public void add6ProductTest() throws EncryptedDocumentException, IOException
{
	
	//String expCount="6";
	String expCount=ReadData.readExcel(1, 4);
	String actCount=invent.add6Product();
	Assert.assertEquals(expCount, actCount);
	Reporter.log("Total Product Added = " + actCount);
}

@Test (enabled = true, groups={"Regression","Sanity"})
public void remove2ProductTest() throws EncryptedDocumentException, IOException, InterruptedException
{
	//String expCount="4";
	String expCount=ReadData.readExcel(1, 5);
	String actCount=invent.remove2Product();
	Assert.assertEquals(expCount, actCount);
	Reporter.log("Count of Product After Removing" +actCount);
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

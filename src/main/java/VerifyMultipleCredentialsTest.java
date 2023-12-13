import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPages;
import utility.CaptureScreenShot;
import utility.ReadData;

public class VerifyMultipleCredentialsTest extends TestBase
{
LoginPages login;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException
	{
		initilization();
		login=new LoginPages();
	}
	
	@Test /*(enabled = true, priority=2, dependsOnMethods = "verifyURLTest", groups={"Regression", "Sanity"})*/
	public void loginToApplicationTest() throws IOException
	{
		//String expURL="https://www.saucedemo.com/inventory.html";
		String expURL=ReadData.readExcel(1, 2);
		String actURL=login.loginTOApplication();
		Assert.assertEquals(expURL, actURL);
		
	}
	
	@DataProvider(name = "credentials")
	public Object getData()
	{
		return new Object [][] {
			{"standard_user","secret_sauce"},
			{"standard_user1","secret_sauce"},
			{"standard_user","standard_user"},
			{"secret_sauce","secret_sauce"},
		};
		
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

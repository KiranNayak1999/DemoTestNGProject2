package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class CaptureScreenShot extends TestBase
{
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-yyyy ss-mm-HH").format(new Date());  //Date Method 
	}
	public static void screenShot(String nameOfMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest=new File("C:\\Users\\RBC\\eclipse-workspace\\TestNGProject1\\Screenshot\\" + nameOfMethod +"---" +getDate() + ".jpeg");
		FileHandler.copy(source, Dest);
	}

}

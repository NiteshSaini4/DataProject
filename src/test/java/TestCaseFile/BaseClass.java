package TestCaseFile;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import UtilitiesFile.ReadConfiguration;

public class BaseClass 
{
	public static WebDriver driver;
	public static Logger log2;
	ReadConfiguration rb=new ReadConfiguration();
	String bro=rb.getBrowser();//Chrome
	String url=rb.getUrl();//practicetestautomation.com/practice-test-login/
	@BeforeClass
	void browserLaunch()
	{
		switch(bro.toLowerCase())
		{
		case "chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "msedge":
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			driver=null;//
			break;	
		}
		log2=LogManager.getLogger("DataDriverNewProject");
	}
	public void screenShot() throws Exception  
	{
		TakesScreenshot sc=(TakesScreenshot)driver;
		File f1=sc.getScreenshotAs(OutputType.FILE);
		File f2=new File("C:\\Users\\user\\Documents\\DataDriverNewProject\\ScreenShot\\NewReport.png");
		FileUtils.copyFile(f1, f2);
	}
}

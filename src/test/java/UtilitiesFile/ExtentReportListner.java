package UtilitiesFile;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCaseFile.TestCaseClass;

public class ExtentReportListner extends TestCaseClass implements ITestListener 
{
	ExtentSparkReporter createreport;
	ExtentReports createtest;
	ExtentTest createlog;
	void setup()
	{
		createreport=new ExtentSparkReporter("MynewReport1.html");
		createtest =new ExtentReports();
		createtest.attachReporter(createreport);
		//Set Envi....
		
		createtest.setSystemInfo("Operating_System", "Windown");
		createtest.setSystemInfo("Browser", "Chrome");
		createtest.setSystemInfo("Envirnmnet", "Testing");
		createtest.setSystemInfo("User", "Nitesh");
		
		createreport.config().setDocumentTitle("MyDemoReport");
		createreport.config().setReportName("Project_Name");
		createreport.config().setTheme(Theme.DARK);
		
	}
	
	public void onStart(ITestContext Result)
	{
		setup();
	}
	public void onTestStart(ITestResult Result )
	{
		System.out.println("Every test case");
	}
	public void onTestSuccess(ITestResult Result )
	{
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.PASS, MarkupHelper.createLabel("Pass case", ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult Result )
	{
		


		
	}

}

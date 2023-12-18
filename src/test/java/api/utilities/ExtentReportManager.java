package api.utilities;
// Extent report 5.x

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentReportManager implements ITestListener  {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	
	{
		
		String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());// time stamp
		repName="Test-Report-" + timestamp+" .html";
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName); // specify location of the report
		
		sparkReporter.config().setDocumentTitle("RestAssuredAutomationframework");//Title of report
		sparkReporter.config().setReportName("Pet Store Report");// Report name
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "pet store users API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "fahed");


	}
 public void onTestSuccess(ITestResult result)	
 
 {
	 System.out.println("On success");
	 test=extent.createTest(result.getName());
	 test.assignCategory(result.getMethod().getGroups());
	 test.createNode(result.getName());
	 test.log(Status.PASS, "Test Passed");
 }
    
public void onTestFailure(ITestResult result)	
 
 {
	 System.out.println("On Failure");
	 test=extent.createTest(result.getName());
	 test.assignCategory(result.getMethod().getGroups());
	 test.createNode(result.getName());
	 test.log(Status.FAIL, "Test Failed");
	 test.log(Status.FAIL, result.getThrowable().getMessage());

 }
public void onTestSkipped(ITestResult result)	

{
	 System.out.println("On skipped");
	 test=extent.createTest(result.getName());
	 test.assignCategory(result.getMethod().getGroups());
	 test.createNode(result.getName());
	 test.log(Status.SKIP, "Test Skipped");
	 test.log(Status.SKIP, result.getThrowable().getMessage());

}

public void onFinish(ITestResult result)
{
	
extent.flush();
}
}


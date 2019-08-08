package bluestone.generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener implements ITestListener, IAUTOCONSTANT{
	
	public static ExtentHtmlReporter reporter;
	public static ExtentTest test ;
	public static ExtentReports rep;
	public static WebDriver driver;
	
	
	public void onTestStart(ITestResult result) {
		test.log(Status.INFO, "Started: "+result.getName());
	}

	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Passed: "+result.getName());
	}

	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Failed: "+result.getName());
	}

	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Skipped: "+result.getName());		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		reporter = new ExtentHtmlReporter(new File(HTMLREPORTPATH+BaseTest.datetime+"-BSreport.html"));
		reporter.config().setDocumentTitle("BlueStone Report");;
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("BlueStone Tests");
		
		rep = new ExtentReports();
		rep.attachReporter(reporter);
		rep.setSystemInfo("Environment", ENVIRONMENT);
		rep.setSystemInfo("Engg Name", ENGGNAME);
		rep.setSystemInfo("Build", BUILD);
		rep.setSystemInfo("Platform", PLATFORM);
		
		test = rep.createTest("BlueStone Tests");
	}

	
	public void onFinish(ITestContext context) {
		try {
			 File directory = new File(PHOTO_PATH+BaseTest.datetime);
			 File[] fList = directory.listFiles();
			 for (File file : fList)
				 if (file.isFile()){
					 test.addScreenCaptureFromPath(file.getAbsolutePath());
				 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		rep.flush();
	}


}

package bluestone.generic;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

abstract public class BaseTest implements IAUTOCONSTANT {
	public static WebDriver driver;
	public static int passcount=0, failcount=0, skipcount=0;
	public static String datetime="";
	
	static{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@BeforeSuite

	public void setDateForReport(){
		LocalDateTime loc = LocalDateTime.now();
		int HH = loc.toLocalTime().getHour();
		int mm = loc.toLocalTime().getMinute();
		int DD = loc.getDayOfMonth();
		String MMM = loc.getMonth().toString().substring(0,3);
		datetime = DD+"-"+MMM+"-"+HH+"-"+mm;
	}
	
	@BeforeMethod
	public void openBrowser(){
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult res) throws InterruptedException{
		String mn = res.getName();
		int status = res.getStatus();
		String path ="";
		
		if(status==1)
			passcount++;
		else if(status==2){
			failcount++;
		}
		else if(status==3)
			skipcount++;
		path = PHOTO_PATH+datetime+"/"+mn+".png";
		FWUtils.takeScreenshot(driver, path);
		
//		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterSuite
	public void generateReport(){
		Reporter.log("Pass: "+passcount, true);
		Reporter.log("Fail: "+failcount, true);
		Reporter.log("Skip: "+skipcount, true);
		FWUtils.set_XLData(XL_REPORT_PATH, "Sheet1", 1, 0, passcount);
		FWUtils.set_XLData(XL_REPORT_PATH, "Sheet1", 1, 1, failcount);
		FWUtils.set_XLData(XL_REPORT_PATH, "Sheet1", 1, 2, skipcount);
	}

}

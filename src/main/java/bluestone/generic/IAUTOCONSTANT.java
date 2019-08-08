package bluestone.generic;

public interface IAUTOCONSTANT {
	String CHROME_KEY = "webdriver.chrome.driver";
	String CHROME_VALUE = "./src/main/resources/driver/chromedriver.exe";

	String GECKO_KEY = "webdriver.gecko.driver";
	String GECKO_VALUE = "./src/main/resources/driver/geckodriver.exe";
	
	String URL = "https://www.bluestone.com/";
	
	String XL_DATA_PATH = "./src/main/resources/data/BSinput.xlsx";
	String XL_REPORT_PATH = "./src/main/resources/report/BSreport.xlsx";
	String HTMLREPORTPATH = "./src/main/resources/report/";
	String PHOTO_PATH = "./src/main/resources/photo/";
	
	String ENVIRONMENT = "Test";
	String ENGGNAME = "Ramya";
	String BUILD = "3.15";
	String PLATFORM = "Win10 x64";
	
	long ITO = 10;
	long ETO = 10;
}

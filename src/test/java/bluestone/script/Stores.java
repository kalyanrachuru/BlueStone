package bluestone.script;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bluestone.generic.BaseTest;
import bluestone.generic.FWUtils;
import bluestone.pages.HomePage;
import bluestone.pages.StoresPage;
@Listeners(bluestone.generic.TestListener.class)
public class Stores extends BaseTest{
	
	/*
	@Test
	public void getNoOfStores(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		hp.clickVisitStores();
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 19, 1);
		StoresPage sp = new StoresPage(driver, ETO);
		//Verify page title
		sp.verifyPageTitle(etitle);
		
		Reporter.log("Number of Stores = "+sp.getNumberOfStores(),true);
		
	}
	*/
	
	@Test
	public void getStoreMaps() {
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		hp.clickVisitStores();
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 19, 1);
		StoresPage sp = new StoresPage(driver, ETO);
		//Verify page title
		sp.verifyPageTitle(etitle);
		
		sp.getStoreMapImage();
		
	}
}

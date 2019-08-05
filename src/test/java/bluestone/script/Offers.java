package bluestone.script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bluestone.generic.BaseTest;
import bluestone.generic.FWUtils;
import bluestone.pages.HomePage;
import bluestone.pages.OffersPage;
@Listeners(bluestone.generic.TestListener.class)
public class Offers extends BaseTest{
	
	@Test
	public void verify10Perc(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on offers
		hp.selectOffers();
		
		//Click on flat 10% off
		hp.clickTenPerc();
		
		//Verify offers page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 5, 1);
		OffersPage op = new OffersPage(driver, ETO);
		op.verifyPageTitle(etitle);
		
		//Verify offer percentage in each product
		if(op.verifyTenPerc())
			Reporter.log("All Products Verified", true);
		else{
			Reporter.log("Percentage Mismatch", true);
			Assert.fail();
		}
	}
	
	@Test
	public void verify20Perc(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on offers
		hp.selectOffers();
		
		//Click on flat 20% off
		hp.clickTwentyPerc();
		
		//Verify offers page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 6, 1);
		OffersPage op = new OffersPage(driver, ETO);
		op.verifyPageTitle(etitle);
		
		//Verify offer percentage in each product
		if(op.verifyTwentyPerc())
			Reporter.log("All Products Verified", true);
		else{
			Reporter.log("Percentage Mismatch", true);
			Assert.fail();
		}
	}
	
	@Test
	public void verify5Perc(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on offers
		hp.selectOffers();
		
		//Click on flat 10% off
		hp.clickFivePerc();
		
		//Verify offers page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 7, 1);
		OffersPage op = new OffersPage(driver, ETO);
		op.verifyPageTitle(etitle);
		
		//Verify offer percentage in each product
		if(op.verifyFivePerc())
			Reporter.log("All Products Verified", true);
		else{
			Reporter.log("Percentage Mismatch", true);
			Assert.fail();
		}
	}
}

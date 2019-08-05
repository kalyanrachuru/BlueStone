package bluestone.script;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bluestone.generic.BaseTest;
import bluestone.generic.FWUtils;
import bluestone.pages.HomePage;
import bluestone.pages.MensBanglesPage;
import bluestone.pages.UdithKadaPage;
@Listeners(bluestone.generic.TestListener.class)
public class Kadas extends BaseTest{
	
	@Test
	public void verifyKadaError(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Hover on all jewellery
		hp.selectAllJewellery();
		
		//Click on kadas
		hp.clickKadas();
		
		//Verify kadas Page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 2, 1);
		MensBanglesPage mb = new MensBanglesPage(driver, ETO);
		mb.verifyPageTitle(etitle);
		
		//Click any kada
		mb.clickKada();
		
		//Verify udith kada product page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 3, 1);
		UdithKadaPage uk = new UdithKadaPage(driver, ETO);
		uk.verifyPageTitle(etitle);
		
		//Click on buy now
		uk.clickBuyNow();
		
		//Check for error
		String err = uk.verifyErrorMessage();
		Assert.assertEquals(err, "* This field is required", "Error Not Displayed");
	}
	
	/*@Test
	public void verifyKadaSize(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on all jewellery
		hp.selectAllJewellery();
		
		//Click on kadas
		hp.clickKadas();
		
		//Verify kadas Page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 2, 1);
		MensBanglesPage mb = new MensBanglesPage(driver, ETO);
		mb.verifyPageTitle(etitle);
		
		//Click any kada
		mb.clickKada();
		
		//Verify udith kada product page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 3, 1);
		UdithKadaPage uk = new UdithKadaPage(driver, ETO);
		uk.verifyPageTitle(etitle);
		
		//Select bangle size
		uk.selectSize();
		
		//Click on buy now
		uk.clickBuyNow();
		
		//Go to cart and verify page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 4, 1);
		ShoppingBagPage sb = new ShoppingBagPage(driver, ETO);
		sb.verifyPageTitle(etitle);
		
		//Verify size is as selected
		if(!sb.verifySize())
			Assert.fail();
		if(!sb.verifySizeF())
			Assert.fail();
		
	}*/
	
}

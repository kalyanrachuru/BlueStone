package bluestone.script;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bluestone.generic.BaseTest;
import bluestone.generic.FWUtils;
import bluestone.pages.HomePage;
@Listeners(bluestone.generic.TestListener.class)
public class Logo extends BaseTest{
	
	@Test
	public void verifyLogoConsistency() throws InterruptedException{
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Scroll page
		for(int i=0;i<=2000;i+=300){
			hp.scrollPage(0, i);
			Thread.sleep(1000);
		}
		
		//If logo is visible, click
		if(hp.verifyLogoVisibility())
			hp.clickLogoIcon();
	}
	
}
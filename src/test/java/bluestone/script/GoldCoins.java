package bluestone.script;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bluestone.generic.BaseTest;
import bluestone.generic.FWUtils;
import bluestone.pages.GoldCoinPage;
import bluestone.pages.HomePage;
@Listeners(bluestone.generic.TestListener.class)
public class GoldCoins extends BaseTest{
	
	@Test
	public void verify1GmCoin(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on gold coins
		hp.selectGoldCoins();
		
		//Click on 1gm gold
		hp.click1Gram();
		
		//Verify gold coin Page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 8, 1);
		GoldCoinPage gc = new GoldCoinPage(driver, ETO);
		gc.verifyPageTitle(etitle);
		
		//Verify product is 1gm gold coin
		if(!gc.verify1GmCoin())
			Assert.fail();
	}
	
	@Test
	public void verify20GmCoin(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on gold coins
		hp.selectGoldCoins();
		
		//Click on 1gm gold
		hp.click20Gram();
		
		//Verify gold coin Page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 10, 1);
		GoldCoinPage gc = new GoldCoinPage(driver, ETO);
		gc.verifyPageTitle(etitle);
		
		//Verify product is 2gm gold coin
		if(!gc.verify20GmCoin())
			Assert.fail();
	}
	
	public void verify2GmCoin(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on gold coins
		hp.selectGoldCoins();
		
		//Click on 1gm gold
		hp.click2Gram();
		
		//Verify gold coin Page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 9, 1);
		GoldCoinPage gc = new GoldCoinPage(driver, ETO);
		gc.verifyPageTitle(etitle);
		
		//Verify product is 2gm gold coin
		if(!gc.verify2GmCoin())
			Assert.fail();
	}
	
	@Test
	public void verify50GmCoin(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on gold coins
		hp.selectGoldCoins();
		
		//Click on 1gm gold
		hp.click50Gram();
		
		//Verify gold coin Page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 11, 1);
		GoldCoinPage gc = new GoldCoinPage(driver, ETO);
		gc.verifyPageTitle(etitle);
		
		//Verify product is 2gm gold coin
		if(!gc.verify50GmCoin())
			Assert.fail();
	}
	
	@Test
	public void verify5GmCoin(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on gold coins
		hp.selectGoldCoins();
		
		//Click on 1gm gold
		hp.click5Gram();
		
		//Verify gold coin Page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 12, 1);
		GoldCoinPage gc = new GoldCoinPage(driver, ETO);
		gc.verifyPageTitle(etitle);
		
		//Verify product is 2gm gold coin
		if(!gc.verify5GmCoin())
			Assert.fail();
	}
}

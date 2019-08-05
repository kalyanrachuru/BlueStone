package bluestone.script;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bluestone.generic.BaseTest;
import bluestone.generic.FWUtils;
import bluestone.pages.DiamondRingsPage;
import bluestone.pages.HomePage;
import bluestone.pages.MyrnaRingPage;
import bluestone.pages.SearchPage;
@Listeners(bluestone.generic.TestListener.class)
public class Rings extends BaseTest{
	
	
	@Test
	public void verifyLowToHigh(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Hover on offers
		hp.selectRings();
		
		//Click on flat 10% off
		hp.clickRingsDiamond();
		
		//Verify diamond rings page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 13, 1);
		DiamondRingsPage dr = new DiamondRingsPage(driver, ETO);
		dr.verifyPageTitle(etitle);
		
		//Get default price list
		List<WebElement> before = dr.getPriceList();
		
		//Sort price low to high
		dr.selectSort();
		dr.clickLowToHigh();
		
		//Get sorted price list
		List<WebElement> after = dr.getPriceList();
		
		if(before.equals(after)){
			Reporter.log("Price lists are same", true);
			Assert.fail();
		}
		else
			Reporter.log("Price lists are different", true);
	}
	
	@Test
	public void verifyPriceListSorted(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Hover on offers
		hp.selectRings();
		
		//Click on flat 10% off
		hp.clickRingsDiamond();
		
		//Verify diamond rings page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 13, 1);
		DiamondRingsPage dr = new DiamondRingsPage(driver, ETO);
		dr.verifyPageTitle(etitle);
		
		//Sort price low to high
		dr.selectSort();
		dr.clickLowToHigh();
		
		//Get sorted price list
		List<WebElement> pricelist = dr.getPriceList();
		List<Integer> price = new ArrayList<Integer>();
		
		for(WebElement items:pricelist){
			String text = items.getText();
			if(text.contains("RS. "))
				price.add(Integer.parseInt((text.substring(4).replace(",",""))));
			else if(text.contains("RS."))
				price.add(Integer.parseInt((text.substring(3).replace(",",""))));
		}
		
		for(int i=0; i<price.size()-1;i++){
//			System.out.println(price.get(i)+" - "+price.get(i+1));
			if(price.get(i).compareTo(price.get(i+1))>0){
				Reporter.log("Price lists not sorted", true);
				Assert.fail();
			}
		}
		Reporter.log("Price lists is sorted", true);
	}
	
	@Test
	public void getNumberBelow10k(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Hover on offers
		hp.searchForItem("Rings");
		
		//Verify rings search page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 14, 1);
		SearchPage sr = new SearchPage(driver, ETO);
		sr.verifyPageTitle(etitle);
		
		//Select price
		sr.selectPrice();
		
		//Get number of rings below 10,000
		sr.getNumberBelow10k();
	}
	
	@Test
	public void getNumberOfNextDayDel(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Hover on offers
		hp.searchForItem("Rings");
		
		//Verify rings search page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 14, 1);
		SearchPage sr = new SearchPage(driver, ETO);
		sr.verifyPageTitle(etitle);
		
		//Click on more filters
		sr.clickMoreFilters();
		
		//Get number of rings on next day delivery
		sr.getNumberOfNextDayDelivery();
	}
	
	@Test
	public void getNumberOfPlatinum(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Hover on offers
		hp.searchForItem("Rings");
		
		//Verify rings search page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 14, 1);
		SearchPage sr = new SearchPage(driver, ETO);
		sr.verifyPageTitle(etitle);
		
		//Select Metal
		sr.selectMetal();
		
		//Get number of platinum rings
		sr.getNumberOfPlatinum();
	}
	
	@Test
	public void getNumberOf22kPurity(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Hover on offers
		hp.searchForItem("Rings");
		
		//Verify rings search page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 14, 1);
		SearchPage sr = new SearchPage(driver, ETO);
		sr.verifyPageTitle(etitle);
		
		//Select more filters
		sr.clickMoreFilters();
		
		//Get number of 22k purity rings
		sr.getNumberOfPurity22k();
	}
	
	@Test
	public void getNumberOfWomenRings(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Hover on offers
		hp.searchForItem("Rings");
		
		//Verify rings search page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 14, 1);
		SearchPage sr = new SearchPage(driver, ETO);
		sr.verifyPageTitle(etitle);
		
		//Select gender filter
		sr.selectGender();
		
		//Get number of women's rings
		sr.getNumberOfWomen();
	}
	
	
	
	@Test
	public void verifyAllPrices(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		//Hover on offers
		hp.searchForItem("Rings");

		//Verify rings search page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 14, 1);
		SearchPage sr = new SearchPage(driver, ETO);
		sr.verifyPageTitle(etitle);
		
		//Get actual price
		String act = sr.getActualPrice();
		
		//Get discount price
		String disc = sr.getDiscountPrice();
		
		//Open the product in its page
		sr.clickRing();
		
		//Verify rings product page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 20, 1);
		MyrnaRingPage mp = new MyrnaRingPage(driver, ETO);
		mp.verifyPageTitle(etitle);
		
		//Get actual price
		String pdtact = mp.getActualPrice();
		
		//Get discount price
		String pdtdisc = mp.getDiscountPrice();
		
		Assert.assertEquals(act, pdtact,"Actual Price Mismatch");
		Assert.assertEquals(disc, pdtdisc,"Discount Price Mismatch");
		
	}
	
	
}

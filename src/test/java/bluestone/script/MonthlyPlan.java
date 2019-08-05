package bluestone.script;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bluestone.generic.BaseTest;
import bluestone.generic.FWUtils;
import bluestone.pages.HomePage;
import bluestone.pages.MonthlyPlanPage;
import bluestone.pages.NomineeDetailsPage;
import bluestone.pages.PaymentOptionsPage;
import bluestone.pages.PersonalDetailsPage;
@Listeners(bluestone.generic.TestListener.class)
public class MonthlyPlan extends BaseTest{
	
	/*
	@Test
	public void verifyMonthlyPlanError(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Click on 10+1 monthly plan
		hp.clickMonthlyPlan();
		
		//Verify 10+1 monthly plan page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 15, 1);
		MonthlyPlanPage mp = new MonthlyPlanPage(driver, ETO);
		
		//Click on start now
		mp.clickStartNow();
		
		//Verify monthly amount error
		mp.verifyAmountError();
		
		//Verify email id error
		mp.verifyEmailError();
		
	}
	
	@Test
	public void verifyMonthlyPlanStart(){
		String etitle = "";
		String amt = "2000", email = "123@abc.com";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Click on 10+1 monthly plan
		hp.clickMonthlyPlan();
		
		//Verify 10+1 monthly plan page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 15, 1);
		MonthlyPlanPage mp = new MonthlyPlanPage(driver, ETO);
		
		//Enter valid amount
		mp.enterAmount(amt);
		
		//Enter valid email id
		mp.enterEmail(email);
		
		//Click on start now
		mp.clickStartNow();
		
		//Verify personal details page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 15, 1);
		PersonalDetails pd = new PersonalDetails(driver, ETO);
		
		//Verify monthly amount
		if(pd.getAmount().contentEquals(amt))
			Reporter.log("Correct amount reflected",true);
		
		//Verify email id 
		if(pd.getEmail().contentEquals(email))
			Reporter.log("Correct email reflected",true);
		
		
	}
	
	
	@Test
	public void verifyMonthlyPlanStart(){
		String etitle = "";
		String amt = "2000", email = "123@abc.com";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Click on 10+1 monthly plan
		hp.clickMonthlyPlan();
		
		//Verify 10+1 monthly plan page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 15, 1);
		MonthlyPlanPage mp = new MonthlyPlanPage(driver, ETO);
		
		//Enter valid amount
		mp.enterAmount(amt);
		
		//Enter valid email id
		mp.enterEmail(email);
		
		//Click on start now
		mp.clickStartNow();
		
		//Verify personal details page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 15, 1);
		PersonalDetails pd = new PersonalDetails(driver, ETO);
		
		//Click on next button
		pd.clickNext();
		
		//Verify errors
		pd.verifyMobileError();
		pd.verifyNameError();
		pd.verifyAddressError();
		pd.verifyPINCodeError();
		
		
	}
	*/
	
	@Test
	public void enterPersonalDetails(){
		String etitle = "";
		String amt="2000", email = "123@abc.com", mob = "9886098860", add = "123, 4th Street, 2nd Main", 
				fname = "Myname", pinc = "560000", nname = "Mynominee";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);
		
		//Click on 10+1 monthly plan
		hp.clickMonthlyPlan();
		
		//Verify 10+1 monthly plan page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 15, 1);
		MonthlyPlanPage mp = new MonthlyPlanPage(driver, ETO);
		
		//Enter valid amount
		mp.enterAmount(amt);
		
		//Enter valid email id
		mp.enterEmail(email);
		
		//Click on start now
		mp.clickStartNow();
		
		//Verify personal details page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 15, 1);
		PersonalDetailsPage pd = new PersonalDetailsPage(driver, ETO);
		
		//Enter valid information
		pd.enterMobile(mob);
		pd.enterName(fname);
		pd.enterAddress(add);
		pd.enterPINCode(pinc);
		
		//Click on next button
		pd.clickNext();
		
		//Verify nominee details page
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 17, 1);
		NomineeDetailsPage nd = new NomineeDetailsPage(driver, ETO);
		//Verify page title
		nd.verifyPageTitle(etitle);
		
		nd.enterNomineeName(nname);
		nd.selectRelationship();
		nd.selectNationality();
		
		nd.clickNext();
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 18, 1);
		PaymentOptionsPage po = new PaymentOptionsPage(driver, ETO);
		//Verify page title
		po.verifyPageTitle(etitle);
		
	}
	
	
}
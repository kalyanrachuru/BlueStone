package bluestone.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//img[contains(@src,'bs-logo-2x.png') and @class='logo-icon-holder']/..") private WebElement logo;
	@FindBy (xpath="//input[@id='search_query_top_elastic_search']") private WebElement search;
	@FindBy (xpath="//a[text()='10+1 Monthly Plan']") private WebElement plan;
	@FindBy (xpath="//a[text()='All Jewellery ']") private WebElement allj;
	@FindBy (xpath="//a[text()='Offers ']") private WebElement offs;
	@FindBy (xpath="//a[text()='Gold Coins ']") private WebElement gcs;
	@FindBy (xpath="//a[text()='Rings ']") private WebElement rings;
	@FindBy (xpath="//span[text()='Kadas']") private WebElement kadas;
	@FindBy (xpath="//span[text()='Flat 10% Off']") private WebElement tenpt;
	@FindBy (xpath="//span[text()='Flat 20% Off']") private WebElement twenpt;
	@FindBy (xpath="//span[text()='Flat 5% Off']") private WebElement fivept;
	@FindBy (xpath="(//span[text()='1 gram'])[1]") private WebElement gc1g;
	@FindBy (xpath="(//span[text()='2 gram'])[1]") private WebElement gc2g;
	@FindBy (xpath="(//span[text()='20 gram'])[1]") private WebElement gc20g;
	@FindBy (xpath="(//span[text()='50 gram'])[1]") private WebElement gc50g;
	@FindBy (xpath="(//span[text()='5 gram'])[2]") private WebElement gc5g;
	@FindBy (xpath="//a[@title='Diamond Rings' and text()='Diamond']") private WebElement dmd;
	@FindBy (xpath="//a[text()='Visit Our Stores']") private WebElement stores;
	
	
	public HomePage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public boolean verifyLogoVisibility(){
		wait.until(ExpectedConditions.visibilityOf(logo));
		Reporter.log("Logo is visible", true);		
		return true;
	}
	
	public void clickLogoIcon(){
		logo.click();
		Reporter.log("Logo clicked", true);
	}
	
	public void clickMonthlyPlan(){
		plan.click();
	}
	
	public void clickVisitStores(){
		stores.click();
	}
	
	public void scrollPage(int x, int y){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll("+x+", "+y+")");
	}
	
	public void searchForItem(String str){
		search.sendKeys(str,Keys.ENTER);
	}
	
	public void selectAllJewellery(){
		Actions act = new Actions(driver);
		act.moveToElement(allj);
		act.perform();
	}
	
	public void selectOffers(){
		Actions act = new Actions(driver);
		act.moveToElement(offs);
		act.perform();
	}
	
	public void selectGoldCoins(){
		Actions act = new Actions(driver);
		act.moveToElement(gcs);
		act.perform();
	}
	
	public void selectRings(){
		Actions act = new Actions(driver);
		act.moveToElement(rings);
		act.perform();
	}
	
	public void clickKadas(){
		kadas.click();
	}
	
	public void clickTenPerc(){
		tenpt.click();
	}
	
	public void clickTwentyPerc(){
		twenpt.click();
	}
	
	public void clickFivePerc(){
		fivept.click();
	}
	
	public void click1Gram(){
		gc1g.click();
	}
	
	public void click2Gram(){
		gc2g.click();
	}
	
	public void click20Gram(){
		gc20g.click();
	}
	
	public void click50Gram(){
		gc50g.click();
	}
	
	public void click5Gram(){
		gc5g.click();
	}
	
	public void clickRingsDiamond(){
		dmd.click();
	}
	
}

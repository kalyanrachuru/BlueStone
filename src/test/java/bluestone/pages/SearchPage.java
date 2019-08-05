package bluestone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SearchPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//span[text()='Price']") private WebElement price;
	@FindBy (xpath="//span[@data-displayname='below rs 10000']/span[3]") private WebElement below10k;
	@FindBy (xpath="//span[text()='Metal']") private WebElement metal;
	@FindBy (xpath="//span[text()='Gender']") private WebElement gender;
	@FindBy (xpath="//span[text()='More Filters']") private WebElement morefils;
	@FindBy (xpath="//span[@data-displayname='next day delivery']/span[2]") private WebElement nextday;
	@FindBy (xpath="//span[@data-displayname='platinum']/span[2]") private WebElement platinum;
	@FindBy (xpath="//span[@data-displayname='22k']/span[2]") private WebElement pur22k;
	@FindBy (xpath="//span[@data-displayname='women']/span[2]") private WebElement women;
	@FindBy (xpath="//a[@id='pid_7514' and @class='link-overlay']") private WebElement ring;
	@FindBy (xpath="//a[@id='pid_7514' and @class='link-overlay']/../span/span[1]/span[1]") private WebElement damt;
	@FindBy (xpath="//a[@id='pid_7514' and @class='link-overlay']/../span/span[1]/span[2]") private WebElement aamt;
	
	public SearchPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public void selectPrice(){
		Actions act = new Actions(driver);
		act.moveToElement(price);
		act.perform();
	}	
	
	public void getNumberBelow10k(){
		wait.until(ExpectedConditions.elementToBeClickable(below10k));
		Reporter.log(below10k.getText().replace("(", "").replace(")", "")+" Rings below 10,000",true);
	}
	
	public void selectMetal(){
		Actions act = new Actions(driver);
		act.moveToElement(metal);
		act.perform();
	}	
	
	public void selectGender(){
		Actions act = new Actions(driver);
		act.moveToElement(gender);
		act.perform();
	}	
	
	public void getNumberOfNextDayDelivery(){
		Reporter.log(nextday.getAttribute("textContent").replace("(", "").replace(")", "")+" Delivery for Next Day",true);
	}
	
	public void getNumberOfPlatinum(){
		Reporter.log(platinum.getText().replace("(", "").replace(")", "")+" Rings are Platinum",true);
	}
	
	public void getNumberOfPurity22k(){
		Reporter.log(pur22k.getText().replace("(", "").replace(")", "")+" Rings are 22K",true);
	}
	
	public void getNumberOfWomen(){
		Reporter.log(women.getText().replace("(", "").replace(")", "")+" Rings are for Women",true);
	}
	
	public void clickMoreFilters(){
		morefils.click();
	}
	
	public void clickRing(){
		ring.click();
	}
	
	public String getDiscountPrice(){
		return damt.getText().replace("RS.", "").replace(",", "");
	}
	
	public String getActualPrice(){
		return aamt.getText().replace("RS.", "").replace(",", "");
	}
	
}

package bluestone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class MyrnaRingPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//div[@id='ab_test_new']/div/div/span") private WebElement aamt;
	@FindBy (xpath="//div[@id='ab_test_new']/div/div/div[2]") private WebElement damt;
	
	public MyrnaRingPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public String getDiscountPrice(){
		return damt.getText().replace("Rs.", "").replace(",", "");
	}
	
	public String getActualPrice(){
		return aamt.getText().replace("Rs.", "").replace(",", "");
	}
	
}

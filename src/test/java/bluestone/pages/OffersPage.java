package bluestone.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class OffersPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//span[@class='orange-color']") private List<WebElement> lpt;
	
	public OffersPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public boolean verifyTenPerc(){
		for(WebElement pdt:lpt){
			if(pdt.getText().equals("(10% off)"))
				continue;
			else{
				Reporter.log("Percentage Mismatch",true);
				return false;
			}
		}
		return true;
	}
	
	public boolean verifyTwentyPerc(){
		for(WebElement pdt:lpt){
			if(pdt.getText().equals("(20% off)"))
				continue;
			else{
				Reporter.log("Percentage Mismatch",true);
				return false;
			}
		}
		return true;
	}
	
	public boolean verifyFivePerc(){
		for(WebElement pdt:lpt){
			if(pdt.getText().equals("(5% off)"))
				continue;
			else{
				Reporter.log("Percentage Mismatch",true);
				return false;
			}
		}
		return true;
	}
	
}

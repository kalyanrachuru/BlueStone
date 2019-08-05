package bluestone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class GoldCoinPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//h1[@class='title-5']") private WebElement gcgm;
	
	public GoldCoinPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public boolean verify1GmCoin(){
		if(gcgm.getText().contains("1 gram"))
			Reporter.log("Gold Coin = 1 gram",true);
		else{
			Reporter.log("Gram Mismatch",true);
			return false;
		}
		return true;
	}
	
	public boolean verify2GmCoin(){
		if(gcgm.getText().contains("2 gram"))
			Reporter.log("Gold Coin = 2 gram",true);
		else{
			Reporter.log("Gram Mismatch",true);
			return false;
		}
		return true;
	}
	
	public boolean verify20GmCoin(){
		if(gcgm.getText().contains("20 gram"))
			Reporter.log("Gold Coin = 20 gram",true);
		else{
			Reporter.log("Gram Mismatch",true);
			return false;
		}
		return true;
	}
	
	public boolean verify50GmCoin(){
		if(gcgm.getText().contains("50 gram"))
			Reporter.log("Gold Coin = 50 gram",true);
		else{
			Reporter.log("Gram Mismatch",true);
			return false;
		}
		return true;
	}
	
	public boolean verify5GmCoin(){
		if(gcgm.getText().contains("5 gram"))
			Reporter.log("Gold Coin = 5 gram",true);
		else{
			Reporter.log("Gram Mismatch",true);
			return false;
		}
		return true;
	}
	
	
}

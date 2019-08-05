package bluestone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ShoppingBagPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//div[text()=' Bangle Size ']/../div[2]") private WebElement abansize;
	
	public ShoppingBagPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public boolean verifySize(){
		if(abansize.getText().equals("2-8(2 8/16\")")){
			Reporter.log("Size Matching",true);
			return true;
		}
		else{
			Reporter.log("Size Mismatch",true);
			return false;
		}
	}
	public boolean verifySizeF(){
		if(abansize.getText().equals("2-8(2 8/\")")){
			Reporter.log("Size Matching",true);
			return true;
		}
		else{
			Reporter.log("Size Mismatch",true);
			return false;
		}
	}
}

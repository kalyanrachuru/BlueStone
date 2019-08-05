package bluestone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class UdithKadaPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//span[text()=' Select Size ']") private WebElement size;
	@FindBy (xpath="//span[text()='2-8(2 8/16\")']") private WebElement bansize;
	@FindBy (xpath="//input[@id='buy-now']") private WebElement buynow;
	@FindBy (xpath="//div[@class='formErrorContent']") private WebElement error;
	
	public UdithKadaPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public void selectSize(){
		size.click();
		bansize.click();
	}
	
	public void clickBuyNow(){
		buynow.click();
	}
	
	public String verifyErrorMessage(){
		return error.getText();
	}
	
}

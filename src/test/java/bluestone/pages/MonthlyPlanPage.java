package bluestone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class MonthlyPlanPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//input[@id='gmsStart']") private WebElement start;
	@FindBy (xpath="//input[@id='amount']") private WebElement amount;
	@FindBy (xpath="//input[@id='Email']") private WebElement email;
	
	public MonthlyPlanPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public void clickStartNow(){
		start.submit();
	}
	
	public void enterAmount(String amt){
		amount.sendKeys(amt);
	}
	
	public void enterEmail(String mail){
		email.sendKeys(mail);
	}
	
	public void verifyAmountError(){
		Reporter.log(amount.getText(),true);
	}
	
	public void verifyEmailError(){
		Reporter.log(email.getText(),true);
	}
	
}

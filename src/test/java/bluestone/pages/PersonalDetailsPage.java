package bluestone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class PersonalDetailsPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//span[text()='Total']/../span[2]") private WebElement amount;
	@FindBy (xpath="//label[text()='Email address']/../input") private WebElement email;
	@FindBy (xpath="//input[@value='Next']") private WebElement nextBTN;
	@FindBy (xpath="//ul[@id='contactNumber_error']/../input") private WebElement mobno;
	@FindBy (xpath="//input[@id='contactNumber']") private WebElement mobno1;
	@FindBy (xpath="//input[@id='fullname']") private WebElement name;
	@FindBy (xpath="//textarea[@id='address']") private WebElement addr;
	@FindBy (xpath="//input[@id='postcode_delivery']") private WebElement pin;
	
	public PersonalDetailsPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public String getAmount(){
		return amount.getText().replace("Rs ", "").replace(",", "");
	}
	
	public String getEmail(){
		return email.getAttribute("value");
	}
	
	public void clickNext(){
		nextBTN.click();
	}
	
	public void verifyMobileError(){
		Reporter.log(mobno.getAttribute("title"),true);
	}
	
	public void verifyNameError(){
		Reporter.log(name.getText(),true);
	}
	
	public void verifyAddressError(){
		Reporter.log(addr.getText(),true);
	}
	
	public void verifyPINCodeError(){
		Reporter.log(pin.getText(),true);
	}
	
	public void enterMobile(String mob){
		mobno1.clear();
		mobno1.sendKeys(mob);
	}
	
	public void enterName(String fname){
		name.clear();
		name.sendKeys(fname);
	}
	
	public void enterAddress(String add){
		addr.clear();
		addr.sendKeys(add);
	}
	
	public void enterPINCode(String pinc){
		pin.clear();
		pin.sendKeys(pinc);
	}
	
}

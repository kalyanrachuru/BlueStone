package bluestone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class NomineeDetailsPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//input[@id='nomineeName']") private WebElement name;
	@FindBy (xpath="//select[@id='nomineeRelationship']") private WebElement rel;
	@FindBy (xpath="//select[@id='nomineeNationality']") private WebElement nat;
	@FindBy (xpath="//input[@value='Next']") private WebElement nextBTN;

	
	public NomineeDetailsPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public void clickNext(){
		nextBTN.click();
	}
	
	public void enterNomineeName(String nname){
		name.clear();
		name.sendKeys(nname);
	}
	
	public void selectRelationship(){
		Select sel = new Select(rel);
		sel.selectByVisibleText("Mother");
	}
	
	public void selectNationality(){
		Select sel = new Select(nat);
		sel.selectByVisibleText("Indian");
	}
	
}

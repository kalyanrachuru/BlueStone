package bluestone.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class DiamondRingsPage {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//section[@class='block sort-by pull-right']") private WebElement sort;
	@FindBy (xpath="//a[text()='Price Low to High ']") private WebElement ltoh;
	
	public DiamondRingsPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public void selectSort(){
		Actions act = new Actions(driver);
		act.moveToElement(sort);
		act.perform();
	}
	
	public void clickLowToHigh(){
		wait.until(ExpectedConditions.elementToBeClickable(ltoh));
		ltoh.click();
	}
	
	public List<WebElement> getPriceList(){
		return driver.findElements(By.xpath("//span[@class='new-price']"));
	}
	
	
	
}

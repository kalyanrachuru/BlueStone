package bluestone.pages;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Predicate;

public class StoresPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public FluentWait<WebDriver> fwait;
	
	@FindBy (xpath="//div[@class='get-direction']") private List<WebElement> nostores;
	@FindBy (xpath="//div[@class='map-image']") private List<WebElement> maps;
	@FindBy (xpath="//header") private WebElement header;

	
	public StoresPage(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
		fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public int getNumberOfStores(){
		return nostores.size();
	}
	
	public void getStoreMapImage() {
		
		try {
			JavascriptExecutor jse = ((JavascriptExecutor)driver);
			for(int i=0;i<maps.size();i++) {
				WebElement map = maps.get(i);
				int y = map.getRect().y;
				int offy = header.getRect().height;
				jse.executeScript("window.scroll(0"+", "+(y-offy)+")");
				Thread.sleep(1000);
				File src = map.getScreenshotAs(OutputType.FILE);
				File dest = new File("./src/main/resources/photo/stores/map"+(i+1)+".png");
				FileUtils.copyFile(src, dest);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

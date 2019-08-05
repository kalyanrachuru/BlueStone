package bluestone.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ChatExpertsFrame {
	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy (xpath="//iframe[@id='chat-widget']") private WebElement frame;
	@FindBy (xpath="//p[text()='CHAT with our experts !']") private WebElement chat;
	@FindBy (xpath="//input[@id='name']") private WebElement name;
	@FindBy (xpath="//input[@id='email']") private WebElement email;
	@FindBy (xpath="//input[@id='name_146917605549304831']") private WebElement phone;
	@FindBy (xpath="//button[@class='lc-yp53ho esv0owm0']") private WebElement start;
	@FindBy (xpath="//div[@class='lc-yf4dof ek650k30']") private WebElement agent;
	@FindBy (xpath="//span[@class='lc-xiwau9 e10ccb471']") private WebElement agentname;
	@FindBy (xpath="//span[@class='lc-xiwau9 e10ccb471']/../../../div[2]") private WebElement agentmsg;
	@FindBy (xpath="//div[@class='lc-1hyoz7j e10ccb472']") private WebElement myname;
	@FindBy (xpath="//div[@class='lc-1hyoz7j e10ccb472']/../../div[2]") private WebElement mymsg;
	@FindBy (xpath="//textarea[@class='lc-p6zh97 e1m92qam0']") private WebElement txtarea;

	
	public ChatExpertsFrame(WebDriver driver, long ETO){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void verifyPageTitle(String etitle){
		String atitle = driver.getTitle();
		Reporter.log("Page: "+atitle, true);
		Assert.assertEquals(atitle, etitle);
	}
	
	public void switchFrame(){
		driver.switchTo().frame(frame);
	}
	
	public void openChatBox(){
		chat.click();
	}
	
	public void setName() {
		name.clear();
		name.sendKeys("abc");
	}
	
	public void setEmail() {
		email.clear();
		email.sendKeys("abc@123.com");
	}
	
	public void setPhone() {
		phone.clear();
		phone.sendKeys("9886098860");
	}
	
	public void clickStartChat() {
		start.click();
	}
	
	public void getAgentInfo() {
		Reporter.log("Agent Info: "+agent.getText(),true);
	}
	
	public void getAgentMessages() {
		if(agent.getText().contains(agentname.getText()))
			Reporter.log("Agent Message: "+agentmsg.getText(),true);
	}
	
	public void getMyMessages() {
		if(myname.getText().contains("abc"))
			Reporter.log("My Message: "+mymsg.getText(),true);
	}
	
	public void sendChat(){
		txtarea.clear();
		txtarea.sendKeys("I want to make gold investment.",Keys.ENTER);
	}
	
	public void getResponse(){
	}
	
}

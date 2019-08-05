package bluestone.script;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bluestone.generic.BaseTest;
import bluestone.generic.FWUtils;
import bluestone.pages.ChatExpertsFrame;
import bluestone.pages.HomePage;
@Listeners(bluestone.generic.TestListener.class)
public class ChatExperts extends BaseTest{
	
	@Test
	public void chatWithExpert(){
		String etitle = "";
		
		etitle = FWUtils.get_XLData(XL_DATA_PATH, "Pages", 1, 1);
		HomePage hp = new HomePage(driver, ETO);
		//Verify page title
		hp.verifyPageTitle(etitle);

		ChatExpertsFrame cf = new ChatExpertsFrame(driver, ETO);
		//Switch to frame
		cf.switchFrame();
		
		//Open chat window
		cf.openChatBox();
		
		//Enter name
		cf.setName();
		
		//Enter email id
		cf.setEmail();
		
		//Enter phone
		cf.setPhone();
		
		//Start the chat
		cf.clickStartChat();
		
		//Get agent info
		cf.getAgentInfo();
		
		//Get agent messages
		cf.getAgentMessages();
		
		//Send chat to agent
		cf.sendChat();
		
		//Get my message
		cf.getMyMessages();
	}
	
}

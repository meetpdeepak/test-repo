package pageEvents;

import base.BaseTest;
import pageObjets.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {
	ElementFetch ele = new ElementFetch();
	public void signInButton() 
	
	{
	
		ele.getWebElement("XPATH", HomePageElements.signInButtonText).click();
		
	}

}

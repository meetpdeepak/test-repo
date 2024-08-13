package qa.tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageObjets.LoginPageElements;
import utils.ElementFetch;

public class Testcase1 extends BaseTest {
	
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage= new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
  @Test
  public void sampleMethodForEnteringCredentials() {
	
	  logger.info("signin into LoginPage");
	  homePage.signInButton();
	  logger.info("Verifying if Login text is present or not");
	  loginPage.verifyIfLoginPageIsLoaded();
	  logger.info("Enter the credentials");
	  loginPage.enterCredentials();
  }
}

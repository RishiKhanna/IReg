package org.testng.pages;


import static org.testng.pages.locators.SignInPageLocators.*;

import java.util.Properties;

import org.testng.propertymgr.PropertyManager;

public class SignInPage extends PageBase{

	private final static Properties homeProperties = new PropertyManager()
	.loadPropertyFile("/src/main/resources/org/test/properties/home.properties");
	
	public void enterUserName(String userName) {
		action.enterText(userNameLocator,userName);
	}
	
	public void enterPassword(String password) {
		action.enterText(passwordLocator, password);
	}
	
	public void clickLogin() {
		action.clickByJQuery(signInButtonLocator);
	}
	
	
	public HomePage switchToHomePage(){
		action.switchToSecondaryWindow(homeProperties.getProperty("homePageTitle"));
		return new HomePage();
	}
}

package org.testng.pages.locators;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.propertymgr.PropertyManager;

public class HomePageLocators {
	
	private final static Properties homeProperties = new PropertyManager()
	.loadPropertyFile("/src/main/resources/org/test/properties/home.properties");
	
	public static By homePageOptionsLocator = By.cssSelector(homeProperties.getProperty("homePageOptionsLocator"));
	public static By subOptionsLocator = By.cssSelector(homeProperties.getProperty("subOptionsLocator"));
	public static By subFolderOptionsLocator= By.cssSelector(homeProperties.getProperty("subFolderOptionsLocator"));

}

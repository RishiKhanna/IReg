package org.testng.pages.locators;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.propertymgr.PropertyManager;

public class MastersLocators {

	private final static Properties cutomerProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/masters.properties");

	public static By customerCodeLocator = By.id(cutomerProperties
			.getProperty("customerCodeLocator"));
	public static By customerNameLocator = By.id(cutomerProperties
			.getProperty("customerNameLocator"));
	public static By customerURLLocator = By
			.id(cutomerProperties.getProperty("customerURLLocator"));
	public static By customerLevelTypeLocator = By.id(cutomerProperties
			.getProperty("customerLevelTypeLocator"));
	public static By customerBelongsToLocator = By.id(cutomerProperties
			.getProperty("customerBelongsToLocator"));
	public static By customerOptionsMenuButtonLocator = By.id(cutomerProperties
			.getProperty("customerOptionsMenuButtonLocator"));
	public static By customerMenuOptionsLocator = By.cssSelector(cutomerProperties
			.getProperty("customerMenuOptionsLocator"));
	public static By customerSearchTextBoxLocator = By.cssSelector(cutomerProperties
			.getProperty("customerSearchTextBoxLocator"));
	public static By customerDetailsLocator = By.cssSelector(cutomerProperties
			.getProperty("customerDetailsLocator"));
}

package org.testng.pages.locators;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.propertymgr.PropertyManager;

public class OrdersPageLocators {
	
	private final static Properties orderProperties = new PropertyManager()
	.loadPropertyFile("/src/main/resources/org/test/properties/order.properties");
	
	public static By firstRowInListLocator = By.cssSelector(orderProperties
			.getProperty("firstRowInListLocator"));
	public static By editItemOptionLocator = By.cssSelector(orderProperties
			.getProperty("editItemOptionLocator"));
	public static By internalNumberTextBoxLocator = By.id(orderProperties
			.getProperty("internalNumberTextBoxLocator"));
	public static By purchaseOrderMenuButtonLocator = By.id(orderProperties
			.getProperty("purchaseOrderMenuButtonLocator"));
	public static By saveAndCloseOptionLocator = By.id(orderProperties
			.getProperty("saveAndCloseOptionLocator"));
	public static By firstRowInternalNumberValueLocator = By.cssSelector(orderProperties
			.getProperty("firstRowInternalNumberValueLocator"));

}

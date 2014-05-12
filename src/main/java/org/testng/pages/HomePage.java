package org.testng.pages;

import static org.testng.pages.locators.HomePageLocators.*;

public class HomePage extends PageBase {

	public HomePage clickOnOrder() {
		action.selectOption(homePageOptionsLocator, "Order");
		return this;
	}

	public OrdersPage selectOrderList() {
		action.selectOption(subOptionsLocator, "List");
		return new OrdersPage();
	}

	public HomePage clickOnMaster() {
		action.selectOption(homePageOptionsLocator, "Masters");
		return this;
	}

	public HomePage clickOnCustomer() {
		action.selectOption(subOptionsLocator, "Customer");
		return this;
	}

	public MastersPage selectCustomerList() {
		action.selectOption(subFolderOptionsLocator, "List");
		return new MastersPage();
	}

	public MastersPage selectAddCustomer() {
		action.selectOption(subFolderOptionsLocator, "Add");
		return new MastersPage();
	}
}

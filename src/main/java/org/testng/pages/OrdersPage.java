package org.testng.pages;

import static org.testng.pages.locators.OrdersPageLocators.*;

public class OrdersPage extends PageBase{

	public OrdersPage contextClickOnFirstRow() {
		action.contextClick(firstRowInListLocator);
		return this;
	}

	public OrdersPage selectEditDetailsOption() {
		action.click(editItemOptionLocator);
		return this;
	}

	public OrdersPage storeDataInCookie() {
		action.storeDataInCookie("internalTextBoxCookie",
				util.convertToString(util.randomNumberGenerator()));
		return this;
	}

	public OrdersPage enterInternalOrderNumber() {
		action.enterText(internalNumberTextBoxLocator,
				action.retrieveDataFromCookie("internalTextBoxCookie"));;
		return this;
	}

	public OrdersPage clickPurchaseOrderMenu() {
		action.click(purchaseOrderMenuButtonLocator);
		return this;
	}

	public OrdersPage selectSaveAndCloseOption() {
		action.click(saveAndCloseOptionLocator);
		return this;
	}

	public boolean verifyUpdatedInternalOrderNumber() {
		return verify.compareExactText(
				action.getAttributeValue(firstRowInternalNumberValueLocator, "innerText"),
				action.retrieveDataFromCookie("internalTextBoxCookie"));
	}
}

package org.testng.pages;

import static org.testng.pages.locators.MastersLocators.*;

public class MastersPage extends PageBase {

	public MastersPage enterCustomerCode(String value) {
		action.storeDataInCookie("customerCode", value);
		action.enterText(customerCodeLocator, value);
		return this;
	}

	public MastersPage enterCustomerName(String value) {
		action.enterText(customerNameLocator, value);
		return this;
	}

	public MastersPage enterCustomerURL(String value) {
		action.enterText(customerURLLocator, value);
		return this;
	}

	public MastersPage selectCustomerLevelTypeOption(String value) {
		action.selectFromDropDown(customerLevelTypeLocator, value);
		return this;
	}

	public MastersPage selectCustomerBelongsToOption(String value) {
		action.selectFromDropDown(customerBelongsToLocator, value);
		return this;
	}

	public MastersPage clickCustomerOptionsMenuButton() {
		action.click(customerOptionsMenuButtonLocator);
		return this;
	}

	public MastersPage selectSaveAndCloseOption() {
		action.selectOption(customerMenuOptionsLocator, "Save & Close");
		return this;
	}

	public MastersPage enterCustomerSearchCriteria() {
		action.enterText(customerSearchTextBoxLocator,
				action.retrieveDataFromCookie("customerCode"));
		return this;
	}

	public boolean verifyCustomerDetails(String [][] strExcel) {
		String str[]=action.getWebElementsTextInStringArray(customerDetailsLocator);
		return verify.compareMultipleText(strExcel, str, 1, 3);
	}
}

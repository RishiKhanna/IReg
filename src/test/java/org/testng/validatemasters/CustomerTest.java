package org.testng.validatemasters;

import org.ireg.testbase.TestBase;
import org.testng.annotations.Test;
import org.testng.pages.MastersPage;

public class CustomerTest extends TestBase {

	private MastersPage mastersPage;

	@Test
	public void navigateToCustomer() {
		homePage.clickOnMaster();
		homePage.clickOnCustomer();
	}

	@Test
	public void verifyUserIsAbleToViewTheAddedCustomer() {
		mastersPage = homePage.selectCustomerList();
	}

	@Test(dataProvider = "ReadExcel")
	public void verifyUserIsAbleToAddACustomerSuccessfully(String customerName, String customerURL,
			String customerLevelType, String customerBelongsTo) throws InterruptedException {
		mastersPage = homePage.selectAddCustomer();
		mastersPage.enterCustomerCode(util.convertToString(util.randomNumberGenerator()));
		mastersPage.enterCustomerName(customerName);
		mastersPage.enterCustomerURL(customerURL);
		mastersPage.selectCustomerLevelTypeOption(customerLevelType);
		mastersPage.selectCustomerBelongsToOption(customerBelongsTo);
		mastersPage.clickCustomerOptionsMenuButton();
		mastersPage.selectSaveAndCloseOption();
		mastersPage.enterCustomerSearchCriteria();
		mastersPage.verifyCustomerDetails(strorage);
		Thread.sleep(9000);
	}
}

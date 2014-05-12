package org.testng.validateorders;

import java.util.Properties;

import org.ireg.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.pages.OrdersPage;
import org.testng.propertymgr.PropertyManager;

public class OrderTest extends TestBase {

	private final static Properties signinProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/signin.properties");
	private OrdersPage ordersPage;

	@Test
	public void applicationLoginIn() {
		signInPage.enterUserName(signinProperties.getProperty("userName"));
		signInPage.enterPassword(signinProperties.getProperty("password"));
		signInPage.clickLogin();
		homePage = signInPage.switchToHomePage();
	}

	@Test
	public void verifyUserIsAbleToEditOrderSuccessfully() {
		try {
			homePage.clickOnOrder();
			ordersPage = homePage.selectOrderList();
			ordersPage.contextClickOnFirstRow();
			ordersPage.selectEditDetailsOption();
			ordersPage.storeDataInCookie();
			ordersPage.enterInternalOrderNumber();
			ordersPage.clickPurchaseOrderMenu();
			ordersPage.selectSaveAndCloseOption();
			Assert.assertTrue(ordersPage.verifyUpdatedInternalOrderNumber());
			report.sendStatusToReport(1, "Validate Orders", "TC1",
					"Verify that user is able to Edit  Order successfully", "Pass", "NA");
		} catch (AssertionError as) {
			report.sendStatusToReport(1, "Validate Orders", "TC1",
					"Verify that user is able to Edit  Order successfully", "Fail", as.getMessage());
			Assert.fail(as.getMessage());
		}
	}
}

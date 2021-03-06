package org.ireg.testbase;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.pages.HomePage;
import org.testng.pages.PageBase;
import org.testng.pages.SignInPage;
import org.testng.utilities.ExcelRead;
import org.testng.utilities.Logg;
import org.testng.utilities.Reporter;
import org.testng.utilities.Utilities;

public class TestBase {
	protected static Reporter report = null;
	protected final Logger log = Logg.createLogger();
	protected final PageBase page = new PageBase();
	protected final static Utilities util = new Utilities();
	protected final static SignInPage signInPage = new SignInPage();
	protected static HomePage homePage;
	protected static String[][] strorage = null;
	
	@DataProvider(name = "ReadExcel")
	public String[][] readDataFromExcel(Method m) {
		log.info("Data Provider: Read Excel");
		log.info("Data Provider: Running for Method: " + m.getName());
		if ("verifyUserIsAbleToAddACustomerSuccessfully".equals(m.getName())) {
			strorage = ExcelRead.readTestData("Customer");
			log.info("Data Provider: Retrieved data from the Customer Sheet of Test Data Excel");
		} else if (m.getName().equals("")) {
			strorage = ExcelRead.readTestData("Sheet2");
		}
		return strorage;
	}

	@AfterTest
	public void afterMethod() {
		page.closeBrowser();
	}

	@BeforeTest
	public void beforeTest() {
		report = new Reporter();
		report.generateReport();
		page.openBrowser();
	}
}
package org.testng.actions;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.driverinit.DriverInitialization;
import org.testng.propertymgr.PropertyManager;
import org.testng.utilities.Logg;
import org.testng.waits.WebDriverWaits;

public class BrowserActions {

	private static WebDriver driver;
	private final Verifications verify = new Verifications();
	private final Logger log = Logg.createLogger();
	private final Properties applicationProperty = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/application.properties");
	private final WebDriverWaits wait = new WebDriverWaits();
	private static Cookie cookie;

	public void storeDataInCookie(String key, String value) {
		cookie = new Cookie(key, value);
		log.info("Cookie description");
		log.info("Key=" + key + " " + "Value=" + value);
		driver.manage().addCookie(cookie);
		log.info("Successfully added cookie named " + key + " to the HTML page");
	}

	public String retrieveDataFromCookie(String key) {
		log.info("Retrieving the value " + driver.manage().getCookieNamed(key).getValue()
				+ " stored in the cookie");
		return driver.manage().getCookieNamed(key).getValue();
	}

	public void openURL() {
		try {
			driver = DriverInitialization.getDriver();

			log.info("Navigating to Application URL:"
					+ applicationProperty.getProperty("applicationURL"));
			driver.get(applicationProperty.getProperty("applicationURL"));
			driver.manage().window().maximize();
			log.info("Successfully navigated to the Application URL");
		} catch (Exception ex) {
			log.fatal("Error in navigating the URL:"
					+ applicationProperty.getProperty("applicationURL"));
			ex.printStackTrace();
			closeBrowser();
		}
	}

	public void closeBrowser() {
		log.info("Closing the browser");
		driver.quit();
		DriverInitialization.resetDriver();
		log.info("Sucessfully closed the browser" + "\n");
	}

	public void enterText(By element, String value) throws TimeoutException {
		WebElement webElement = null;
		webElement = wait.waitForElementVisibility(driver, element);
		log.info("Clearing the content of the text box");
		webElement.clear();
		log.info("Contents cleared");
		webElement.sendKeys(value);
		log.info("Entered text:" + value + " in text box with locator:" + element);
	}

	public void click(By element) throws TimeoutException {
		wait.waitForElementClickability(driver, element).click();
		log.info("Clicked on element with locator:" + element);
	}

	public void contextClick(By element) throws TimeoutException {
		Actions action = new Actions(driver);
		action.contextClick(wait.waitForElementVisibility(driver, element)).perform();
		log.info("Context clicked on element with locator:" + element);
	}

	public void clickByJQuery(String element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("$('" + element + "').click()");
		log.info("Clicked on element with locator:" + element + " using JQuery");
	}

	public void submitForm(By element) throws TimeoutException {
		wait.waitForElementVisibility(driver, element).submit();
		log.info("Clicked on form submit button:" + element);
	}

	public void switchToSecondaryWindow(String windowTitle) {
		log.info("Supplied window title: " + windowTitle);
		Set<String> windows = driver.getWindowHandles();
		for (String strWindows : windows) {
			if (driver.switchTo().window(strWindows).getTitle().equals(windowTitle)) {
				log.info("Switched to the window with title: "
						+ driver.switchTo().window(strWindows).getTitle());
				driver.switchTo().window(strWindows).manage().window().maximize();
				log.info("Maximized the window with title "
						+ driver.switchTo().window(strWindows).getTitle());
				break;
			}
		}
	}

	public void selectOption(By parentLocator, String value) {
		List<WebElement> element = wait.waitForElementsVisibility(driver, parentLocator);
		for (int i = 0; i < element.size(); i++) {
			String temp = element.get(i).getAttribute("innerText")
					.replace((char) 0x00a0, (char) 0x0020);
			if (verify.compareExactText(value, (temp.trim()))) {
				log.info("Clicking on option " + value);
				element.get(i).click();
				log.info("Successfully Clicked on option " + temp);
				break;
			}
		}
	}

	public void selectFromDropDown(By element, String value) {
		Select select = new Select(wait.waitForElementVisibility(driver, element));
		select.selectByVisibleText(value);
		log.info("Selected:" + value + " from drop-down with locator:" + element);
	}

	public String getText(By element) {
		log.info("Actual Value:" + wait.waitForElementVisibility(driver, element).getText());
		return wait.waitForElementVisibility(driver, element).getText();
	}

	public String getTitle() {
		log.info("Title of the page:" + driver.getTitle());
		return driver.getTitle();
	}

	public String getAttributeValue(By element, String attribute) {
		log.info("Retrieving the attribute " + attribute + " of element " + element);
		return wait.waitForElementVisibility(driver, element).getAttribute(attribute);
	}

	public String[] getWebElementsTextInStringArray(By locator) {
		log.info("Coverting the locator into a list of String Array");
		List<WebElement> weblElementList = wait.waitForElementsPresence(driver, locator);
		log.info("List of size=" + weblElementList.size() + " elements created");
		String str[]=new String [weblElementList.size()];
		for (int i = 0; i < weblElementList.size(); i++) {
			str[i]=weblElementList.get(i).getAttribute("innerText");
		}
		return str;
	}
}

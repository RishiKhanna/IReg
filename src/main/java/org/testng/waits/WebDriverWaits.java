package org.testng.waits;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.propertymgr.PropertyManager;
import org.testng.utilities.Logg;
import org.testng.utilities.Utilities;

public class WebDriverWaits {

	private Logger log = Logg.createLogger();
	private Utilities util = new Utilities();
	private final static Properties frameworkProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/framework/properties/framework.properties");

	public WebElement waitForElementVisibility(WebDriver driver, By locator)
			throws TimeoutException {
		try {
			WebElement element = null;
			log.info("Waiting for the visibility of the element using By class:" + locator);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties.getProperty("elementSearchTimeOut")));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			log.info("WebElement Visible. Proceedign further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					"Time Out Exception while waiting for the visibility of the element using By class:" + locator
							+ "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	public WebElement waitForElementVisibility(WebDriver driver, WebElement beforeVisibilityElement)
			throws TimeoutException {
		try {
			WebElement afterVisibilityElement=null;
			log.info("Waiting for the visibility of the web element:" + beforeVisibilityElement);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties.getProperty("elementSearchTimeOut")));
			afterVisibilityElement = wait.until(ExpectedConditions.visibilityOf(beforeVisibilityElement));
			log.info("WebElement Visible. Proceedign further...");
			return afterVisibilityElement;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					"Time Out Exception while waiting for the visibility of the web element:" + beforeVisibilityElement
							+ "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public WebElement waitForElementClickability(WebDriver driver, By locator)
			throws TimeoutException {
		try {
			WebElement element = null;
			log.info("Waiting for the clickability of the element:" + locator);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties.getProperty("elementSearchTimeOut")));
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			log.info("WebElement Visible. Proceedign further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					"Time Out Exception while waiting for the clickability of the element:"
							+ locator + "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<WebElement> waitForElementsVisibility(WebDriver driver, By locator)
			throws TimeoutException {
		try {
			List<WebElement> element = null;
			log.info("Waiting for the visibility of the elements:" + locator);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties.getProperty("elementSearchTimeOut")));
			element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			log.info("WebElements Visible. Proceedign further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					"Time Out Exception while waiting for the visibility of the elements:" + locator
							+ "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	public List<WebElement> waitForElementsPresence(WebDriver driver, By locator)
			throws TimeoutException {
		try {
			List<WebElement> element = null;
			log.info("Waiting for the presence of the elements:" + locator);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties.getProperty("elementSearchTimeOut")));
			element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			log.info("WebElements Present. Proceedign further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					"Time Out Exception while waiting for the presence of the elements:" + locator
							+ "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	public void waitForTimePeriod(int timeOut) {
		try {
			log.info("Thread.sleep activated for " + timeOut / 1000 + " seconds");
			Thread.sleep(timeOut);
			log.info("Ended after waiting for " + timeOut / 1000 + " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

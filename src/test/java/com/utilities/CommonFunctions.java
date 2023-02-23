package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.objectrepository.Locators;

public class CommonFunctions {

	public static WebDriver driver;
	public FileInputStream fi;
	public String propertyFile = "QAtestdata.properties";

	
	public Locators l = new Locators();
	public Properties p = new Properties();
	

	/********************** Browser launch ******************************/
	public void chromeBrowserLaunch() {
		driver = new ChromeDriver();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("windows maximized and deleted cookies");
	}
	
	public void getURL(String URL) throws IOException {
		fi = new FileInputStream(".\\src\\test\\resources\\testdata\\" + propertyFile);
		p.load(fi);
		driver.get(p.getProperty(URL));
	}

	
	
	/*******
	 * SendKeys
	 * 
	 * @throws Exception
	 ************************/
	public void sendKeysByAnyLocator(By locator, String inputdata) throws Exception {
		fi = new FileInputStream(".\\src\\test\\resources\\testdata\\" + propertyFile);
		p.load(fi);

		WebElement element = driver.findElement(locator);

		try {
			// Check your locator is displayed on current page?
			if (driver.findElements(locator).size() > 0) {
				// Check your element is in enable state?
				if (element.isEnabled()) {
					System.out.println("Given locator is enable state ***");
					// Clear any existing data
					highlightElement(element);
					element.clear();
					// Send the test data to Edit box
					highlightElement(element);
					element.sendKeys(p.getProperty(inputdata));
				} else {
					System.out.println("Given locator is not enable state on DOM(Current page***");
				}
			} else {
				System.out.println("Given locator is not displayed on DOM(Current page***");
			}
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	/*******
	 * Click
	 * 
	 * @throws Exception
	 ************************/
	public void clickByAnyLocator(By locator) throws Exception {
		implicitWait(10);
		WebElement element = driver.findElement(locator);
		// Check your locator is displayed?
		if (driver.findElements(locator).size() > 0) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				// Click on Button/radiobutton/checkbox/Link...
				highlightElement(element);
				element.click();
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}
	
	public void highlightElement(WebElement element) throws InterruptedException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			for (int i = 0; i < 1; i++) {
				executor.executeScript("arguments[0].style.border='7px groove green'", element);
				Thread.sleep(200);
				executor.executeScript("arguments[0].style.border='7px groove green'", element);
			}
		} catch (Exception e) {
			System.out.println("Exception - " + e.getMessage());
		}
	}
	
	/************ waits in selenium ***********************/
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		System.out.println("Implicit wait method used***");
	}

	public void explicitWaitVisibilityOf(By locator, int timeinSeconds) {
		WebElement element = driver.findElement(locator);
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(timeinSeconds));
		ww.until(ExpectedConditions.visibilityOf(element));
	}

	public void explicitWaitElementToBeClickable(By locator, int timeinSeconds) {
		WebElement element = driver.findElement(locator);
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(timeinSeconds));
		ww.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void explicitWaiTeltextToBePresentInElement(By locator, String expectedText, int timeinSeconds) {
		WebElement element = driver.findElement(locator);
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(timeinSeconds));
		ww.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
	}

	/***
	 * instead of fluent wait use customized While loop statement**@throws Exception
	 *****/
	public void waitforElement(By locater) throws Exception {
		int i = 0;
		while (driver.findElements(locater).size() < 1) {
			Thread.sleep(500);
			System.out.println("Wait for the element***************");			
			if (i > 30) {
				System.out.println("Element is not present");
				break;
			}
			i++;
		}
	}
	
	
}

package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class WaitsInSelenium extends CommonFunctions {

	@Parameters("browserName")
	@BeforeClass
	public void crossBrowser(@Optional("Chrome") String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			chromeBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("edge")) {
			edgeBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			firefoxBrowserLaunch();
		} else {
			System.out.println("******Please check the browerName******");
		}
	}

	//@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@AfterMethod//This method will repeat for each @Test block
	public void afterMethod(ITestResult res) throws Exception {
		screenshotWithStatus(res);
	}

	@Test
	public void f()throws Exception  {
		driver.get("file:///C:/Users/nalla/OneDrive/Desktop/Selenium/Exam_14Oct2022/QE%20-%20index.html");
		//Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		WebDriverWait ww = new WebDriverWait(driver,Duration.ofSeconds(25));
		ww.until(ExpectedConditions.elementToBeClickable(By.id("test5-button")));
		
		
		
		driver.findElement(By.id("test5-button")).click();
		//clickByAnyLocator(By.id("test5-button"));
	}
}

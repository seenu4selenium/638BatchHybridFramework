package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class TTD_DropdownValues extends CommonFunctions {

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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@AfterMethod//This method will repeat for each @Test block
	public void afterMethod(ITestResult res) throws Exception {
		screenshotWithStatus(res);
	}

	@Test
	public void f() throws Exception {
		driver.get("https://tirupatibalaji.ap.gov.in/#/registration");
		Thread.sleep(6000);
		//Get all the Country dropdown option values from the page
		printAllDropdownValues(By.name("countryS"));
		
		
	}
}

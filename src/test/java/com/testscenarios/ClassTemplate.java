package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class ClassTemplate extends CommonFunctions {

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

	@AfterMethod
	public void afterMethod(ITestResult res) throws Exception {
		screenshotWithStatus(res);
	}

	@Test
	public void f() {
		// Develop the code from here
	}
}

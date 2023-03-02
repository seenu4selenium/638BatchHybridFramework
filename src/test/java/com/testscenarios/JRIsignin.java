package com.testscenarios;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

public class JRIsignin extends CommonFunctions {
	@BeforeClass
	public void openBrowser() {
		chromeBrowserLaunch();
	}

	@Test
	public void f() throws Exception {

		getURL("JRI_URL");
		clickByAnyLocator(l.JRIhomepage_SigninLink);
		sendKeysByAnyLocator(l.JRILoginPage_EmailEditbox, "Email");
		sendKeysByAnyLocator(l.JRILoginPage_PasswordEditbox, "Password");
		sendCaptchaToEditBox(l.JRILoginPage_CaptchaEditbox);
		clickByAnyLocator(l.JRILoginPage_SigninButton);
		Thread.sleep(5000);
		clickByAnyLocator(l.JRILoginPage_SignoutLink);

	}

	@AfterMethod
	public void takeScreenshotForEachTestCase(ITestResult res) throws Exception {
		screenshotWithStatus(res);
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	
}

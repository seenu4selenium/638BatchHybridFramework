package com.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Here QA will store all application locators
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	// public final By PageName_ElementName = By.id("Dsagdsg");

	public final By fbLogin_UserNameEditbox = By.id("email");
	public final By fbLogin_PasswordEditbox = By.name("pass");
	public final By fbLogin_LoginButton = By.name("login");

	// JRI locators
	public final By JRIhomepage_SigninLink = By.id("jriTop_signin9");
	public final By JRILoginPage_EmailEditbox = By.id("txtUserName");
	public final By JRILoginPage_PasswordEditbox = By.id("txtPasswd");
	public final By JRILoginPage_CaptchaEditbox = By.id("txtCaptcha");
	public final By JRILoginPage_SigninButton = By.id("imgbtnSignin");
	public final By JRILoginPage_SignoutLink = By.id("jriTop_signOut");

	

//	public final WebElement JRIhomepage_SigninLink = driver.findElement(By.id("jriTop_signin9"));
//	public final WebElement JRILoginPage_EmailEditbox = driver.findElement(By.id("txtUserName"));
//	public final WebElement JRILoginPage_PasswordEditbox = driver.findElement(By.id("txtPasswd"));
//	public final WebElement JRILoginPage_CaptchaEditbox = driver.findElement(By.id("txtCaptcha"));
//	public final WebElement JRILoginPage_SigninButton = driver.findElement(By.id("imgbtnSignin"));

}

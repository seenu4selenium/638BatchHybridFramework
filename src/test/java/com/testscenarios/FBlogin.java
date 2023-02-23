package com.testscenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

public class FBlogin extends CommonFunctions {
	
  @Test
  public void f() throws Exception {
	  chromeBrowserLaunch();
	  getURL("FB_URL");
	  sendKeysByAnyLocator(l.fbLogin_UserNameEditbox, "UserName");
	  sendKeysByAnyLocator(l.fbLogin_PasswordEditbox, "Password");
	  clickByAnyLocator(l.fbLogin_LoginButton); 
	  
  }
}

package com.facebook.loginTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.base.BaseTest;
import com.facebook.loginPages.LoginPage;
import com.facebook.utilities.PropertiesReader;

public class LoginTest extends BaseTest{
		
		LoginPage loginPage; //making global instance variable
		PropertiesReader propertiesReader; 
		
		@BeforeMethod
		
		public void openFacebook() {
			openApp();
		
		}
		
		@Test
		public void loginTest() {
			loginPage = new LoginPage(driver);
			propertiesReader= new PropertiesReader();
			
			loginPage.userNameMethod(propertiesReader.getUserName());
			loginPage.passWordMethod(propertiesReader.getPassword());
			loginPage.loginButton();
		}
		
		@AfterMethod
		public void closeFacebook() {
			closeApp();
			
		}
	}

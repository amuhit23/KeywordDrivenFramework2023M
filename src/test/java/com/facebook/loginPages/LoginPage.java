package com.facebook.loginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.facebook.utilities.PropertiesReader;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.ID, using = "email") WebElement userNameId;

	public WebElement userNameMethod(String enterYourUsename) {
		
		userNameId.sendKeys(enterYourUsename); 
		return userNameId;

	}

	@FindBy(how = How.NAME, using = "pass")
	WebElement passwordLocator;

	public WebElement passWordMethod(String enterYourPassword) {
		passwordLocator.sendKeys("enterYourPassword");
		return passwordLocator;

	}

	@FindBy(how=How.XPATH, using="//button[@name='login']") private WebElement loginButtonLocators;
	
	public void loginButton() {
		loginButtonLocators.click();
	}

	public void userNameMethod(PropertiesReader propertiesReader) {
		// TODO Auto-generated method stub
		
	}
}

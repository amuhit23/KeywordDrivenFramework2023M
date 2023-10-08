package com.facebook.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.facebook.utilities.PropertiesReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver; 
	
//*** Creating a has a relationship 
	PropertiesReader reader; //(import it)
	
	//@BeforeMethod
	public void openApp() { 
		
		reader=new PropertiesReader();
		String browser=reader.readBrowser();
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();                    
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("Safari")) {     //***This if else if, else condition is called Nested method**
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			
		} else if (browser.equalsIgnoreCase("Edge")) {      // *** Cross Browser capability ***
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			                               // ** if else condition is called Conditional Statement or Flow of Statement in java**
		} else {
			// in else condition: if the browser name is wrong; if nothing match just run from chrome
			System.out.println("Bad browser name: this is defaut browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get(reader.getQaUrl());
	}

	//@AfterMethod
	public void closeApp() {
		if (driver != null) { // [driver !=null] means Driver is there, or driver is something
			driver.quit();
		}
	}

}

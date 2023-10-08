package com.facebook.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	Properties prop;

	public PropertiesReader() { 

		prop = new Properties(); 
		String propertyFile = "src/test/resources/test.properties";

		try {
			FileInputStream fis = new FileInputStream(propertyFile); 
			prop.load(fis); 
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public String readBrowser() { 
		return prop.getProperty("browser");

	}

	public String getQaUrl() {
		return prop.getProperty("qaUrl");

	}

	public String getUserName() {
		return prop.getProperty("userName");

	}

	public String getPassword() {
		return prop.getProperty("password");

	}

	public static void main(String[] args) { // just to test if it's working 
		PropertiesReader pr = new PropertiesReader();
		String browserName = pr.readBrowser();

		System.out.println(browserName);

	}



}

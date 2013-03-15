package com.example.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestSetup {
	protected WebDriver driver;
	


	public TestSetup() {
		System.setProperty("webdriver.firefox.bin", 
	            "/Applications/Firefox.app/Contents/MacOS/firefox-bin"); 
		this.driver = new FirefoxDriver();
		
	}

	public WebDriver getDriver() {
		return this.driver;
	}

}

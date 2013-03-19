package com.example.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestSetup {
	protected WebDriver driver;
	


	public TestSetup() {
		//System.setProperty("webdriver.firefox.bin", 
	            //"/Applications/Firefox.app/Contents/MacOS/firefox-bin"); 
		System.setProperty("webdriver.chrome.driver","/Users/ivyshushu/boku/Boku_Sample/bin/chromedriver 2");        
		this.driver = new ChromeDriver();
		
	}

	public WebDriver getDriver() {
		return this.driver;
	}

}

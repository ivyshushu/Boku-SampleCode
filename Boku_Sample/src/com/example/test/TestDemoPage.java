package com.example.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.page.*; 

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestDemoPage {
	
	TestSetup setup = new TestSetup();
	String[] expectedMenuOptions = {"  ", " AT&T ", " T-Mobile ", " Verizon Wireless ", " Sprint ", " Virgin ", " Boost Mobile "};
    
    
	@After
	public void tearDown() throws Exception {
		this.setup.getDriver().quit();
	}
	
	@Test
	public void testIfDropdownMenuExists(){
		DemoPage demo = new DemoPage(setup.driver);
		assertEquals(true, demo.isDropdownMenuPresent());
	}
	
	@Test
	public void testClickDropdownMenu(){
		DemoPage demo = new DemoPage(setup.driver);
		demo.clickDropdownMenu();
		assertEquals(true, demo.isMenuDisplayed());
	}
	
	@Test
	public void verifyMenuItems(){
		DemoPage demo = new DemoPage(setup.driver);
		List<WebElement> options = demo.getOptions();
		for(WebElement opt : options){
			String value = opt.getText();
			assertEquals(true, Arrays.asList(expectedMenuOptions).contains(value));	
			}

		//assertEquals(true, Arrays.asList(expectedMenuOptions).contains(options.get(0).getText()));
		}
		
	@Test
	public void testSelectMenuItem(){
		DemoPage demo = new DemoPage(setup.driver);
		demo.selectItem(" AT&T ");
		assertEquals(" AT&T ", demo.getCurrentSelection());
		demo.selectItem(" T-Mobile ");
		assertEquals(" T-Mobile ", demo.getCurrentSelection());
		demo.selectItem(" Boost Mobile ");
		assertEquals(" Boost Mobile ", demo.getCurrentSelection());
		demo.selectItem(" Sprint ");
		assertEquals(" Sprint ", demo.getCurrentSelection());
	}
	
	@Test
	public void testNoItemSelected(){
		DemoPage demo = new DemoPage(setup.driver);
		demo.clickDropdownMenu();
        demo.click();
		if(!demo.isErrorMessageDisplayed()){
	    	demo.clickDropdownMenu();
	    	demo.click();
	    	demo.getWait().until(demo.presenceOfElementLocated(By.cssSelector(".form-error-message")));
	    }
		assertEquals(true, demo.isErrorBackgroundColorDisplayed());
		assertEquals(true, demo.isErrorMessageDisplayed());
	}
	
	@Test
	public void testDescription1Displayed(){
		DemoPage demo = new DemoPage(setup.driver);
		assertEquals(true, demo.isDescription1Present());
	}
	
	@Test
	public void testDescription2Displayed(){
		DemoPage demo = new DemoPage(setup.driver);
		assertEquals(true, demo.isDescription2Present());
	}
	
	@Test
	public void testEmptyPhoneNumInput(){
		DemoPage demo = new DemoPage(setup.driver);
		demo.enterPhoneNum(" ");
		if(!demo.isErrorMessageDisplayed()){
	    	demo.enterPhoneNum(" ");
	    	demo.getWait().until(demo.presenceOfElementLocated(By.cssSelector(".form-error-message")));
	    }
		assertEquals(true, demo.isErrorBackgroundColorDisplayed());
		assertEquals(true, demo.isErrorMessageDisplayed());
	}
	
	@Test
	public void testPhoneNumValidation(){
		DemoPage demo = new DemoPage(setup.driver);
		demo.enterPhoneNum("9899990^");
		 if(!demo.isErrorMessageDisplayed()){
		    	demo.enterPhoneNum("9899990^");
		    	demo.getWait().until(demo.presenceOfElementLocated(By.cssSelector(".form-error-message")));
		    }
		assertEquals(true, demo.isErrorMessageDisplayed());
	}
	
	@Test
	public void testCheckBoxUnchecked(){
		DemoPage demo = new DemoPage(setup.driver);
		demo.clickCheckbox();
		demo.clickCheckbox();
		demo.click();
		if(!demo.isErrorMessageDisplayed()){
	    	demo.clickCheckbox();
	    	demo.clickCheckbox();
			demo.click();
	    	demo.getWait().until(demo.presenceOfElementLocated(By.cssSelector(".form-error-message")));
	    }
		assertEquals(true, demo.isErrorBackgroundColorDisplayed());
		assertEquals(true, demo.isErrorMessageDisplayed());
	}
	
	@Test
	public void testZipCodeFieldDisplayed(){
		DemoPage demo = new DemoPage(setup.driver);
        demo.selectItem("Verizon Wireless");
        demo.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertEquals(true, demo.isZipCodeTextFieldDisplayed());
	}
	
	@Test
	public void testFormSubmitWithValidData(){
		DemoPage demo = new DemoPage(setup.driver);
		demo.selectItem(" Verizon Wireless ");
		demo.enterPhoneNum("123456");
		demo.enterZipCode(" ");
		demo.clickCheckbox();
		demo.submitForm();
		demo.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals(true, demo.isThankYonImageDisplayed());
	}
	
	@Test
	public void testFormSubmitWithoutRequiredData(){
		DemoPage demo = new DemoPage(setup.driver);
		demo.enterPhoneNum(" ");
		demo.clickCheckbox();
		demo.clickCheckbox();
		demo.submitForm();
		assertEquals(true, demo.isSubmitErrorMessageDisplayed());
	}
}



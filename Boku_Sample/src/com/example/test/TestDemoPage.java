package com.example.test;

import java.util.Arrays;
import java.util.List;

import com.example.page.*; 
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class TestDemoPage {
	
	TestSetup setup = new TestSetup();
	String[] expectedMenuOptions = {"", "AT&T", "T-Mobile", "Verizon Wireless", "Sprint", "Virgin", "Boost Mobile"};
    String requiredFieldErrorMessage = "This field is required.";
    String submitErrorMessage = "There are incomplete required fields. Please complete them.";
    String dropdownMenuDescription = "Select the company that provides your cell phone service.";
    String textFieldDescription = "Enter your cell phone number.";
    String numValidationErrorMessage = "This field can only contain numeric values";
    
	@After
	public void tearDown() throws Exception {
		this.setup.getDriver().quit();
	}
	
	@Test
	public void testIfDropdownMenuExists(){
		DemoPage demo = new DemoPage(setup.getDriver());
		assertEquals(true, demo.isDropdownMenuPresent());
	}
	
	@Test
	public void testClickDropdownMenu(){
		DemoPage demo = new DemoPage(setup.getDriver());
		demo.clickDropdownMenu();
		assertEquals(true, demo.isMenuDisplayed());
	}
	
	@Test
	public void verifyMenuItems(){
		DemoPage demo = new DemoPage(setup.getDriver());
		List<WebElement> options = demo.getOptions();
		for(WebElement opt : options){
			String value = opt.getText();
			assertEquals(true, Arrays.asList(expectedMenuOptions).contains(value));	
			}

		//assertEquals(true, Arrays.asList(expectedMenuOptions).contains(options.get(0).getText()));
		}
		
	@Test
	public void testSelectMenuItem(){
		DemoPage demo = new DemoPage(setup.getDriver());
		demo.selectItem("Verizon Wireless");
		assertEquals("Verizon Wireless", demo.getCurrentSelection());
	}
	
}



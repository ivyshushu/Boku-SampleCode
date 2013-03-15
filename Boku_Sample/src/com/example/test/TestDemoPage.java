package com.example.test;
import com.example.page.*; 
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestDemoPage {
	
	TestSetup setup = new TestSetup();

	@After
	public void tearDown() throws Exception {
		this.setup.getDriver().quit();
	}
    
	@Test
	public void test() {
		DemoPage demo = new DemoPage(setup.getDriver());
		demo.getToPage();
		
	}

}

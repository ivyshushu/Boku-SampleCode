package com.example.test;

public class TestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSetup setup = new TestSetup();
		try {
			setup.getDriver().get("http://google.com");
		} finally {
			setup.getDriver().close();
		}

	}

}

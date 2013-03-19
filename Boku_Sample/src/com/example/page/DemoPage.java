package com.example.page;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class DemoPage extends Page {
	private String url = "http://bokutester.tumblr.com/post/44018078567/demo";
	private By dropdownList = By.id("input_3");
	private By textField = By.id("input_5");
	private By menuItems = By.cssSelector("select > option");
	private By errorMessage = By.cssSelector(".form-error-message");
	private By formDescription = By.cssSelector(".form-description");
	private By checkBox = By.id("id_8");
	private By zipCodeTextField = By.id("input_9");
	private By submitButton = By.id("input_2");
	private By submitErrorMessage = By.cssSelector(".form-button-error");
	private By thankYonImage = By.tagName("img");
	
	public DemoPage(WebDriver d){
		super(d);
		this.getToPage();
	}

    public void getToPage() {
    	    this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	    this.driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
			this.driver.get(url);
			this.driver.switchTo().frame("30705147322142");
	}
    
    public void mouseHover(By by){
    	WebElement elm = this.driver.findElement(by);
    	new Actions(driver).moveToElement(elm).build().perform();
    }


	public boolean isDropdownMenuPresent(){
		return this.isElementPresent(dropdownList);
	}
	
	public void clickDropdownMenu(){
		this.driver.findElement(dropdownList).click();
	}
	
	public boolean isMenuDisplayed(){
		return this.isElementVisible(menuItems);
	}
	
	public List<WebElement> getOptions(){
		Select itemList = new Select(this.driver.findElement(dropdownList));
		return itemList.getOptions();
	}
	
	public void selectItem(String company){
		List<WebElement> optionList = getOptions();
		for(WebElement option : optionList){
			if(option.getText().equals(company)){
				option.click();
				break;
			}
		}
	}
	
	public String getCurrentSelection(){
		Select itemList = new Select(this.driver.findElement(dropdownList));
		return itemList.getFirstSelectedOption().getText();
	}
	
	public boolean isErrorMessageDisplayed(){
		return this.isElementVisible(errorMessage);
	}
	
	public boolean isErrorBackgroundColorDisplayed(){
		return this.isElementVisible(By.cssSelector(".form-line-error"));
	}
	
	public boolean isDescription1Present(){
		this.mouseHover(By.id("label_3"));
		this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    return this.isElementVisible(By.cssSelector(".form-description"));
	}
	
	public boolean isDescription2Present(){
		this.mouseHover(By.id("label_5"));
		this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    return this.isElementVisible(By.cssSelector(".form-description"));
	}
	
	public String getDescription1(){
		return this.driver.findElement(formDescription).getText();
	}
	
	public void enterPhoneNum(String num){
		this.driver.findElement(textField).clear();
		this.driver.findElement(textField).click();
		this.driver.findElement(textField).sendKeys(num);
		click();
	   
	}
	
	public void click(){
		this.driver.findElement(By.id("label_11")).click();
	}
	
	public boolean isZipCodeTextFieldDisplayed(){
		return this.isElementPresent(zipCodeTextField);
	}
	
	public void enterZipCode(String code){
		this.driver.findElement(zipCodeTextField).clear();
		this.driver.findElement(zipCodeTextField).sendKeys(code);
		this.driver.findElement(By.id("label_3")).click();
	}
	
	public void clickCheckbox(){
		this.driver.findElement(checkBox).click();
	}
	
	public void submitForm(){
		this.driver.findElement(submitButton).click();
	}
	
	public boolean isSubmitErrorMessageDisplayed(){
		return this.isElementPresent(submitErrorMessage);
	}
	
	public boolean isThankYonImageDisplayed(){
		return this.isElementVisible(thankYonImage);
	}
	
	
	
	
	

}

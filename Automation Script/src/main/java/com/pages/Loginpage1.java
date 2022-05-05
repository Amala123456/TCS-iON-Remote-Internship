package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage1 {
	WebDriver driver;
	
	@FindBy(css="input[name='email']")
	private WebElement emails;
	@FindBy(css="input[placeholder='Password']")
	private WebElement pass;

	@FindBy(xpath="//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/a/small")
	private WebElement loginpage;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/button")
	private WebElement login;
	
	
	
	public Loginpage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void invaliddetails(String email,String password) throws InterruptedException {
		loginpage.click();
		

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		Thread.sleep(4000);
		emails.sendKeys(email);
		pass.sendKeys(password);
		login.click();
		
	}
	
	
	
	
	
	
	
	
	public void logindetails(String email,String password) throws InterruptedException {
		
		

		// Perform the click operation that opens new window

		
		Thread.sleep(4000);
		emails.sendKeys(email);
		pass.sendKeys(password);
		login.click();
		
	}
}

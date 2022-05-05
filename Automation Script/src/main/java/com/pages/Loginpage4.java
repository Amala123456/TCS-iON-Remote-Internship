package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage4 {
	WebDriver driver;
	
	@FindBy(css="input[name='email']")
	private WebElement emails;
	@FindBy(xpath="//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[2]/label/input")
	private WebElement pass;

	@FindBy(xpath="//*[@id=\"Main\"]/section[1]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/a/small")
	private WebElement loginpage;
	
	@FindBy(xpath="//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[4]/button")
	private WebElement login;
	
	public Loginpage4(WebDriver driver) {
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
		emails.clear();
		pass.clear();
	}
	
	public void logindetails(String email,String password) throws InterruptedException {
		
		
		Thread.sleep(4000);
		emails.sendKeys(email);
		pass.sendKeys(password);
		login.click();
		
	}
}

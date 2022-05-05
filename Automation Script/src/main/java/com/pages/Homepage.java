package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	WebDriver driver;
	@FindBy(xpath="/html/body/div[1]/div/div[3]/ul/li[2]/a")
	private WebElement mybook;
	@FindBy(xpath="/html/body/div[1]/div/div[3]/ul/li[3]/a")
	private WebElement funds;
	@FindBy(xpath="//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div/div[2]/div/div/input")
	private WebElement num;
	@FindBy(id="gateway_paypal")
	private WebElement paypal;
	@FindBy(xpath="//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div/div[2]/div/button")
	private WebElement pay;
	@FindBy(xpath="/html/body/div/div[2]/div[2]")
	private WebElement back;
	
	@FindBy(xpath="/html/body/div/div[2]/div[1]/a")
	private WebElement msg;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/ul/li[4]/a")
	private WebElement profile;
	@FindBy(xpath="/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/div/table/tbody/tr/td[4]/div/a")
	private WebElement voucher;
	
	@FindBy(xpath="//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div[1]/table/tbody/tr[11]/td[3]/div/input")
	private WebElement address1;
	
	@FindBy(xpath="//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div[1]/table/tbody/tr[12]/td[3]/div/input")
	private WebElement address2;
	
	@FindBy(css="button.theme-btn.waves-effect")
	private WebElement update;
	@FindBy(id="cookie_stop")
	private WebElement cookie;
	@FindBy(xpath="/html/body/div[1]/div/div[3]/ul/li[5]/a")
	private WebElement logout;
	
	
	
	
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyhome() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(cookie)).click();
	    
		mybook.click();
		funds.click();
		profile.click();
		
		
		
		
	}
	
	
public void verifypay() throws InterruptedException {
		
		
		funds.click();
		num.clear();
		num.sendKeys("50");
		paypal.click();
		pay.click();
		Thread.sleep(3000);
		back.click();
		Thread.sleep(3000);
		msg.click();
		Thread.sleep(3000);
		
		
		
		
	}
	
public void verifybookings() throws InterruptedException {
	
	String winHandleBefore = driver.getWindowHandle();
		
		mybook.click();
		voucher.click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		Thread.sleep(4000);
		driver.close();
		
		driver.switchTo().window(winHandleBefore);

			
	}

public void verifyprofile() throws InterruptedException {

	
	profile.click();
	//Scrolldown
	address1.clear();
	address2.clear();
	address1.sendKeys("Thomas Villa");
	address2.sendKeys("New Jersey");
	

	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click()", update);
    

		
}
	public void verifylogout() throws InterruptedException{
		
		Thread.sleep(2000);
		logout.click();
		
	}
	
	

}

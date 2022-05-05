package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.constants.Constants;

public class Tabs {

	
WebDriver driver;
	
	@FindBy(linkText="Home")
	private WebElement home;
	@FindBy(linkText="Hotels")
	private WebElement hotel;
	@FindBy(xpath="//*[@id=\"fadein\"]/header/div[2]/div/div/div/div/div[2]/nav/ul/li[3]/a")
	private WebElement flight;
	@FindBy(linkText="Tours")
	private WebElement tour;
	@FindBy(xpath="//*[@id=\"fadein\"]/header/div[2]/div/div/div/div/div[2]/nav/ul/li[5]/a")
	private WebElement visa;
	@FindBy(linkText="Blog")
	private WebElement blogs;
	@FindBy(linkText="Offers")
	private WebElement offers;
	@FindBy(linkText="Company")
	private WebElement company;
	@FindBy(id="currency")
	private WebElement currency;
	@FindBy(xpath="/html/body/header/div[1]/div/div/div[2]/div/div/div[2]/div/ul/li[7]/a")
	private WebElement inr;
	@FindBy(id="select2-hotels_city-container")
	private WebElement search;
	@FindBy(xpath="/html/body/section[1]/section/div/div/form/div/div/div[4]/div/button/span[1]")
	private WebElement click;
	@FindBy(xpath="//*[@id=\"select2-hotels_city-results\"]/li[2]")
	private WebElement optionlist;
	
	
	//
	@FindBy(xpath="//*[@id=\"layoutDrawer_content\"]/main/div/div[1]/div[2]/a/div/div/div/div[1]/div[2]")
	private WebElement pendbook;
	
	
	@FindBy(id="booking_status")
	private WebElement pend;
	

	@FindBy(className="form-select status confirmed")
	private WebElement confirm;
	
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[11]/select/option[1]")
	private WebElement paid;
	
	
	
	
	
	@FindBy(linkText=" Logout")
	private WebElement out;
	
	@FindBy(css="a[href=\"https://www.phptravels.net/api/../flights/booking/invoice/8106/1\"]")
	private WebElement invoice;
	
	@FindBy(linkText="Bookings")
	private WebElement book;
	
	
	
	@FindBy(xpath="/html/body/nav/div/div/ul/li[1]/a")
	private WebElement website;	
	
	
	@FindBy(xpath ="/html/body/div[2]/div[2]/main/div/div[2]/div/div/div[2]/div/table")

    private WebElement table;
	
	@FindBy(xpath="//*[@id=\"data\"]/tbody/tr/td[15]/button")
	private WebElement close;
	
	//
	
	
	
	@FindBy(xpath="//*[@id=\"drawerAccordion\"]/div[1]/div/a[3]")
	private WebElement dash;
	@FindBy(xpath="/html/body/div[2]/div[1]/nav/div/div/a[5]")
	private WebElement tour2;
	//@FindBy(xpath="//*[@id=\"drawerAccordion\"]/div[1]/div/a[7]")
	//private WebElement flight;
	@FindBy(xpath="//*[@id=\"drawerAccordion\"]/div[1]/div/a[6]")
	private WebElement books;
	
	
	
	//@FindBy(linkText="Pending Bookings")
	//private WebElement pending;
	
	
	
	@FindBy(xpath="/html/body/header/div[1]/div/div/div[2]/div/div/div[3]/div/button")
	private WebElement account;
	
	@FindBy(xpath="//*[@id=\"layoutDrawer_content\"]/main/div/div[1]/div[1]/div")
	private WebElement text1;
	@FindBy(xpath="//*[@id=\"layoutDrawer_content\"]/main/div/div[3]/div[1]/div/div[1]/div/div/h2")
	private WebElement text2;
	

	
	
	public Tabs(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void tabclicks() throws InterruptedException {
		
		home.click();
		hotel.click();
		flight.click();
		tour.click();
		Thread.sleep(2000);
		visa.click();
		blogs.click();
		offers.click();
		company.click();
		
	}
	
public void verifyhotel() throws InterruptedException{
		
		hotel.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(search));
		wait.until(ExpectedConditions.elementToBeClickable(search));
		Actions s=new Actions(driver);
		s.moveToElement(search);
		s.click();
		Thread.sleep(5000);
	    s.sendKeys("Santiago").build().perform();
	    s.moveToElement(optionlist).click().build().perform();
	   
	    Thread.sleep(5000);
	    
	    click.click();
	   
	    
	    
	   
		
		
}

public void verifyconversion() throws InterruptedException{

	currency.click();
	
	Actions a= new Actions(driver);
	a.moveToElement(currency);  
	a.moveToElement(inr).click().build().perform();
	
	
	
}


public void verifylogout2() throws InterruptedException{

	account.click();
	
	Actions a= new Actions(driver);
	a.moveToElement(account);  
	a.moveToElement(out).click().build().perform();
	
	
	
}

public void verifybook() throws InterruptedException{
	
	book.click();
	Thread.sleep(4000);
	invoice.click();
	String a=driver.getWindowHandle();
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	Thread.sleep(2000);
	driver.close();
	driver.switchTo().window(a);
	/*close.click();
	driver.switchTo().alert().accept();
	Thread.sleep(4000);*/
	
	
}



public void verifywebsite() throws InterruptedException{
	
	String a=driver.getWindowHandle();

	website.click();
	
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	Thread.sleep(2000);
	driver.close();
	driver.switchTo().window(a);
	
	
	
}

public void verifyconfirmstatus() throws InterruptedException{
	
	

	pend.click();
	Select s = new Select(pend);
	s.selectByIndex(1);
		
		
		
}

public void verifycancell() throws InterruptedException{
	
	Thread.sleep(4000);

	pend.click();
	Select s = new Select(pend);
	s.selectByIndex(2);
	
	
	
}

public void verifydelete() throws InterruptedException{
	
	Thread.sleep(4000);
	
	driver.get(Constants.url2);
	close.click();
	driver.switchTo().alert().accept();
	Thread.sleep(4000);
	
	
	
	
}



public void tabvisible() throws InterruptedException {
	
	
	Thread.sleep(4000);
	
	if(tour2.isDisplayed()) {
		
		tour2.click();
	}
	/*if(visa.isDisplayed()) {

		visa.click();
	}
	
	if(flight.isDisplayed()) {
		
		flight.click();
	}*/
	
	if(books.isDisplayed()) {
		
		books.click();
	}
	
	
	
	
}

public void verifytext() throws InterruptedException{
	

	dash.click();
	
	
	boolean b=text1.isDisplayed();
	Assert.assertEquals(b, true);
	
	boolean bb=text2.isDisplayed();
	Assert.assertEquals(bb, true);

		
		
	}
public void verifyconfirmstatus1() throws InterruptedException{
	
	
	pendbook.click();
	pend.click();
	Select s = new Select(pend);
	s.selectByIndex(1);
		
		
		
}
   


}

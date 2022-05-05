package com.Testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.constants.Constants;
import com.pages.Homepage;
import com.pages.Loginpage2;
import com.pages.Tabs;
import com.utility.ExcelUtility;

public class Tc2 extends TestBase{
	Loginpage2 objlogin;
	Homepage objhome;
	Tabs objtab;
	
	
	@Test(priority=1)
	public void logins() throws IOException, InterruptedException {
		objlogin=new Loginpage2(driver);
		String email=ExcelUtility.getCellData(2, 0);
		String password=ExcelUtility.getCellData(3, 0);
		objlogin.invaliddetails(email,password);
		String expectedMessage=Constants.Error1;
	    String actualMessage=" Wrong credentials. try again!";
		Assert.assertEquals(expectedMessage,actualMessage);
		
		String email1=ExcelUtility.getCellData(0, 0);
		String password1=ExcelUtility.getCellData(1, 0);
		objlogin.logindetails(email1,password1);
		String actual=driver.getCurrentUrl();
		String expected=Constants.url6;
		Assert.assertEquals(actual, expected);
		
	}
	@Test(priority=2)
	public void homes() throws IOException, InterruptedException {
		objhome=new Homepage(driver);
		objhome.verifyhome();
		String actual=driver.getCurrentUrl();
		String expected=Constants.url8;
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=3)
	public void tabs() throws IOException, InterruptedException {
		objtab=new Tabs(driver);
		objtab.tabclicks();
		objtab.verifyhotel();
		objtab.verifyconversion();
		String actual=driver.getCurrentUrl();
		String expected=Constants.url9;
		Assert.assertEquals(actual, expected);
		
		
	}
	
	
	}

	

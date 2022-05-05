package com.Testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.constants.Constants;
import com.pages.Loginpage4;
import com.pages.Tabs;
import com.utility.ExcelUtility;

public class Tc4 extends TestBase{
	Loginpage4 objlogin;
	
	Tabs objtab;
	
	
	@Test(priority=1)
	public void logins() throws IOException, InterruptedException {
		objlogin=new Loginpage4(driver);
		String email=ExcelUtility.getCellData(2, 0);
		String password=ExcelUtility.getCellData(3, 0);
		objlogin.invaliddetails(email,password);
		String expectedMessage=Constants.Error2;
	    String actualMessage="Invalid Login Credentials";
		Assert.assertEquals(expectedMessage,actualMessage);
		
		String email1=ExcelUtility.getCellData(0, 3);
		String password1=ExcelUtility.getCellData(1, 3);
		objlogin.logindetails(email1,password1);
		String actual=driver.getCurrentUrl();
		String expected=Constants.url4;
		Assert.assertEquals(actual, expected);
		
	}
	

	@Test(priority=2)
	public void tabs() throws IOException, InterruptedException {
		objtab=new Tabs(driver);
		objtab.verifytext();
		
		objtab.tabvisible();
		driver.navigate().back();
		
		Thread.sleep(4000);
		driver.get(Constants.url3);
		objtab.verifyconfirmstatus();
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(3000);
		String actual=driver.getCurrentUrl();
		String expected=Constants.url4;
	    Assert.assertEquals(actual, expected);
		
	}
	
	
	}

	

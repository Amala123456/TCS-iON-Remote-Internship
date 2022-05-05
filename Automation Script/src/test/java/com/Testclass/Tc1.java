package com.Testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.constants.Constants;
import com.pages.Homepage;
import com.pages.Loginpage1;
import com.utility.ExcelUtility;

public class Tc1 extends TestBase{
	Loginpage1 objlogin;
	Homepage objhome;

	
	
	@Test(priority=1)
	public void logins() throws IOException, InterruptedException {
		objlogin=new Loginpage1(driver);
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
		objhome.verifypay();
		
		objhome.verifybookings();
		objhome.verifyprofile();
		objhome.verifylogout();
		String actual=driver.getCurrentUrl();
		String expected=Constants.url5;
		Assert.assertEquals(actual, expected);
		
	}
	
		
	}

	

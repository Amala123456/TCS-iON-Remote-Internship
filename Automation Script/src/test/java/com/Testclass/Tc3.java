package com.Testclass;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.constants.Constants;
import com.pages.Homepage;
import com.pages.Loginpage3;
import com.pages.Tabs;
import com.utility.ExcelUtility;

public class Tc3 extends TestBase{
	Loginpage3 objlogin;
	Homepage objhome;
	Tabs objtab;
	
	
	@Test(priority=1)
	public void logins() throws IOException, InterruptedException {
		objlogin=new Loginpage3(driver);
		String email=ExcelUtility.getCellData(2, 0);
		String password=ExcelUtility.getCellData(3, 0);
		objlogin.invaliddetails(email,password);
		String expectedMessage=Constants.Error2;
	    String actualMessage="Invalid Login Credentials";
		Assert.assertEquals(expectedMessage,actualMessage);
		
		Thread.sleep(4000);
		
		String email1=ExcelUtility.getCellData(0, 2);
		String password1=ExcelUtility.getCellData(1, 2);
		objlogin.logindetails(email1,password1);
		String actual=driver.getCurrentUrl();
		String expected=Constants.url7;
		Assert.assertEquals(actual, expected);
		
	}
	/*@Test(priority=2)
	public void homes() throws IOException, InterruptedException {
		objhome=new Homepage(driver);
		objhome.verifyhome();
		driver.navigate().back();
		
	}*/

	@Test(priority=3)
	public void tabs() throws IOException, InterruptedException {
		objtab=new Tabs(driver);
		
		objtab.verifywebsite();
		objtab.verifybook();
		objtab.verifyconfirmstatus();
		objtab.verifycancell();
		objtab.verifydelete();
		String actual=driver.getCurrentUrl();
		String expected=Constants.url2;
		Assert.assertEquals(actual, expected);
	
		
	}
	
	
	}

	

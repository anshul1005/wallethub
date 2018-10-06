package com.demo.assignment.seleniumTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.assignment.selenium.SeleniumAssignment1;


public class TestClassAssignment1 {

	SeleniumAssignment1 obj1;
	String userName= ""; // Please initialise email here
	String password= ""; // Please initilase password here
	
	
	@BeforeClass
	public void initiateDemo3() {
		obj1 = new SeleniumAssignment1();
	}
	
	@DataProvider (name = "authentication")
	public Object[][] setCredentials() {
	   return new Object[][] {{ userName, password}};
	}

	@Test
	public void Test01_LaunchBrowser() {
		obj1.setBrowserAndLaunchFacebook();
	}
	
	@Test(dataProvider = "authentication")
	public void Test02_EnterCredentials(String username, String password) throws InterruptedException {
		obj1.loginUsingValidUsernameAndPassword(username, password);
	}
	
	@Test
	public void Test03_MakePost() throws InterruptedException {
		obj1.makePostOnFaceBook();
	}

	
}
package com.demo.assignment.seleniumTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.assignment.selenium.SeleniumAssignment2;

public class TestClassAssignment2 
{

	SeleniumAssignment2 obj2 ;
	String userName= "anshul.garg.188@gmail.com";
	String password= "Anshul@1994";
	String review = "The tree swallow is a migratory bird of the family Hirundinidae. Found in the Americas, it was first described in 1807 by French ornithologist Louis Vieillot as Hirundo bicolor. It has since been move testing";
	
	@BeforeClass
	public void initiateDemo3()
	{   
		obj2 = new SeleniumAssignment2();
	}
	
	@DataProvider (name = "authentication")
	public Object[][] setCredentials() {
	   return new Object[][] {{ userName, password}};
	}
	
	@Test
	public void Test01_LaunchBrowser()
	{   
		obj2.setBrowserAndWalletHub();
	}
	
	@Test
	public void Test02_SelectLogInButton()
	{   
		obj2.selectLogInButton();
	}
	
	@Test(dataProvider = "authentication")
	public void Test03_EnterCredentials(String username, String password) throws InterruptedException {
		obj2.loginUsingValidUsernameAndPassword(username, password);
	}
	
	@Test
	public void Test04_LaunchProfileTestInsuranceAndGiveRating()
	{   
		obj2.launchProfileTestInsurance();
		obj2.giveRatingStars();
		obj2.selectValueFromDropDown("Health");
	}
	
	@Test
	public void Test05_WriteReviewFor200Words() throws InterruptedException {
		obj2.enterReviewInTextArea(review);
		obj2.selectSubmitButton();
	}
	
	@Test
	public void Test06_ConfirmReviewScreen() {
		obj2.verifyReviewConfirmationScreen();
	}
	
	@Test
	public void Test07_ConfirmReviewEnteredOnReviewPage() {
		obj2.navigateToUserReviewsPage();
		obj2.verifyReviewTextOnUserPage(review);
	}
	
	
}
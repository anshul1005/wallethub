package com.demo.assignment.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumAssignment2 {

	WebDriver driver;

	public void setBrowserAndWalletHub() {
		String exePath = "src/main/resources/selenium-drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://wallethub.com/");
	}

	public void selectLogInButton() {
		driver.findElement(By.cssSelector(".login")).click();
	}

	public void loginUsingValidUsernameAndPassword(String username, String password) throws InterruptedException {
		Reporter.log("Enter email", true);
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(username);
		Reporter.log("Enter password", true);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		Reporter.log("Select Login button", true);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}

	public void launchProfileTestInsurance() {
		driver.get("https://wallethub.com/profile/test_insurance_company");
	}

	public void giveRatingStars() {
		WebElement element = driver.findElement(By.xpath("//span[@class='wh-rating rating_4_5']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		Actions action1 = new Actions(driver);
		for(int i = 1 ; i<=4;i++) {
			action1.moveToElement(driver.findElement(By.xpath("//div[@class='wh-rating-choices-holder']/a["+i+"]"))).build().perform();
		}
		driver.findElement(By.xpath("//div[@class='wh-rating-choices-holder']/a[5]")).click();
	}

	public void selectValueFromDropDown(String Value) {
		driver.findElement(By.xpath("//span[@class='val']")).click();
		driver.findElement(By.xpath("//a[text()='"+Value+"']")).click();
	}

	public void enterReviewInTextArea(String review) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("document.querySelector('#review-content').value='"+review+"'");
		Thread.sleep(5000);
		
	}
	
	public void selectSubmitButton() {
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('blue btn')[2].click();");
	}

	public void verifyReviewConfirmationScreen() {
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Awesome!']")).isDisplayed(), "[Assert Failed] : Review was not posted");
		Reporter.log("Review confirmation screen is dispalyed",true);
	}
	
	public void navigateToUserReviewsPage() {
		driver.get("https://wallethub.com/profile/anshul_garg_188/reviews/");
	}

	public void verifyReviewTextOnUserPage(String review) {
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+review+"')]")).isDisplayed(), "[Assert Failed] : Review is not posted");
		Reporter.log("Review entered on previous page is dispalyed",true);
	}
	
}

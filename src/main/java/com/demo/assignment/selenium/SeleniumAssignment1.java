package com.demo.assignment.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import junit.framework.Assert;

public class SeleniumAssignment1 {

	WebDriver driver;

	public void setBrowserAndLaunchFacebook() {
		String exePath = "src/main/resources/selenium-drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	public void loginUsingValidUsernameAndPassword(String username, String password) throws InterruptedException {
		verifyUserNameAndPassword();
		Reporter.log("Enter email",true);
		driver.findElement(By.cssSelector("#email")).sendKeys(username);
		Reporter.log("Enter password",true);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		Reporter.log("Select Login button",true);
		selectLogInButton();
	}

	public void selectLogInButton() {
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
	}

	public void verifyUserNameAndPassword() {
		Assert.assertTrue(driver.findElement(By.cssSelector("#email")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("#pass")).isDisplayed());
		Reporter.log("Email and password input text box are displayed",true);
	}

	public void makePostOnFaceBook() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("document.querySelector('textarea:nth-child(1)').value='Hello World'");
        driver.findElement(By.xpath("//span[text()='Make Post']")).click();
        driver.findElement(By.xpath("(//button[@type='submit']/span)[2]")).click();
		Reporter.log("Hello World post has been successfully shared",true);
	}

}

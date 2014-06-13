package com.mudstore.integratiotest;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginFeatureStrepDef {

	WebDriver driver = new ChromeDriver();
	private String username=null;
	static {System.setProperty("webdriver.chrome.driver", "/home/lt013962/Downloads/chromedriver");}
	
	@When("^I entered username (\\S+) and password (\\S+).")
	public void I_enter_username(String username, String password) throws InterruptedException{
		this.username=username;
		driver.get("http://localhost:8080/MudStore");
		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.sendKeys(username);
		Thread.sleep(1000);
		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.sendKeys(password);
		Thread.sleep(1000);
		passwordElement.submit();
		Thread.sleep(1000);
		
	}	
	@Then("^I should not allowed to login")
	public void failed_login(){
		WebElement erroeElement = driver.findElement(By.id("loginerror"));
		Assert.assertEquals("Invalid password", erroeElement.getText());
	}
	
	@Then("^I should be able to see home page")
	public void successfull_login(){
		Assert.assertEquals("Mudstore",driver.getTitle());
		WebElement welcomeMessage = driver.findElement(By.id("MudStoreWelcome"));
		Assert.assertEquals("Welcome "+this.username, welcomeMessage);
	}
}

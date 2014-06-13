package com.mudstore.automationtest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MudStroreTest {

    @Ignore
	@Test
	public void shouldLoginAndGetDeails() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/lt013962/Downloads/chromedriver");
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("http://localhost:8080/MudStore/");
		Assert.assertEquals("Mudstore Login", webDriver.getTitle());

		WebElement username = webDriver.findElement(By.id("username"));
		String userNameInput = "pratik";
		username.sendKeys(userNameInput);
		Thread.sleep(1000);
		WebElement password = webDriver.findElement(By.id("password"));
		password.sendKeys("adhau");
		Thread.sleep(1000);
		password.submit();
		Thread.sleep(1000);
		// Mudstore
		Assert.assertEquals("Mudstore", webDriver.getTitle());
		WebElement welcomeMessage = webDriver.findElement(By.id("MudStoreWelcome"));
		Assert.assertEquals("Welcome Pratik Adhau", welcomeMessage.getText());
		webDriver.quit();

	}
}

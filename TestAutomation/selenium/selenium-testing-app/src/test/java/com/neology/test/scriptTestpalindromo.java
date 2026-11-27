package com.neology.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test
public class scriptTestpalindromo {
	
	public void test() throws InterruptedException {
 
		// Driver
		WebDriver driver;
		
		// Inicialización de webdriver para Chrome
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Open browser
		driver.get("http://localhost:8080/palindromoApp/");
		
		// WebElements
		WebElement textWord = driver.findElement(By.name("textWord"));
		WebElement btnSend = driver.findElement(By.name("btnSend"));
		WebElement msg = driver.findElement(By.id("messageResponse"));
		
		Thread.sleep(3000);
		
		// Operacion
		textWord.sendKeys("Ana");
		btnSend.click();
		
		// Assertion
		Assert.assertTrue(msg.isDisplayed());
		
		// Close
		driver.close();
		
	}

}

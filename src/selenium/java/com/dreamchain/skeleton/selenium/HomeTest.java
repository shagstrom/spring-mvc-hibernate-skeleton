package com.dreamchain.skeleton.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomeTest {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void before() {
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	public static void after() {
		driver.close();
	}
	
	@Test
	public void addingOneUser() {
		driver.get("http://localhost:8080/spring-mvc-hibernate-skeleton/user");
		driver.findElement(By.name("name")).sendKeys("UserName");
		driver.findElement(By.name("email")).sendKeys("user@domain.com");
		driver.findElement(By.name("address")).sendKeys("31 Some Street\nSome Town");
		driver.findElement(By.id("userCommand")).findElement(By.xpath("//input[@type='submit']")).click();
	}

}

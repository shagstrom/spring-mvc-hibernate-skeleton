package com.dreamchain.skeleton.selenium;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
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
	
	@Before
	public void setup() throws SQLException {
		Database.clean();
	}
	
	@Test
	public void addingOneUser() {
		driver.get("http://localhost:8080/skeleton/user");
		addUser("user1");
		assertEquals(1, driver.findElements(By.xpath("//table//tbody//tr")).size());
	}

	@Test
	public void addingTwoUsers() {
		driver.get("http://localhost:8080/skeleton/user");
		addUser("user1");
		addUser("user2");
		assertEquals(2, driver.findElements(By.xpath("//table//tbody//tr")).size());
	}
	
	@Test
	public void updatingTwoUsers() {
		driver.get("http://localhost:8080/skeleton/user");
		addUser("user1");
		addUser("user2");
		driver.findElement(By.xpath("//tbody//tr[1]//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//tbody//tr[2]//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//tbody//tr[1]//input[contains(@name, '.name')]")).sendKeys("1");
		driver.findElement(By.xpath("//tbody//tr[2]//input[contains(@name, '.name')]")).sendKeys("2");
		driver.findElement(By.xpath("id('userGrid')//input[@type='submit']")).click();
		assertEquals("user11", driver.findElement(By.xpath("//tbody//tr[1]//input[contains(@name, '.name')]")).getAttribute("value"));
		assertEquals("user22", driver.findElement(By.xpath("//tbody//tr[2]//input[contains(@name, '.name')]")).getAttribute("value"));
	}
	
	private void addUser(String name) {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("email")).sendKeys(name + "@domain.com");
		driver.findElement(By.name("address")).sendKeys("31 Some Street\nSome Town");
		driver.findElement(By.id("userCommand")).findElement(By.xpath("//input[@type='submit']")).click();
	}

}

package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {
	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
		driver.manage().window().maximize();

	}

	@Test
	// alphabetical order
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		String welcomeText = driver.findElement(By.id("welcome")).getText();

		if (welcomeText.contains("Admin")) {
			System.out.println("Admin is logged in. Test Pass");
		} else {
			System.out.println("Admin is NOT logged in. Test Fail");

		}
	}

	@Test
	public void logoValidation() {
		boolean logo = driver.findElement(By.xpath("//div[@id='divLogo']")).isDisplayed();
		System.out.println("Logo is displayed ="+logo);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}

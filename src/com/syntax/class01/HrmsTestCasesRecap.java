package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HrmsTestCasesRecap {

	private static final int priority = 0;
	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
		driver.manage().window().maximize();

	}

	@Test(priority = 2)
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

	@Test(priority = 1)
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(actualTitle)) {
			System.out.println("Titles are matched.Test Pass");
		} else {
			System.out.println("Titles are matched.Test Failed");

		}
	}

	@Test(priority = 3, enabled=false)
	public void invalidLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		WebElement message = driver.findElement(By.id("spanMessage"));
		String expectedMsg = "Password cannot be empty";
		String actualMsg = message.getText();
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Test PASS");
		} else {
			System.out.println("Test FAIL");
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}

package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class task {
	
	public static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		// driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void Login() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}

	@Test
	public void labelsDisplayed() {
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		WebElement fullName = driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']"));
		WebElement employeeId = driver.findElement(By.xpath("//label[@for='employeeId']"));
		WebElement photograph = driver.findElement(By.xpath("//label[@for='photofile']"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(fullName.isDisplayed());
		softAssert.assertTrue(employeeId.isDisplayed());
		softAssert.assertTrue(photograph.isDisplayed());
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Ball");
		//driver.findElement(By.id("photofile")).sendKeys("C:\\Users\\User\\Desktop\\1.jpg");
		driver.findElement(By.id("btnSave")).click();
		WebElement picOfEmp = driver.findElement(By.id("empPic"));
		softAssert.assertTrue(picOfEmp.isDisplayed());
		softAssert.assertAll();
	}

}

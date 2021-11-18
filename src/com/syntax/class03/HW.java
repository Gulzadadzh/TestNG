package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW {
	
	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		// driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(dataProvider="getData")
	public void multipleLogin(String firstName, String lastName, String userName, String password, String screenshot) throws InterruptedException {
		driver.findElement(By.xpath("()//span[@class='form-hint']/preciding-sibling::input)[1]")).sendKeys("Admin");
		driver.findElement(By.xpath("()//span[@class='form-hint']/preciding-sibling::input)[2]")).sendKeys("Hum@nhrm123");		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		Thread.sleep(3000);
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		Assert.assertEquals(welcomeText, "Welcome Admin");
	}

}

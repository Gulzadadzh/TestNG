package com.syntax.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class differentAnnotations {
	
	
	@BeforeMethod
	public void before() {
		System.out.println("This is before test method");
	}
	
	@Test
	public void testMethod() {
		System.out.println("This is actual test method");
	}
	@Test
	public void testMethod2() {
		System.out.println("This is  test method 2");
	}

	@Test 
	public void testmethod3() {
		System.out.println("This is  test method 3");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("This is after test method");
		
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("-----This is before class annotation----");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("-----This is after class annotation----");
	}
	
}


package com.apex.core.test;

import org.testng.annotations.Test;

public class Accc {
	@Test
	public void login() {
		System.out.println("this is login page");
		
	}
	@Test(dependsOnMethods = "login")
	public void homePage() {
		System.out.println("This is a homePage");
		
		
	}

}

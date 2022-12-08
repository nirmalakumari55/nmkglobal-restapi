package com.nmkg.tesla;

public class Python {
	import BaseTest
	from selenium.webdriver.common.by import By
	import time

	# !!! Do not create your own WebDriver. !!!
	#
	# You can copy credentials from here:
	#  - login@codility.com    password
	#  - unknown@codility.com  password


	class LoginPageTest(BaseTest.BaseTest):
	    def testEmailAndPasswordElementsPresent(self):
	        # below you can find already setup webDriver as self.driver
	        emailInput = self.driver.find_element_by_id("email-input")
	        passwordHing = self.driver.find_element_by_id("password-input")
	        loginButton = self.driver.find_element_by_id("login-button")

	    def testGivenValidCredentialsShouldWork(self):
	        # below you can find already setup webDriver as self.driver
	        emailInput = self.driver.find_element_by_id("email-input")
	        passwordInput = self.driver.find_element_by_id("password-input")
	       

	        time.sleep(2)
	        emailInput.send_keys("login@codility.com")
	        passwordInput.send_keys("password")

	        time.sleep(2)
	        self.driver.find_element_by_id("login-button").click()

	        time.sleep(3)
	        #outputDiv = self.driver.find_element_by_class_name("message success")
	        #message = outputDiv.text
	        #assertEqual(message, "Welcome to Codility")
	        text = self.driver.find_element(By.TAG_NAME, "div").get_attribute("className")
	        self.assertEquals(text, "Welcome to Codility")
	    
	    def testGivenInValidCredentialsShouldNotWork(self):
	        # below you can find already setup webDriver as self.driver
	        emailInput = self.driver.find_element_by_id("email-input")
	        passwordHing = self.driver.find_element_by_id("password-input")
	        loginButton = self.driver.find_element_by_id("login-button")

	        emailInput.send_keys("unknown@codility.com")
	        passwordHing.send_keys("password")
	        time.sleep(3)
	        loginButton.click()

	        time.sleep(3)
	        text = self.driver.find_element(By.TAG_NAME, "div").get_attribute("className")
	        self.assertEquals(text, "You shall not pass! Arr!")
	    
	    def testVerifyEmailValidation(self):
	        # below you can find already setup webDriver as self.driver
	        emailInput = self.driver.find_element_by_id("email-input")
	        passwordHing = self.driver.find_element_by_id("password-input")
	        loginButton = self.driver.find_element_by_id("login-button")

	        emailInput.send_keys("testEmail")
	        passwordHing.send_keys("password")
	        time.sleep(3)
	        loginButton.click()

	        time.sleep(3)
	        text = self.driver.find_element(By.TAG_NAME, "div").get_attribute("className")
	        self.assertEquals(text, "Enter a valid email")
	        
	    def testVerifyEmptyEmail(self):
	        # below you can find already setup webDriver as self.driver
	        emailInput = self.driver.find_element_by_id("email-input")
	        passwordHing = self.driver.find_element_by_id("password-input")
	        loginButton = self.driver.find_element_by_id("login-button")

	        emailInput.send_keys("abc@test.com")
	        passwordHing.send_keys("")
	        time.sleep(3)

	        loginButton.click()
	        time.sleep(3)

	        text = self.driver.find_element(By.TAG_NAME, "div").get_attribute("className")
	        self.assertEquals(text, "Password is required")

	    def testVerifyEmptyEmail(self):
	        # below you can find already setup webDriver as self.driver
	        emailInput = self.driver.find_element_by_id("email-input")
	        passwordHing = self.driver.find_element_by_id("password-input")
	        loginButton = self.driver.find_element_by_id("login-button")

	        emailInput.send_keys("")
	        passwordHing.send_keys("xyz")
	        time.sleep(3)

	        loginButton.click()
	        time.sleep(3)

	        text = self.driver.find_element(By.TAG_NAME, "div").get_attribute("className")
	        self.assertEquals(text, "Email is required")

}

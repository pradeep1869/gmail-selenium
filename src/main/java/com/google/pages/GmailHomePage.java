package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GmailHomePage {
	
	private final WebDriver driver;
    private By signupLink = By.id("link-signup");

	   public GmailHomePage(WebDriver driver) {
	        this.driver = driver;
	   }

	   
	   public CreateAccountPage clickOnCreateAccountLink(){
		   driver.findElement(signupLink).click();
		   return new CreateAccountPage(driver);
	   }
}

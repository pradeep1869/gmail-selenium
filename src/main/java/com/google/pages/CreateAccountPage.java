package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
	private final WebDriver driver;
    private final String errorMessage = ".//*[@id='errormsg_0_GmailAddress']";

	public CreateAccountPage(WebDriver driver) {
	        this.driver = driver;
	   }

    public AccountForm newForm(){
        return new AccountForm(driver);
    }

    public String getValidationError(){
        WebElement errorElement = driver.findElement(By.xpath(errorMessage));
        return errorElement.getText();
    }

}

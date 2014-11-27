package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountForm {

    private final WebDriver driver;
    private final String firstName = ".//*[@id='FirstName']";
    private final String lastName = ".//*[@id='LastName']";
    private final String password = ".//*[@id='Passwd']";
    private final String passwordAgain = ".//*[@id='PasswdAgain']";
    private final String dobMonthDropDown = ".//*[@id='BirthMonth']/div";
    private final String birthMonth = ".//*[@id='BirthMonth']/div[2]/div[@id=':4']";
    private final String birthDay = "BirthDay";
    private final String birthYear = "BirthYear";
    private final String recoveryPhoneNumber = "RecoveryPhoneNumber";
    private final String recoveryEmail = "RecoveryEmailAddress";
    private final String terms = "TermsOfService";
    private final String submit = "submitbutton";

    public AccountForm(WebDriver driver) {
        this.driver = driver;
    }

    public AccountForm enterFirstName(String name){
        driver.findElement(By.xpath(firstName)).sendKeys(name);
        return this;
    }

    public AccountForm enterLastName(String name){
        driver.findElement(By.xpath(lastName)).sendKeys(name);
        return this;
    }

    public AccountForm enterPassword(String pwd){
        driver.findElement(By.xpath(password)).sendKeys(pwd);
        return this;
    }

    public AccountForm enterPasswordAgain(String password){
        driver.findElement(By.xpath(passwordAgain)).sendKeys(password);
        return this;
    }

    public AccountForm clickDobMonthDropDown(){
        driver.findElement(By.xpath(dobMonthDropDown)).click();
        return this;
    }

    public AccountForm selectBirthMonth(){
        driver.findElement(By.xpath(birthMonth)).click();
        return this;
    }

    public AccountForm enterBirthDay(String day){
        driver.findElement(By.id(birthDay)).sendKeys(day);
        return this;
    }

    public AccountForm enterBirthYear(String year){
        driver.findElement(By.id(birthYear)).sendKeys(year);
        return this;
    }

    public AccountForm enterRecoveryPhoneNumber(String number){
        driver.findElement(By.name(recoveryPhoneNumber)).sendKeys(number);
        return this;
    }

    public AccountForm enterRecoveryEmail(String email){
        driver.findElement(By.id(recoveryEmail)).sendKeys(email);
        return this;
    }

    public AccountForm clickAgreeTerms(){
        driver.findElement(By.id(terms)).click();
        return this;
    }

    public CreateAccountPage submitExpectingValidationError(){
        driver.findElement(By.id(submit)).click();
        return new CreateAccountPage(driver);
    }
}

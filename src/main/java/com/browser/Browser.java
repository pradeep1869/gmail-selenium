package com.browser;

import com.google.pages.GmailHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Browser {

    private final WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public GmailHomePage accessGmail(){
        driver.get("http://www.gmail.com");
        return PageFactory.initElements(driver, GmailHomePage.class);
    }

    public void quit(){
        driver.quit();
    }
}

package com.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static Browser browser;
    private static WebDriver driver;


   public Browser create() {
        if (browser == null) {
            System.setProperty("webdriver.chrome.driver", getClass().getResource("/drivers/chromedriver").getPath());
            driver = new ChromeDriver();
            driver.manage()
                    .timeouts()
                    .implicitlyWait(4, TimeUnit.SECONDS)
                    .pageLoadTimeout(4, TimeUnit.SECONDS);

            browser = new Browser(driver);
        }
        return browser;
    }
}

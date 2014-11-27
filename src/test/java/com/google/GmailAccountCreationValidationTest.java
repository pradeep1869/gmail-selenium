package com.google;

import com.browser.Browser;
import com.browser.BrowserFactory;
import com.google.pages.AccountForm;
import com.google.pages.CreateAccountPage;
import com.google.pages.GmailHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GmailAccountCreationValidationTest {
	private Browser browser;

	@Before
	public void doBefore() throws Exception {
        BrowserFactory browserFactory = new BrowserFactory();
        browser = browserFactory.create();
    }

	@After
	public void doAfter() throws Exception {
		browser.quit();
	}

	@Test
	public void should_validate_username_field_error_message_on_account_creation_page() throws Exception {
        GmailHomePage gmailHomePage = browser.accessGmail();
        CreateAccountPage accountPage = gmailHomePage.clickOnCreateAccountLink();

        AccountForm accountForm = accountPage.newForm();
        accountForm.enterFirstName("Gandhi");
        accountForm.enterLastName("Mahatma");
        accountForm.enterPassword("temp123");
        accountForm.enterPasswordAgain("temp123");
        accountForm.clickDobMonthDropDown();
        accountForm.selectBirthMonth();
        accountForm.enterBirthDay("1");
        accountForm.enterBirthYear("1970");
        accountForm.enterRecoveryPhoneNumber("7766100200");
        accountForm.enterRecoveryEmail("pradeep123@yahoo.com");
        accountForm.clickAgreeTerms();

        accountPage = accountForm.submitExpectingValidationError();

        assertEquals(accountPage.getValidationError(), "You can't leave this empty.");
	}

}

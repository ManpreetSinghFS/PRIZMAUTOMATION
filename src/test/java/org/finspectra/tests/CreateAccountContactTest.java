package org.finspectra.tests;

import org.finspectra.base.BaseTest;
import org.finspectra.pages.AccountPage;
import org.finspectra.pages.ContactPage;
import org.finspectra.pages.LoginPage;
import org.finspectra.pages.OtpPage;
import org.finspectra.utils.ConfigReader;
import org.finspectra.utils.TestDataGenerator;
import org.testng.annotations.Test;

public class CreateAccountContactTest extends BaseTest {

    // Holds the account name after creation so downstream tests can reference it
    public static String accountName;

    @Test
    public void createAccountAndContact() throws Exception {
        String username      = ConfigReader.get("username");
        String password      = ConfigReader.get("password");
        String emailAddress  = ConfigReader.get("emailAddress");
        String emailPassword = ConfigReader.get("emailPassword");

        new LoginPage(driver).login(username, password);

        OtpPage otpPage = new OtpPage(driver);
        if (otpPage.isOtpRequired()) {
            otpPage.handleOtp(emailAddress, emailPassword);
        } else {
            System.out.println("No OTP required — already logged in!");
        }

        // Generate unique, distinct names for Account and Contact
        String generatedAccount  = TestDataGenerator.generateAccountName();
        String contactFirstName  = TestDataGenerator.generateContactFirstName();
        String contactLastName   = TestDataGenerator.generateContactLastName();

        System.out.println("=== Names to be created ===");
        System.out.println("Account Name : " + generatedAccount);
        System.out.println("Contact Name : " + contactFirstName + " " + contactLastName);

        // Step 1 — create Account and persist its name
        accountName = new AccountPage(driver).createAccount(generatedAccount);

        // Step 2 — create Contact linked to the Account just created
        new ContactPage(driver).createContact(contactFirstName, contactLastName, accountName);

        // accountName is now stored in TestDataGenerator.getCreatedAccountName()
        // and also in the static field above for use across tests in this suite
        System.out.println("=== Stored Account Name for reuse: " + TestDataGenerator.getCreatedAccountName() + " ===");
    }
}

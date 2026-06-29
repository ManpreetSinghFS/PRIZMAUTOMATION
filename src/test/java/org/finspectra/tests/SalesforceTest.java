package org.finspectra.tests;

import org.finspectra.base.BaseTest;
import org.finspectra.pages.LoginPage;
import org.finspectra.pages.NewApplicationFlow;
import org.finspectra.pages.OtpPage;
import org.finspectra.utils.ConfigReader;
import org.testng.annotations.Test;

public class SalesforceTest extends BaseTest {

    @Test
    public void loginAndClickNew() throws Exception {
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

        NewApplicationFlow newApp = new NewApplicationFlow(driver);
        newApp.closePopups();
        newApp.clickNew();

        System.out.println("Final URL: " + driver.getCurrentUrl());
        System.out.println("Final Title: " + driver.getTitle());
    }
}

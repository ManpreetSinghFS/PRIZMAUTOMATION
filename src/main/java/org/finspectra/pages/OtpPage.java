package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.Locators;
import org.finspectra.utils.OtpHelper;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OtpPage extends BasePage {

    public OtpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOtpRequired() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOfElementLocated(Locators.OTP_FIELD));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void handleOtp(String emailAddress, String emailPassword) throws Exception {
        WebElement otpField = driver.findElement(Locators.OTP_FIELD);
        System.out.println("OTP page detected. Fetching OTP from Outlook web...");

        String otp = OtpHelper.fetchOTPFromOutlookWeb(driver, emailAddress, emailPassword);
        System.out.println("OTP fetched: " + otp);

        otpField.sendKeys(otp);

        WebElement verifyBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.VERIFY_BTN));
        verifyBtn.click();

        wait.until(ExpectedConditions.stalenessOf(verifyBtn));
        wait.until(d -> !d.getTitle().toLowerCase().contains("verify your identity"));
        System.out.println("OTP verified!");
    }
}

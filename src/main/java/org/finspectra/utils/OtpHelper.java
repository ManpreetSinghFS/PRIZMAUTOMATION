package org.finspectra.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtpHelper {

    public static String fetchOTPFromOutlookWeb(WebDriver driver, String emailAddress, String emailPassword) throws Exception {
        String salesforceTab = driver.getWindowHandle();

        ((JavascriptExecutor) driver).executeScript("window.open('');");
        String outlookTab = null;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(salesforceTab)) outlookTab = handle;
        }
        driver.switchTo().window(outlookTab);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            driver.get("https://outlook.office.com/mail/");

            if (driver.getCurrentUrl().contains("microsoftonline.com")) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.OUTLOOK_EMAIL_FIELD))
                        .sendKeys(emailAddress);
                driver.findElement(Locators.OUTLOOK_SUBMIT_BUTTON).click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.OUTLOOK_PASSWORD_FIELD))
                        .sendKeys(emailPassword);
                driver.findElement(Locators.OUTLOOK_SUBMIT_BUTTON).click();

                try {
                    new WebDriverWait(driver, Duration.ofSeconds(5))
                            .until(ExpectedConditions.elementToBeClickable(Locators.OUTLOOK_SUBMIT_BUTTON))
                            .click();
                } catch (TimeoutException ignored) {}
            }

            wait.until(ExpectedConditions.urlContains("outlook.office.com/mail"));
            Thread.sleep(3000);

            String otp = null;

            for (int attempt = 0; attempt < 12 && otp == null; attempt++) {
                if (attempt > 0) {
                    System.out.println("Waiting for OTP email... (attempt " + (attempt + 1) + "/12)");
                    Thread.sleep(5000);
                    driver.navigate().refresh();
                    Thread.sleep(3000);
                }

                List<WebElement> rows = driver.findElements(Locators.OUTLOOK_MESSAGE_ROWS);

                for (WebElement row : rows) {
                    String rowText = row.getText().toLowerCase();
                    if (rowText.contains("salesforce") || rowText.contains("verification") || rowText.contains("verify")) {
                        row.click();
                        Thread.sleep(2000);

                        try {
                            WebElement body = new WebDriverWait(driver, Duration.ofSeconds(10))
                                    .until(ExpectedConditions.visibilityOfElementLocated(Locators.OUTLOOK_MESSAGE_BODY));
                            otp = extractOTP(body.getText());
                        } catch (TimeoutException ignored) {}
                        break;
                    }
                }
            }

            if (otp == null) throw new RuntimeException("OTP email not received within 60 seconds. Check your Outlook inbox manually.");
            return otp;

        } finally {
            driver.close();
            driver.switchTo().window(salesforceTab);
        }
    }

    private static String extractOTP(String body) {
        Matcher matcher = Pattern.compile("\\b(\\d{6})\\b").matcher(body);
        return matcher.find() ? matcher.group(1) : null;
    }
}

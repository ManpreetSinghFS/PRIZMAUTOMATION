/*
 * ============================================================
 *  Project      : Prizm Lending Suite - Test Automation
 *  Module       : Lending Applications
 *  Test Script  : GeneratePricing.java
 * ============================================================
 *  Author       : Manpreet Singh
 *  Team         : QA Automation
 *  Organization : FinSpectra Pvt Limited
 * ==============================================================
 */

package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class GeneratePricing extends BasePage {

    public GeneratePricing(WebDriver driver) {
        super(driver);
    }

    public void clickGPQuickAction() {
        switchToDefault();
        WebElement GPQuickAction = wait.until(ExpectedConditions.elementToBeClickable(Locators.GP_QUICKACTION));
        GPQuickAction.click();
        switchToFrame(Locators.GP_IFRAME);
    }

    public void enterCreditLimitAmount(String amount) throws InterruptedException {
        WebElement creditLimit = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.CREDIT_LIMIT_AMOUNT));
        creditLimit.clear();
        creditLimit.sendKeys(amount);
        Thread.sleep(4000);
    }

    public void changeRateTypeToFixed() throws InterruptedException {
        WebElement rateType = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.RATE_TYPE));
        new Select(rateType).selectByVisibleText("Fixed");
        Thread.sleep(4000);
    }

    public void enterRate(String rate) throws InterruptedException {
        WebElement rateInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.RATE_INPUT));
        rateInput.clear();
        rateInput.sendKeys(rate);
        Thread.sleep(1000);
    }

    public void enterNoOfPayments(String noOfPayments) throws InterruptedException {
        WebElement payments = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.NO_OF_PAYMENTS));
        payments.clear();
        payments.sendKeys(noOfPayments);
        Thread.sleep(2000);
    }

    public void removeInterestReserveItemization() throws InterruptedException {
        WebElement removeInterestReserve = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.REMOVE_INTEREST_RESERVE));
        removeInterestReserve.click();
        Thread.sleep(1000);
    }

    public void removeFeeReserveItemization() throws InterruptedException {
        WebElement removeFeeReserve = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.REMOVE_FEE_RESERVE));
        removeFeeReserve.click();
        Thread.sleep(3000);
    }

    public void clickCalculate() throws InterruptedException {
        WebElement clickCalculate = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.CALCULATE_BUTTON));
        clickCalculate.click();
    }

    public void waitForSuccessMessage() throws InterruptedException {
        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.SUCCESS_MESSAGE));
        System.out.println(successMessage);

    }

    public void clickGeneratePricingSaveButton() throws InterruptedException {
        WebElement clickSave = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.GP_SAVE_BUTTON));
        clickSave.click();
        switchToDefault();
        Thread.sleep(3000);
    }

}

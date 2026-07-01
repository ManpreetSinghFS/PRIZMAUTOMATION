package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.ConfigReader;
import org.finspectra.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewApplicationFlow extends BasePage {

    public NewApplicationFlow(WebDriver driver) {
        super(driver);
    }

    public void closePopups() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        while (true) {
            try {
                WebElement closeBtn = shortWait.until(
                        ExpectedConditions.elementToBeClickable(Locators.CLOSE_BUTTON));
                closeBtn.click();
                System.out.println("Closed a popup.");
            } catch (TimeoutException e) {
                System.out.println("No (more) popups to close — moving to next step.");
                break;
            }
        }
    }

    public void clickNew() throws InterruptedException {
        WebElement newButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.APP_NEW_BUTTON));
        newButton.click();
        Thread.sleep(4000);
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 3000);");
    }

    public void selectProduct(){
        WebElement selectProduct = wait.until(ExpectedConditions.elementToBeClickable(Locators.SELECT_PRODUCT));
        selectProduct.click();
    }

    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -3000);");
        js.executeScript("window.scrollBy(0, -3000);");
    }

    public void clickNext() throws InterruptedException {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.NEXT_BUTTON));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", nextButton);
        js.executeScript("arguments[0].click();", nextButton);
        wait.until(ExpectedConditions.stalenessOf(nextButton));
        Thread.sleep(3000);
    }

    public void addAccountDetails(){
        String accountName = ConfigReader.get("accountName");

        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.ACCOUNT_SEARCH_BUTTON));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(accountName);

        // Select the matching account from the lookup dropdown to add it
        By accountOption = By.xpath("//*[@role='option'][.//*[@title='" + accountName + "']] "
                + "| //span[@title='" + accountName + "']");
        wait.until(ExpectedConditions.elementToBeClickable(accountOption)).click();

        System.out.println("Account added: " + accountName);
    }

    public void addContact() throws InterruptedException {

        WebElement contactCombobox = wait.until(
                ExpectedConditions.elementToBeClickable(Locators.CONTACT_COMBOBOX));
        contactCombobox.click();

        WebElement firstOption = wait.until(
                ExpectedConditions.elementToBeClickable(Locators.DROPDOWN_FIRST_OPTION));
        String selected = firstOption.getText();
        firstOption.click();
        Thread.sleep(2000);

        System.out.println("Contact selected: " + selected);
    }

    public void addJointApplicant(){
        WebElement jointApplicantRadio = wait.until(
                ExpectedConditions.presenceOfElementLocated(Locators.JOINT_APPLICANT_RADIO));
        // Scroll into the centre and JS-click to bypass any overlay intercepting the click
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", jointApplicantRadio);
        js.executeScript("arguments[0].click();", jointApplicantRadio);

        System.out.println("Joint applicant radio button selected.");
    }

    public void addLoanInformation(){
        String loanAmount = ConfigReader.get("requestedLoanAmount");
        WebElement loanAmountField = wait.until(
                ExpectedConditions.elementToBeClickable(Locators.REQUESTED_LOAN_AMOUNT));
        loanAmountField.clear();
        loanAmountField.sendKeys(loanAmount);

        System.out.println("Requested loan amount entered: " + loanAmount);
    }

    public void clickSave() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.SAVE_BUTTON));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", saveButton);
        js.executeScript("arguments[0].click();", saveButton);
        Thread.sleep(3000);
    }

    public void openNewlyCreatedApplication(){
        WebElement openNewApplication = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.OPEN_NEWLY_CREATED_APPLICATION));
        openNewApplication.click();
    }



}

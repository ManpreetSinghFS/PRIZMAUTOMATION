package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void createContact(String firstName, String lastName, String accountName) {
        driver.get(getBaseUrl() + "/lightning/o/Contact/new");

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CONTACT_LAST_NAME))
                .sendKeys(lastName);

        driver.findElement(Locators.CONTACT_FIRST_NAME).sendKeys(firstName);

        // Type into the Account lookup and pick the matching dropdown option
        driver.findElement(Locators.CONTACT_ACCT_LOOKUP).sendKeys(accountName);
        By accountOption = By.xpath("//span[@title='" + accountName + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountOption)).click();

        wait.until(ExpectedConditions.elementToBeClickable(Locators.CONTACT_SAVE_BUTTON)).click();

        wait.until(ExpectedConditions.urlContains("/view"));

        System.out.println("Contact created  : " + firstName + " " + lastName);
        System.out.println("Linked to Account: " + accountName);
        System.out.println("Contact URL      : " + driver.getCurrentUrl());
    }
}

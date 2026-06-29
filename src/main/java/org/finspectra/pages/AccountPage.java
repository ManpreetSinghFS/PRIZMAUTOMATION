package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.Locators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String createAccount(String accountName) {
        // Open App Launcher and search for Accounts
        wait.until(ExpectedConditions.elementToBeClickable(Locators.APP_LAUNCHER_BUTTON)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.APP_LAUNCHER_SEARCH))
                .sendKeys("Accounts");

        // wait for search results to render
        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}

        // JS click avoids Selenium's defaultView bug on Salesforce Lightning shadow DOM elements
        WebElement accountItem = wait.until(ExpectedConditions.elementToBeClickable(Locators.APP_LAUNCHER_ACCOUNT));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", accountItem);

        // Wait for Accounts list page, then click New
        wait.until(ExpectedConditions.urlContains("/o/Account/list"));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.ACCOUNT_LIST_NEW_BTN)).click();

        // Fill in account name and save
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ACCOUNT_NAME_FIELD))
                .sendKeys(accountName);

        wait.until(ExpectedConditions.elementToBeClickable(Locators.ACCOUNT_SAVE_BUTTON)).click();

        wait.until(ExpectedConditions.urlContains("/view"));

        System.out.println("Account created : " + accountName);
        System.out.println("Account URL     : " + driver.getCurrentUrl());
        return accountName;
    }
}

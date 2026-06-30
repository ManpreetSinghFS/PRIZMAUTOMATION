package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checklist extends BasePage
{
    public Checklist(WebDriver driver) {super(driver);}

    public void openChecklistTab() throws InterruptedException {
        WebElement openChecklistTab = wait.until(ExpectedConditions.elementToBeClickable(Locators.CLICK_CHECKLIST_TAB));
        openChecklistTab.click();
        Thread.sleep(3000);

    }

    private void jsClick(By locator) throws InterruptedException {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        Thread.sleep(3000);
    }

    public void verifyCheckLists() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            jsClick(Locators.CLICK_VERIFY);
        }
    }




}

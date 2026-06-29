package org.finspectra.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.js = (JavascriptExecutor) driver;
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected String getBaseUrl() {
        String url = driver.getCurrentUrl();
        int idx = url.indexOf("/lightning");
        return idx > 0 ? url.substring(0, idx) : url;
    }

    protected void switchToFrame(By frameLocator) {
        WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(frameLocator));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    protected void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}

package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.ConfigReader;
import org.finspectra.utils.Locators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final String loginUrl;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.loginUrl = ConfigReader.get("loginUrl");
    }

    public void login(String username, String password) {
        driver.get(loginUrl);
        driver.findElement(Locators.LOGIN_USERNAME).sendKeys(username);
        driver.findElement(Locators.LOGIN_PASSWORD).sendKeys(password);
        driver.findElement(Locators.LOGIN_BUTTON).click();
        wait.until(d -> !d.getCurrentUrl().equals(loginUrl));
        System.out.println("After Login Title: " + driver.getTitle());
        System.out.println("After Login URL:   " + driver.getCurrentUrl());
    }
}

package org.finspectra.base;

import org.finspectra.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.get("browser");
        if ("edge".equalsIgnoreCase(browser)) {
            driver = new EdgeDriver(new EdgeOptions());
        } else {
            driver = new ChromeDriver(new ChromeOptions());
        }
        driver.manage().window().maximize();
    }

    //@AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

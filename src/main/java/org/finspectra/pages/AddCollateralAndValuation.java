/*
 * ============================================================
 *  Project      : Prizm Lending Suite - Test Automation
 *  Module       : Lending Applications
 *  Test Script  : AddCollateralAndvaluation.java
 * ============================================================
 *  Author       : Manpreet Singh
 *  Team         : QA Automation
 *  Organization : FinSpectra Pvt Limited
 * ==============================================================
 */

package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.ConfigReader;
import org.finspectra.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AddCollateralAndValuation extends BasePage {

    public AddCollateralAndValuation(WebDriver driver) {super(driver);}

    public void clickAddCollateralQuickAction () throws InterruptedException {
        switchToDefault();
        WebElement clickCollateralIcon =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_QUICKACTION));
        clickCollateralIcon.click();
        Thread.sleep(4000);
    }

    public void selectAnOptionCollateral() throws InterruptedException {
        WebElement selectExisting =  wait.until(ExpectedConditions.elementToBeClickable(Locators.SELECT_EXISTING));
        selectExisting.click();
        Thread.sleep(2000);
        WebElement selectNew =  wait.until(ExpectedConditions.elementToBeClickable(Locators.SELECT_NEW));
        selectNew.click();

    }

    public void addCollateralSubFamily (){
        String colSubFamily = ConfigReader.get("CollateralSubFamily");
        WebElement CollateralSubFamily =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_SUBFAMILY));
        CollateralSubFamily.click();
        WebElement SelectSubFamily =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_SUBFAMILY_DD));
        SelectSubFamily.click();
    }

    public void addCollateralName (){
        String colName = ConfigReader.get("CollateralName");
        WebElement CollateralName = wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_NAME));
        CollateralName.sendKeys(colName);
    }

    public void addCollateralSecurityRanking (){
        String colSecurityRanking = ConfigReader.get("CollateralSecurityRanking");
        WebElement CollateralSecurityRanking =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_SECURITY_RANKING));
        CollateralSecurityRanking.click();
        WebElement CollateralSecurityRankingDD =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_SECURITY_RANKING_DD));
        CollateralSecurityRankingDD.click();
    }

    public void addCollateralAddress (){
        String searchAddress = ConfigReader.get("CollateralAddress");
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_ADDRESS));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(searchAddress);
    }

    public void selectPropertyType (){
        String colPropertyType = ConfigReader.get("PropertyType");
        WebElement CollateralPropertyType =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_PROPERTY_TYPE));
        CollateralPropertyType.click();
        By propertyTypeOption = By.xpath("//lightning-base-combobox-item//span[@title='" + colPropertyType + "']");
        WebElement CollateralPropertyTypeDD =  wait.until(ExpectedConditions.elementToBeClickable(propertyTypeOption));
        CollateralPropertyTypeDD.click();
    }

    public void selectLocation (){
        String location = ConfigReader.get("Location");
        WebElement CollateralLocation =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_LOCATION));
        CollateralLocation.click();
        WebElement CollateralLocationDD =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_LOCATION_DD));
        CollateralLocationDD.click();
    }

    public void selectValuationDetailsRadioButton (){
        WebElement addValuationRadioButton = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ADD_VALUATION_RADIOBUTTON));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", addValuationRadioButton);
        js.executeScript("arguments[0].click();", addValuationRadioButton);
    }

    public void addCollateralValuation () throws InterruptedException {
        String valuation = ConfigReader.get("Valuation");
        WebElement LatestValuation = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ADD_COLLATERAL_VALUATION));
        LatestValuation.clear();
        LatestValuation.sendKeys(valuation);
        LatestValuation.sendKeys(Keys.TAB);
        Thread.sleep(3000);
    }

    public void addCollateralCompleteValuation (){
        String Amount = ConfigReader.get("CompleteValuation");
        WebElement completeValuation = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SELECT_COMPLETE_VALUE));
        completeValuation.clear();
        completeValuation.sendKeys(Amount);
        completeValuation.sendKeys(Keys.TAB);
    }
}

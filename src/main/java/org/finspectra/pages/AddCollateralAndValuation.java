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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AddCollateralAndValuation extends BasePage {

    public AddCollateralAndValuation(WebDriver driver) {super(driver);}

    public void clickAddCollateralQuickAction (){
        switchToDefault();
        WebElement clickCollateralIcon =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_QUICKACTION));
        clickCollateralIcon.click();
    }

    public void addCollateralSubFamily (){
        String colSubFamily = ConfigReader.get("CollateralSubFamily");
        WebElement CollateralSubFamily =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_SUBFAMILY));
        CollateralSubFamily.click();
        new Select(CollateralSubFamily).selectByVisibleText(colSubFamily);
    }

    public void addCollateralName (){
        String colName = ConfigReader.get("CollateralName");
        WebElement loanAmountField = wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_NAME));
        loanAmountField.sendKeys(colName);
    }

    public void addCollateralSecurityRanking (){
        String colSecurityRanking = ConfigReader.get("CollateralSecurityRanking");
        WebElement CollateralSecurityRanking =  wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_SECURITY_RANKING));
        CollateralSecurityRanking.click();
        new Select(CollateralSecurityRanking).selectByVisibleText(colSecurityRanking);
    }

    public void addCollateralAddress (){
        String searchAddress = ConfigReader.get("CollateralAddress");
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_COLLATERAL_ADDRESS));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(searchAddress);
    }

    public void selectPropertyType (){

    }

    public void selectLocation (){

    }

    public void selectValuationDetailsRadioButton (){

    }

    public void addCollateralValuation (){

    }


}

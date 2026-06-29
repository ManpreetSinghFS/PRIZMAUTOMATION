package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class StageValidationAndCompletion extends BasePage {

    public StageValidationAndCompletion(WebDriver driver) {
        super(driver);}

    public void clickValidate() throws InterruptedException {

        WebElement clickValidate = wait.until(
                ExpectedConditions.presenceOfElementLocated(Locators.VALIDATE));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", clickValidate);
        js.executeScript("arguments[0].click();", clickValidate);
        Thread.sleep(3000);
    }

    public void clickMarkStageAsCompleted() throws InterruptedException {

        WebElement clickMarkStageAsCompleted = wait.until(
                ExpectedConditions.presenceOfElementLocated(Locators.STAGE_COMPLETE));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", clickMarkStageAsCompleted);
        js.executeScript("arguments[0].click();", clickMarkStageAsCompleted);
        Thread.sleep(3000);

    }

    public void openSuccessCriteria(){
        WebElement clickSuccessCriteriaIcon = wait.until(
                ExpectedConditions.presenceOfElementLocated(Locators.SUCCESS_CRITERIA));
    }

}


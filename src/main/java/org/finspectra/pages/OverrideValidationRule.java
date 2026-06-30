package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverrideValidationRule extends BasePage {

    public OverrideValidationRule(WebDriver driver) {
        super(driver);
    }

    public void openFailedRule() throws InterruptedException {
        WebElement openFailedRule = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.OPEN_FAILED_VALIDATION_RULE));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", openFailedRule);
        js.executeScript("arguments[0].click();", openFailedRule);
        Thread.sleep(4000);
    }

    public void clickEditIcon(){
        WebElement clickEditIcon = wait.until(ExpectedConditions.elementToBeClickable(Locators.CLICK_EDIT_ICON));
        clickEditIcon.click();
    }

    public void checkOverRideCheckbox(){
        WebElement checkCheckBox = wait.until(ExpectedConditions.elementToBeClickable(Locators.CHECK_CHECKBOX));
        checkCheckBox.click();
    }

    public void openApplicationID() throws InterruptedException {
        WebElement openApplication = wait.until(ExpectedConditions.elementToBeClickable(Locators.APPLICATION_NUMBER_LINK));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", openApplication);
        js.executeScript("arguments[0].click();", openApplication);
        Thread.sleep(3000);
    }

}

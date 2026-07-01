package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.ConfigReader;
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
        js.executeScript("arguments[0].click();", clickEditIcon);
    }

    public void checkOverRideCheckbox() {
        js.executeScript(
            "function deepQuery(root, sel) {" +
            "  var r = root.querySelector(sel); if (r) return r;" +
            "  var els = root.querySelectorAll('*');" +
            "  for (var i = 0; i < els.length; i++) {" +
            "    if (els[i].shadowRoot) { r = deepQuery(els[i].shadowRoot, sel); if (r) return r; }" +
            "  } return null;" +
            "}" +
            "deepQuery(document, 'input[name=\"fsCore__Is_Overridden__c\"]').click();"
        );
    }

    public void openApplicationID() throws InterruptedException {
        WebElement openApplication = wait.until(ExpectedConditions.elementToBeClickable(Locators.APPLICATION_NUMBER_LINK));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", openApplication);
        js.executeScript("arguments[0].click();", openApplication);
        Thread.sleep(3000);
    }

    public void clickOverRide() throws InterruptedException {
        WebElement clickOverRide = wait.until(ExpectedConditions.elementToBeClickable(Locators.CLICK_OVERRIDE_ICON));
        clickOverRide.click();
        Thread.sleep(2000);
    }

    public void addOverrideComments(){
        String Reason = ConfigReader.get("Reason");
        WebElement addComments = wait.until(ExpectedConditions.elementToBeClickable(Locators.OVERRIDE_REASON));
        addComments.click();
        addComments.sendKeys(Reason);
    }

    public void clickSave() throws InterruptedException {
        WebElement clickSave = wait.until(ExpectedConditions.elementToBeClickable(Locators.SAVE_OVERRIDE));
        clickSave.click();
        Thread.sleep(3000);
    }

    public void closeTab() throws InterruptedException {
        WebElement closeTab = wait.until(ExpectedConditions.elementToBeClickable(Locators.CLOSE_RULE));
        closeTab.click();
        Thread.sleep(3000);
    }

}

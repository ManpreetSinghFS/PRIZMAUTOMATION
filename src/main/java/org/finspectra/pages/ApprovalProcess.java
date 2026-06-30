package org.finspectra.pages;

import org.finspectra.base.BasePage;
import org.finspectra.utils.ConfigReader;
import org.finspectra.utils.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApprovalProcess extends BasePage {

    public ApprovalProcess(WebDriver driver) {super(driver);}

    public void clickApprovalProcessQuickAction(){
        WebElement clickAppProcessQuickAction = wait.until(ExpectedConditions.elementToBeClickable(Locators.APPROVAL_PROCESS_QUICKACTION));
        clickAppProcessQuickAction.click();
    }

    public void addComments() throws InterruptedException {
        String AppProComment = ConfigReader.get("approvalProcessComment");
        WebElement addComments = wait.until(ExpectedConditions.elementToBeClickable(Locators.APPROVAL_PROCESS_COMMENT));
        addComments.click();
        addComments.clear();
        addComments.sendKeys(AppProComment);
        Thread.sleep(2000);
    }

    public void clickSubmit() throws InterruptedException {
        WebElement clickSubmit = wait.until(ExpectedConditions.elementToBeClickable(Locators.APPROVAL_PROCESS_SUBMIT));
        clickSubmit.click();
        Thread.sleep(2000);
    }

    public void selectApprovalUser() throws InterruptedException {
        String userName = ConfigReader.get("userName");
        WebElement selectUser = wait.until(ExpectedConditions.elementToBeClickable(Locators.APPROVAL_USER_SEARCH));
        selectUser.click();
        selectUser.sendKeys(userName);
        Thread.sleep(2000);
        WebElement selectUserName = wait.until(ExpectedConditions.elementToBeClickable(Locators.APPROVAL_USER_SELECT));
        selectUserName.click();
    }

    public void openApprovalReceived() throws InterruptedException {
        WebElement openApproval = wait.until(ExpectedConditions.elementToBeClickable(Locators.OPEN_APPROVAL));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", openApproval);
        js.executeScript("arguments[0].click();", openApproval);
        Thread.sleep(3000);
    }

    public void clickApproveButton() throws InterruptedException {
        WebElement clickApprove = wait.until(ExpectedConditions.elementToBeClickable(Locators.CLICK_APPROVAL_PROCESS));
        clickApprove.click();
        Thread.sleep(2000);
    }

    public void clickApproveAfterAddingComments() throws InterruptedException {
        String AppProComment = ConfigReader.get("approvalProcessApprovedComment");
        WebElement addComments = wait.until(ExpectedConditions.elementToBeClickable(Locators.APPROVAL_PROCESS_COMMENT));
        addComments.click();
        addComments.clear();
        addComments.sendKeys(AppProComment);
        Thread.sleep(2000);
        WebElement approveIcon = wait.until(ExpectedConditions.elementToBeClickable(Locators.CLICK_APPROVE));
        approveIcon.click();
        WebElement openApplication = wait.until(ExpectedConditions.elementToBeClickable(Locators.APPLICATION_NUMBER_LINK));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", openApplication);
        js.executeScript("arguments[0].click();", openApplication);

    }

}

package org.finspectra.tests;

import org.finspectra.base.BaseTest;
import org.finspectra.pages.*;
import org.finspectra.utils.ConfigReader;
import org.testng.annotations.Test;

public class NewApplicationFlowTest extends BaseTest {

    @Test
    public void runNewApplicationFlow() throws Exception {
        String username      = ConfigReader.get("username");
        String password      = ConfigReader.get("password");
        String emailAddress  = ConfigReader.get("emailAddress");
        String emailPassword = ConfigReader.get("emailPassword");

        String creditLimitAmount = ConfigReader.get("creditLimitAmount");
        String rate              = ConfigReader.get("rate");
        String noOfPayments      = ConfigReader.get("noOfPayments");

        new LoginPage(driver).login(username, password);

        OtpPage otpPage = new OtpPage(driver);
        if (otpPage.isOtpRequired()) {
            otpPage.handleOtp(emailAddress, emailPassword);
        } else {
            System.out.println("No OTP required — already logged in!");
        }

        NewApplicationFlow newApp = new NewApplicationFlow(driver);
        StageValidationAndCompletion stageValAndApp = new StageValidationAndCompletion(driver);
        GeneratePricing generatePricing = new GeneratePricing(driver);
        AddCollateralAndValuation addcolVal = new AddCollateralAndValuation(driver);

        newApp.closePopups();
        newApp.clickNew();
        newApp.clickNext();
        newApp.clickNext();
        newApp.addAccountDetails();
        newApp.addContact();
        newApp.clickNext();
        newApp.addJointApplicant();
        newApp.clickNext();
        newApp.addLoanInformation();
        newApp.clickSave();
        newApp.openNewlyCreatedApplication();
        addcolVal.clickAddCollateralQuickAction();
        newApp.clickNext();
        newApp.clickNext();
        addcolVal.addCollateralSubFamily();
        addcolVal.addCollateralName();
        addcolVal.addCollateralSecurityRanking();
        addcolVal.addCollateralAddress();


        generatePricing.clickGPQuickAction();
        generatePricing.enterCreditLimitAmount(creditLimitAmount);
        generatePricing.changeRateTypeToFixed();
        generatePricing.enterRate(rate);
        generatePricing.enterNoOfPayments(noOfPayments);
        newApp.scrollDown();
        generatePricing.removeFeeReserveItemization();
        generatePricing.removeInterestReserveItemization();
        newApp.scrollUp();
        generatePricing.clickCalculate();
        generatePricing.waitForSuccessMessage();
        generatePricing.clickGeneratePricingSaveButton();
        stageValAndApp.openSuccessCriteria();
        stageValAndApp.clickValidate();
        stageValAndApp.clickMarkStageAsCompleted();
        stageValAndApp.clickValidate();


    }
}

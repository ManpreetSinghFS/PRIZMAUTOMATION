package org.finspectra.utils;

import org.openqa.selenium.By;

public class Locators {

    //  Login Page
    public static final By LOGIN_USERNAME = By.xpath("//input[@name='username']");
    public static final By LOGIN_PASSWORD = By.xpath("//input[@name='pw']");
    public static final By LOGIN_BUTTON   = By.xpath("//input[@name='Login']");

    // OTP Page
    public static final By OTP_FIELD  = By.xpath("//input[@id='emc']");
    public static final By VERIFY_BTN = By.xpath("//input[@id='save'] | //button[@id='save'] | //input[@title='Verify']");

    // New Application Button
    public static final By APP_NEW_BUTTON = By.xpath("//div[text()='New']");

    // Close button on post-login popups/modals
    public static final By CLOSE_BUTTON = By.xpath("//button[.//*[@data-key='close']]");

    // Outlook Web Login
    public static final By OUTLOOK_EMAIL_FIELD    = By.cssSelector("input[type='email']");
    public static final By OUTLOOK_PASSWORD_FIELD = By.cssSelector("input[type='password']");
    public static final By OUTLOOK_SUBMIT_BUTTON  = By.cssSelector("input[type='submit']");

    // Outlook Web Inbox
    public static final By OUTLOOK_MESSAGE_ROWS = By.cssSelector("div[role='option']");
    public static final By OUTLOOK_MESSAGE_BODY = By.cssSelector("div[aria-label='Message body']");

    // New Application Flow
    public static final By NEXT_BUTTON = By.xpath ("//button[contains(@class,'slds-button_brand') and normalize-space()='Next']");
    public static final By ACCOUNT_SEARCH_BUTTON = By.xpath ("//input[@aria-label='Account']");
    public static final By CONTACT_COMBOBOX = By.xpath("//button[@aria-label='Contacts' and @role='combobox']");
    public static final By DROPDOWN_FIRST_OPTION = By.xpath("(//*[@role='option'])[1]");
    public static final By JOINT_APPLICANT_RADIO = By.xpath("//input[@value='Add_Joint_Applicant_No']/following-sibling::label//span[@class='slds-radio_faux']");
    public static final By REQUESTED_LOAN_AMOUNT = By.xpath("//input[@name='Requested_Loan_Amount']");
    public static final By SAVE_BUTTON = By.xpath ("//button[text()='Save']");
    public static final By OPEN_NEWLY_CREATED_APPLICATION = By.xpath ("//button[text()='Go to Application']");
    public static final By SELECT_PRODUCT = By.xpath ("//input[@type='radio'][@name='pickerOptions'][@value='ER']/following-sibling::label//span[@class='pickerWithDescription slds-visual-picker__figure slds-visual-picker__text slds-align_absolute-center']");

    // App Launcher
    public static final By APP_LAUNCHER_BUTTON  = By.xpath("//button[@title='App Launcher']");
    public static final By APP_LAUNCHER_SEARCH  = By.xpath("//input[@placeholder='Search apps and items...']");
    public static final By APP_LAUNCHER_ACCOUNT = By.xpath("//a[@title='Accounts'] | //p[text()='Accounts'] | //one-app-launcher-menu-item//a[contains(@href,'/Account/')]");
    public static final By ACCOUNT_LIST_NEW_BTN = By.xpath("//a[@title='New'] | //button[@title='New']");

    // Account Creation Form
    public static final By ACCOUNT_NAME_FIELD  = By.xpath("//input[@name='Name']");
    public static final By ACCOUNT_SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");

    // Contact Creation Form
    public static final By CONTACT_FIRST_NAME  = By.xpath("//input[@name='firstName']");
    public static final By CONTACT_LAST_NAME   = By.xpath("//input[@name='lastName']");
    public static final By CONTACT_ACCT_LOOKUP = By.xpath("//input[@placeholder='Search Accounts...']");
    public static final By CONTACT_SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");

    // StageCompletion And Validation
    public static final By VALIDATE  = By.xpath("//button[.//span[text()='Validate']]");
    public static final By STAGE_COMPLETE  = By.xpath("//button[@title='Mark Stage as Complete']");

    // Generate Pricing Screen
    public static final By GP_QUICKACTION  = By.xpath("//button[text()='Generate Pricing']");
    public static final By GP_IFRAME  = By.xpath("//iframe[starts-with(@title,'Generate Pricing')]");
    public static final By CREDIT_LIMIT_AMOUNT  = By.xpath("//input[@id='lendingAppPricingEditPage:j_id7:j_id56:j_id57:j_id74']");
    public static final By RATE_TYPE  = By.xpath("//select[@id='lendingAppPricingEditPage:j_id7:j_id56:j_id57:j_id95']");
    public static final By RATE_INPUT  = By.xpath("//input[@id='lendingAppPricingEditPage:j_id7:j_id56:j_id57:j_id102']");
    public static final By NO_OF_PAYMENTS  = By.xpath("//input[@id='lendingAppPricingEditPage:j_id7:j_id56:j_id57:j_id117']");
    public static final By REMOVE_FEE_RESERVE  = By.xpath("(//div[@class='slds-float_right'])[5]");
    public static final By REMOVE_INTEREST_RESERVE  = By.xpath("(//div[@class='slds-float_right'])[6]");
    public static final By CALCULATE_BUTTON  = By.xpath("//input[@id='lendingAppPricingEditPage:j_id7:j_id22']");
    public static final By GP_SAVE_BUTTON  = By.xpath("//input[@title ='Click to save the changes.']");
    public static final By SUCCESS_MESSAGE  = By.xpath("//div[@class='message confirmM3']");
    public static final By SUCCESS_CRITERIA  = By.xpath("//button[@title='Click to toggle the success criteria of the current stage.']");

    // Add Collateral And Its Valuation
    public static final By ADD_COLLATERAL_QUICKACTION  = By.xpath("//button[text()='Add Collateral']");
    public static final By ADD_COLLATERAL_SUBFAMILY  = By.xpath("//button[@aria-label = 'Collateral Sub Family']");
    public static final By ADD_COLLATERAL_NAME = By.xpath("//input[@name = 'Name']");
    public static final By ADD_COLLATERAL_SECURITY_RANKING = By.xpath("//button[@aria-label= 'Security Ranking']");
    public static final By ADD_COLLATERAL_ADDRESS = By.xpath("//input[@aria-label= 'Search']");
    public static final By ADD_COLLATERAL_PROPERTY_TYPE = By.xpath("//button[@aria-label = 'Property Type']");
    public static final By ADD_COLLATERAL_LOCATION = By.xpath("//button[@aria-label = 'Property Type']");
    public static final By ADD_VALUATION_RADIOBUTTON = By.xpath("//input[@value='Add_Collateral_Valuation_Yes']/following-sibling::label//span[@class='slds-radio_faux']");
    public static final By ADD_COLLATERAL_VALUATION = By.xpath("//input[@name='Complete_Valuation']");
    public static final By ADD_COLLATERAL_SUBFAMILY_DD = By.xpath("//lightning-base-combobox-item//span[text()='Single Family Home']");
    public static final By ADD_COLLATERAL_SECURITY_RANKING_DD = By.xpath("//lightning-base-combobox-item//span[text()='First Mortgage']");
    public static final By ADD_COLLATERAL_LOCATION_DD = By.xpath("//lightning-base-combobox-item//span[text()='Urban']");
    public static final By SELECT_EXISTING = By.xpath("///span[text()='Choose from an existing collateral and link to application']/ancestor::label");
    public static final By SELECT_NEW = By.xpath("//span[text()='Create a new collateral and link to application']/ancestor::label");
    public static final By SELECT_COMPLETE_VALUE = By.xpath("//input[@name='Complete_Valuation']");


    // Approval Process
    public static final By APPROVAL_PROCESS_QUICKACTION = By.xpath("//button[normalize-space()=\"Submit for Approval\"]");
    public static final By APPROVAL_PROCESS_COMMENT = By.xpath("//textarea[@cols='20' and @rows='10']");
    public static final By APPROVAL_PROCESS_SUBMIT = By.xpath("//span[text()='Submit']");
    public static final By APPROVAL_USER_SEARCH = By.xpath("//input[@title='Search Users']");
    public static final By APPROVAL_USER_SELECT = By.xpath("//div[@title='Manpreet Singh']");
    public static final By OPEN_APPROVAL = By.xpath("//a[@data-special-link='true' and contains(.,'Director')]");
    public static final By CLICK_APPROVAL_PROCESS = By.xpath("//div[@title='Approve']");
    public static final By CLICK_APPROVE = By.xpath("//span[text()='Approve']");
    public static final By APPLICATION_NUMBER_LINK = By.xpath("//div[contains(@class,'outputLookupContainer')]//a[@data-refid='recordId']");

    // verify Checklist
    public static final By CLICK_CHECKLIST_TAB = By.xpath("//a[text()='Documents & Checklists']");
    public static final By CLICK_VERIFY = By.xpath("(//span[@title='Click to mark the record as Verified.'])[1]");

    // Override Validation Rule
    public static final By OPEN_FAILED_VALIDATION_RULE = By.xpath("//a[text()='Required Documents Check']");
    public static final By clickOverrideButton = By.xpath("//button[text()='Override']");
    public static final By overrideReason = By.xpath("//textarea[@class=' textarea']");
    public static final By saveOverride = By.xpath("(//span[text()='Save'])[2]");
    public static final By closeRuleResult = By.xpath("//button[contains(@class,\"slds-button_icon-container\") and starts-with(@title,\"Close RR-\")]");
    public static final By CLICK_EDIT_ICON = By.xpath("//span[text()='Edit Overridden']");
    public static final By CHECK_CHECKBOX = By.xpath("//input[@name='fsCore__Is_Overridden__c']");

}

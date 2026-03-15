package com.avinashsinha.pages.pageObjectModel.appVWO.improved_POM;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By USERNAME = By.id("login-username");
    private static final By PASSWORD = By.id("login-password");
    private static final By SIGN_BUTTON = By.id("js-login-btn");
    private static final By ERROR_MESSAGE = By.id("js-notification-box-msg");
    //private By signBySSO = By.xpath("//button[text()='Sign in using SSO']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public String loginToVWOLoginInvalidCreds(String usr, String pwd) {

        openVWOUrl();

        WaitHelpers.checkVisibility(driver, USERNAME,5);
        WaitHelpers.checkVisibility(driver, PASSWORD,5);
        WaitHelpers.waitForElementToBeClickable(driver, SIGN_BUTTON);

        enterInput(USERNAME, usr);
        enterInput(PASSWORD, pwd);
        clickElement(SIGN_BUTTON);

        WaitHelpers.checkVisibility(driver, ERROR_MESSAGE);

        return getText(ERROR_MESSAGE);
    }

    public void loginToVWOLoginValidCreds(String usr, String pwd) {

        openVWOUrl();

        WaitHelpers.checkVisibility(driver, USERNAME,5);
        WaitHelpers.checkVisibility(driver, PASSWORD,5);
        WaitHelpers.waitForElementToBeClickable(driver, SIGN_BUTTON);

        enterInput(USERNAME, usr);
        enterInput(PASSWORD, pwd);
        clickElement(SIGN_BUTTON);

    }

}
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
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");
    //private By signBySSO = By.xpath("//button[text()='Sign in using SSO']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public String loginToVWOLoginInvalidCreds(String usr, String pwd) {

        openVWOUrl();

        WaitHelpers.checkVisibility(driver,username,5);
        WaitHelpers.checkVisibility(driver,password,5);
        WaitHelpers.waitForElementToBeClickable(driver,signButton);

        enterInput(username, usr);
        enterInput(password, pwd);
        clickElement(signButton);

        WaitHelpers.checkVisibility(driver, errorMessage);

        return getText(errorMessage);
    }

    public void loginToVWOLoginValidCreds(String usr, String pwd) {

        openVWOUrl();

        WaitHelpers.checkVisibility(driver,username,5);
        WaitHelpers.checkVisibility(driver,password,5);
        WaitHelpers.waitForElementToBeClickable(driver,signButton);

        enterInput(username, usr);
        enterInput(password, pwd);
        clickElement(signButton);

    }

}
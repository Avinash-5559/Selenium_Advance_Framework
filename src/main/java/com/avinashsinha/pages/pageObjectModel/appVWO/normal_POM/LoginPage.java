package com.avinashsinha.pages.pageObjectModel.appVWO.normal_POM;

import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class LoginPage {

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

        driver.get("https://app.vwo.com/#/login");

        WaitHelpers.checkVisibility(driver, USERNAME,5);
        WaitHelpers.checkVisibility(driver, PASSWORD,5);
        WaitHelpers.waitForElementToBeClickable(driver, SIGN_BUTTON);

        driver.findElement(USERNAME).sendKeys(usr);
        driver.findElement(PASSWORD).sendKeys(pwd);
        driver.findElement(SIGN_BUTTON).click();

        WaitHelpers.checkVisibility(driver, ERROR_MESSAGE);

        String errorMessageText = driver.findElement(ERROR_MESSAGE).getText();
        return errorMessageText;

    }

    public void loginToVWOLoginValidCreds(String usr, String pwd) {

        driver.get("https://app.vwo.com/#/login");
        driver.findElement(USERNAME).sendKeys(usr);
        driver.findElement(PASSWORD).sendKeys(pwd);
        driver.findElement(SIGN_BUTTON).click();

    }

}
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

    //Step 1 : These are Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");
    //private By signBySSO = By.xpath("//button[text()='Sign in using SSO']");

    //Step 2 : These are Page Actions
    public String loginToVWOLoginInvalidCreds(String usr, String pwd) {

        driver.get("https://app.vwo.com/#/login");
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        WaitHelpers.checkVisibility(driver, errorMessage);

        String errorMessage_Text = driver.findElement(errorMessage).getText();
        return errorMessage_Text;

    }

    public void loginToVWOLoginValidCreds(String usr, String pwd) {

        driver.get("https://app.vwo.com/#/login");
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

    }

}
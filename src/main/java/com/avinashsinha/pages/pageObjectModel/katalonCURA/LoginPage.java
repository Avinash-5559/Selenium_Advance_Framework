package com.avinashsinha.pages.pageObjectModel.katalonCURA;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators
    private By username = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginButton = By.id("btn-login");

    //Step 2 : These are Page Actions
    public void loginToKatalonCURACreds() {

        WaitHelpers.urlContains(driver,PropertiesReader.readKey("katalon_loginURL"));

        enterInput(username, PropertiesReader.readKey("katalon_username"));
        enterInput(password, PropertiesReader.readKey("katalon_password"));
        clickElement(loginButton);

    }

}
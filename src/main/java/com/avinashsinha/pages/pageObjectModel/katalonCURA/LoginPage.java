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

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By USERNAME = By.id("txt-username");
    private static final By PASSWORD = By.id("txt-password");
    private static final By LOGIN_BUTTON = By.id("btn-login");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void loginToKatalonCURACreds() {

        WaitHelpers.urlContains(driver,PropertiesReader.readKey("katalon_loginURL"));

        enterInput(USERNAME, PropertiesReader.readKey("katalon_username"));
        enterInput(PASSWORD, PropertiesReader.readKey("katalon_password"));
        clickElement(LOGIN_BUTTON);

    }

}
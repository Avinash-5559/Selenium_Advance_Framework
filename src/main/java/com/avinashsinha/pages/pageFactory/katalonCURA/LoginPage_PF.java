package com.avinashsinha.pages.pageFactory.katalonCURA;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This is Page Class
public class LoginPage_PF extends CommonToAllPage {

    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Step 1 : These are Page Locators
    @FindBy(id = "txt-username")
    private WebElement username;

    @FindBy(id = "txt-password")
    private WebElement password;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    //Step 2 : These are Page Actions
    public void loginToKatalonCURACreds() {

        WaitHelpers.urlContains(driver, PropertiesReader.readKey("katalon_loginURL"));

        enterInput(username, PropertiesReader.readKey("katalon_username"));
        enterInput(password, PropertiesReader.readKey("katalon_password"));
        clickElement(loginButton);

    }

}
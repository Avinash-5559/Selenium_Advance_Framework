package com.avinashsinha.pages.pageFactory.appVWO;

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

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    @FindBy(id = "login-username")
    private WebElement username;

    /*
        @FindAll annotation uses an "OR condition" requiring element to match any criteria

        @FindAll(
                {
                        @FindBy(how = How.ID, using = "login-username"),
                        @FindBy(name = "username")
                }
        )
        private WebElement username;
    */

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(id = "js-notification-box-msg")
    private WebElement errorMessage;

    //Step 2 : These are Page Actions i.e. Kind of Behaviours or Instance Methods or Member Methods
    public String loginToVWOLoginInvalidCreds() {

        openVWOUrl();

        WaitHelpers.waitImplicitWait(driver,5);

        enterInput(username, PropertiesReader.readKey("invalid_username"));
        enterInput(password, PropertiesReader.readKey("invalid_password"));
        clickElement(signButton);

        WaitHelpers.checkVisibilityOfAndTextToBePresentInElement(driver, errorMessage);

        return getText(errorMessage);

    }

    public void loginToVWOLoginValidCreds() {

        openVWOUrl();

        WaitHelpers.waitImplicitWait(driver,5);

        enterInput(username, PropertiesReader.readKey("username"));
        enterInput(password, PropertiesReader.readKey("password"));
        clickElement(signButton);

    }

}
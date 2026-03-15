package com.avinashsinha.pages.pageObjectModel.orangeHRM;

import com.avinashsinha.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.avinashsinha.utils.WaitHelpers.waitJVM;

//This is Page Class
public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By USERNAME = By.xpath("//input[@placeholder='Username']");
    private static final By PASSWORD = By.xpath("//input[@placeholder='Password']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[normalize-space()='Login']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void loginToOrangeHRMCreds(String usr, String pwd) {

        openOrangeHRMUrl();

        waitJVM(5000);

        enterInput(USERNAME, usr);
        enterInput(PASSWORD, pwd);
        clickElement(SUBMIT_BUTTON);

        waitJVM(5000);

    }

}
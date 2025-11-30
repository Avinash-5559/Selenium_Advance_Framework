package com.avinashsinha.pages.pageObjectModel.orangeHRM;

import com.avinashsinha.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.avinashsinha.utils.WaitHelpers.waitJVM;

//This is Page Class
public class EmployeeListHomePage extends CommonToAllPage {

    WebDriver driver;

    public EmployeeListHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    By userNameOnDashboard = By.xpath("//h6[normalize-space()='PIM']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviours or Instance Methods or Member Methods
    public String loggedInUserName() {

        waitJVM(5000);
        return getText(userNameOnDashboard);

    }

}
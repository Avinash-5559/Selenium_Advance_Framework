package com.avinashsinha.pages.pageObjectModel.appVWO.normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By userNameOnDashborad = By.cssSelector("[data-qa='lufexuloga']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public String loggedInUserName() {
        return driver.findElement(userNameOnDashborad).getText();
    }
}
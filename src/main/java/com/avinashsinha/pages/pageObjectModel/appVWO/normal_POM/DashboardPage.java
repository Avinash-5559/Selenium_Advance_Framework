package com.avinashsinha.pages.pageObjectModel.appVWO.normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators
    private By userNameOnDashborad = By.cssSelector("[data-qa='lufexuloga']");

    //Step 2 : These are Page Actions
    public String loggedInUserName() {
        return driver.findElement(userNameOnDashborad).getText();
    }
}
package com.avinashsinha.pages.pageObjectModel.appVWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameOnDashborad = By.cssSelector("[data-qa='lufexuloga']");

    public String loggedInUserName() {
        return driver.findElement(userNameOnDashborad).getText();
    }
}
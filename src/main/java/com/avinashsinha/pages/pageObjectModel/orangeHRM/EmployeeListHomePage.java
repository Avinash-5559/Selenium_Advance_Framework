package com.avinashsinha.pages.pageObjectModel.orangeHRM;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.WaitHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class EmployeeListHomePage extends CommonToAllPage {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeListHomePage.class);

    WebDriver driver;

    public EmployeeListHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private static final By DASHBOARD_PAGE_TITLE = By.xpath("//h6[normalize-space()='Dashboard']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public String loggedInUserName() {

        WaitHelpers.presenceOfElement(driver, DASHBOARD_PAGE_TITLE);
        String titleText = getText(DASHBOARD_PAGE_TITLE);
        LOGGER.info("Dashboard Page Title: {}", titleText);

        return titleText;

    }

}
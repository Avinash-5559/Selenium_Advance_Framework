package com.avinashsinha.pages.pageFactory.appVWO;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This is Page Class
public class DashboardPage_PF extends CommonToAllPage {

    WebDriver driver;

    public DashboardPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    @FindBy(css="[data-qa='lufexuloga']")
    private WebElement userNameOnDashboard;

    //Step 2 : These are Page Actions i.e. Kind of Behaviours or Instance Methods or Member Methods
    public String loggedInUserName() {
        WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
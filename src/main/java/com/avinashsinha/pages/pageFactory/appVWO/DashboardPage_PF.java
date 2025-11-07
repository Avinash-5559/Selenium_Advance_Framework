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

    //Step 1 : These are Page Locators
    @FindBy(css="[data-qa='lufexuloga']")
    private WebElement userNameOnDashboard;

    //Step 2 : These are Page Actions
    public String loggedInUserName() {
        WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
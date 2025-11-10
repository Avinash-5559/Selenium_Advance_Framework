package com.avinashsinha.pages.pageFactory.orangeHRM;

import com.avinashsinha.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.avinashsinha.utils.WaitHelpers.waitJVM;

//This is Page Class
public class EmployeeListHomePage_PF extends CommonToAllPage {

    WebDriver driver;

    public EmployeeListHomePage_PF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Step 1 : These are Page Locators
    @FindBy(xpath = "//h6[normalize-space()='PIM']")
    private WebElement userNameOnDashboard;

    //Step 2 : These are Page Actions
    public String loggedInUserName() {

        waitJVM(5000);
        return getText(userNameOnDashboard);

    }

}
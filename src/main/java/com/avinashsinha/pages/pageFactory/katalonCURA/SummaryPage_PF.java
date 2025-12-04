package com.avinashsinha.pages.pageFactory.katalonCURA;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This is Page Class
public class SummaryPage_PF extends CommonToAllPage {

    WebDriver driver;

    public SummaryPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    @FindBy(xpath = "//p[@id='comment']")
    private WebElement commentText;

    @FindBy(xpath = "//i[@class='fa fa-bars']")
    private WebElement sideBar;

    @FindBy(linkText = "Logout")
    private WebElement logout;

    //Step 2 : These are Page Actions i.e. Kind of Behaviours or Instance Methods or Member Methods
    public void checkAllDetailsOnSummaryPage() {

        WaitHelpers.urlContains(driver, PropertiesReader.readKey("katalon_summaryURL"));

        if (getText(commentText).equals(PropertiesReader.readKey("katalon_comment"))) {

            clickElement(sideBar);
            clickElement(logout);

            WaitHelpers.urlContains(driver, PropertiesReader.readKey("katalon_makeAppointmentURL"));

            System.out.println("\nTest Case is Passed\n");

        } else {

            System.out.println("\nTest Case is Failed");
        }

    }

}

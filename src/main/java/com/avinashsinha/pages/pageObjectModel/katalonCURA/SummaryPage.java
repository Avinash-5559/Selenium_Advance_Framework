package com.avinashsinha.pages.pageObjectModel.katalonCURA;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class SummaryPage extends CommonToAllPage {

    WebDriver driver;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By confirmationText = By.xpath("//h2[normalize-space()='Appointment Confirmation']");
    private By commentText = By.xpath("//p[@id='comment']");
    private By sideBar = By.xpath("//i[@class='fa fa-bars']");
    private By logout = By.linkText("Logout");

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
package com.avinashsinha.pages.pageFactory.katalonCURA;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This is Page Class
public class BookingPage_PF extends CommonToAllPage {

    WebDriver driver;

    public BookingPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    @FindBy(xpath = "//input[@id='chk_hospotal_readmission']")
    private WebElement checkBox;

    @FindBy(xpath = "//input[@id='radio_program_medicaid']")
    private WebElement radioButton;

    @FindBy(xpath = "//input[@id='txt_visit_date']")
    private WebElement calendar;

    @FindBy(xpath = "//div[contains(@class,'datepicker-dropdown')]")
    private WebElement openCalendar;

    @FindBy(xpath = "(//th[@class='datepicker-switch'])[1]")
    private WebElement currentMonth;

    @FindBy(xpath = "(//th[@class='next'])[1]")
    private WebElement next;

    @FindBy(xpath = "(//td[@class='day'])[26]")
    private WebElement day;

    @FindBy(xpath = "//textarea[@id='txt_comment']")
    private WebElement comment;

    @FindBy(xpath = "//button[@id='btn-book-appointment']")
    private WebElement bookAppointment;

    //Step 2 : These are Page Actions i.e. Kind of Behaviours or Instance Methods or Member Methods
    public void fillAllDetailsOnBookingPage() {

        WaitHelpers.urlContains(driver, PropertiesReader.readKey("katalon_bookingURL"));

        clickElement(checkBox);
        clickElement(radioButton);
        clickElement(calendar);

        WaitHelpers.visibilityOfElement(openCalendar);

        while (!getText(currentMonth).equals("July 2026")) {

            clickElement(next);
            getText(currentMonth);

        }

        clickElement(day);

        enterInput(comment, PropertiesReader.readKey("katalon_comment"));
        clickElement(bookAppointment);

    }
}

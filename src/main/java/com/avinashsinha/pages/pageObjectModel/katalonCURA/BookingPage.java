package com.avinashsinha.pages.pageObjectModel.katalonCURA;

import com.avinashsinha.base.CommonToAllPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class BookingPage extends CommonToAllPage {

    WebDriver driver;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By checkBox = By.xpath("//input[@id='chk_hospotal_readmission']");
    private By radioButton = By.xpath("//input[@id='radio_program_medicaid']");
    private By calendar = By.xpath("//input[@id='txt_visit_date']");
    private By openCalendar = By.xpath("//div[contains(@class,'datepicker-dropdown')]");
    private By currentMonth = By.xpath("(//th[@class='datepicker-switch'])[1]");
    private By next = By.xpath("(//th[@class='next'])[1]");
    private By day = By.xpath("(//td[@class='day'])[26]");
    private By comment = By.xpath("//textarea[@id='txt_comment']");
    private By bookAppointment = By.xpath("//button[@id='btn-book-appointment']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviours or Instance Methods or Member Methods
    public void fillAllDetailsOnBookingPage() {

        WaitHelpers.urlContains(driver, PropertiesReader.readKey("katalon_bookingURL"));

        clickElement(checkBox);
        clickElement(radioButton);
        clickElement(calendar);

        WaitHelpers.presenceOfElement(driver, openCalendar);

        while (!getText(currentMonth).equals("July 2026")) {

            clickElement(next);
            getText(currentMonth);

        }

        clickElement(day);

        enterInput(comment, PropertiesReader.readKey("katalon_comment"));
        clickElement(bookAppointment);

    }

}

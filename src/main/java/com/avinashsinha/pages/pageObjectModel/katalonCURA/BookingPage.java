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
    private static final By CHECK_BOX = By.xpath("//input[@id='chk_hospotal_readmission']");
    private static final By RADIO_BUTTON = By.xpath("//input[@id='radio_program_medicaid']");
    private static final By CALENDAR = By.xpath("//input[@id='txt_visit_date']");
    private static final By OPEN_CALENDAR = By.xpath("//div[contains(@class,'datepicker-dropdown')]");
    private static final By CURRENT_MONTH = By.xpath("(//th[@class='datepicker-switch'])[1]");
    private static final By NEXT = By.xpath("(//th[@class='next'])[1]");
    private static final By DAY = By.xpath("(//td[@class='day'])[26]");
    private static final By COMMENT = By.xpath("//textarea[@id='txt_comment']");
    private static final By BOOK_APPOINTMENT = By.xpath("//button[@id='btn-book-appointment']");

    //Step 2 : These are Page Actions i.e. Kind of Behaviors or Instance Methods or Member Methods
    public void fillAllDetailsOnBookingPage() {

        WaitHelpers.urlContains(driver, PropertiesReader.readKey("katalon_bookingURL"));

        clickElement(CHECK_BOX);
        clickElement(RADIO_BUTTON);
        clickElement(CALENDAR);

        WaitHelpers.presenceOfElement(driver, OPEN_CALENDAR);

        while (!getText(CURRENT_MONTH).equals("July 2026")) {

            clickElement(NEXT);
            getText(CURRENT_MONTH);

        }

        clickElement(DAY);

        enterInput(COMMENT, PropertiesReader.readKey("katalon_comment"));
        clickElement(BOOK_APPOINTMENT);

    }

}

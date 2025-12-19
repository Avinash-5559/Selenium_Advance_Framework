package com.avinashsinha.tests.pom.katalonCURA;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.pageObjectModel.katalonCURA.BookingPage;
import com.avinashsinha.pages.pageObjectModel.katalonCURA.LoginPage;
import com.avinashsinha.pages.pageObjectModel.katalonCURA.MakeAppointmentPage;
import com.avinashsinha.pages.pageObjectModel.katalonCURA.SummaryPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestKatalonCURALoginPage_01 extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestKatalonCURALoginPage_01.class);

    @Test
    @Description("TC#1 : Verify that Booking the Appointment and redirect to the Summary Page")
    @Owner("Avinash Sinha")
    public void test_KatalonCURA() {

        logger.info("Starting the TestCases Page Object Model");

        MakeAppointmentPage makeAppointmentKatalonCURA = new MakeAppointmentPage(getDriver());
        makeAppointmentKatalonCURA.clickToMakeAppointmentBtn();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginToKatalonCURACreds();

        BookingPage bookingPage = new BookingPage(getDriver());
        bookingPage.fillAllDetailsOnBookingPage();

        SummaryPage summaryPage = new SummaryPage(getDriver());
        summaryPage.checkAllDetailsOnSummaryPage();

        logger.info("Finishing the TestCases Page Object Model");

    }

}
package com.avinashsinha.tests.pageFactory.katalonCURA;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import com.avinashsinha.listeners.ScreenshotListeners;
import com.avinashsinha.pages.pageFactory.katalonCURA.BookingPage_PF;
import com.avinashsinha.pages.pageFactory.katalonCURA.SummaryPage_PF;
import com.avinashsinha.pages.pageFactory.katalonCURA.LoginPage_PF;
import com.avinashsinha.pages.pageFactory.katalonCURA.MakeAppointmentPage_PF;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Listeners(ScreenshotListeners.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestKatalonCURALoginPage_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestKatalonCURALoginPage_PF.class);

    @Test
    @Description("TC#1 : Verify that Booking the Appointment and redirect to the Summary Page")
    @Owner("Avinash Sinha")
    public void test_KatalonCURA() {

        logger.info("Starting the TestCases Page Factory");

        MakeAppointmentPage_PF makeAppointmentKatalonCURA = new MakeAppointmentPage_PF(getDriver());
        makeAppointmentKatalonCURA.clickToMakeAppointmentBtn();

        LoginPage_PF loginPage = new LoginPage_PF(getDriver());
        loginPage.loginToKatalonCURACreds();

        BookingPage_PF bookingPage = new BookingPage_PF(getDriver());
        bookingPage.fillAllDetailsOnBookingPage();

        SummaryPage_PF summaryPage = new SummaryPage_PF(getDriver());
        summaryPage.checkAllDetailsOnSummaryPage();

        logger.info("Finishing the TestCases Page Factory");

    }

}
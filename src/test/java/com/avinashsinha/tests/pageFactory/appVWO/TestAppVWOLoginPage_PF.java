package com.avinashsinha.tests.pageFactory.appVWO;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.driver.DriverManager;
import com.avinashsinha.pages.pageFactory.appVWO.LoginPage_PF;
import com.avinashsinha.pages.pageFactory.appVWO.DashboardPage_PF;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAppVWOLoginPage_PF extends CommonToAllTest {

    private static final Logger logger= LogManager.getLogger(TestAppVWOLoginPage_PF.class);

    @Test
    @Description("TC#1 : Verify that with Invalid Username and Password, get error message on the Login Page")
    @Owner("Avinash Sinha")
    public void test_VWOLogin_Negative() {

        logger.info("Starting the TestCases Page Factory");

        //Step 2. Page Class Code (POM Code)
        LoginPage_PF loginPage = new LoginPage_PF(DriverManager.getDriver());
        String errorMsg = loginPage.loginToVWOLoginInvalidCreds();

        logger.info("Finishing the TestCases Page Factory");

        //Step 3. Assertions
        assertThat(errorMsg).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(errorMsg, PropertiesReader.readKey("error_message"));

    }

    @Test
    @Description("TC#2 : Verify that with Valid Username and Password, redirect to the Dashboard Page")
    @Owner("Avinash Sinha")
    public void test_VWOLogin_Positive() {

        logger.info("Starting the TestCases Page Factory");

        //Step 2. Page Class Code (POM Code)
        LoginPage_PF loginPage = new LoginPage_PF(DriverManager.getDriver());
        loginPage.loginToVWOLoginValidCreds();

        DashboardPage_PF dashboardPage = new DashboardPage_PF(DriverManager.getDriver());
        String userNameLoggedIn = dashboardPage.loggedInUserName();

        logger.isErrorEnabled();

        //Step 3. Assertions
        assertThat(userNameLoggedIn).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(userNameLoggedIn, PropertiesReader.readKey("expected_username"));

    }
}
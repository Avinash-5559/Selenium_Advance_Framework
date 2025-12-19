package com.avinashsinha.tests.pom.appVWO;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.listeners.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestAppVWOLoginPage_RetryListeners extends CommonToAllTest {

    private static final Logger logger= LogManager.getLogger(TestAppVWOLoginPage_RetryListeners.class);

    @Test
    @Description("TC#1: Verify that with Invalid Username and Password, get error message on the Login Page")
    @Owner("Avinash Sinha")
    public void testCase_Fail() {

        getDriver().get("https://app.vwo.com");

        logger.info("Starting the Testcases Page Object Model");

        Assert.assertTrue(false);

    }

    @Test
    @Description("TC#1: Verify that with Invalid Username and Password, get error message on the Login Page")
    @Owner("Avinash Sinha")
    public void testCase_Pass() {

        getDriver().get("https://app.vwo.com");

        logger.info("Starting the Testcases Page Object Model");

        Assert.assertTrue(true);

    }

}
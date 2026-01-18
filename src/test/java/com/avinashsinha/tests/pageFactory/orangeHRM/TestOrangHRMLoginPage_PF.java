package com.avinashsinha.tests.pageFactory.orangeHRM;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.pages.pageFactory.orangeHRM.LoginPage_PF;
import com.avinashsinha.pages.pageFactory.orangeHRM.EmployeeListHomePage_PF;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class TestOrangHRMLoginPage_PF extends CommonToAllTest {

    private static final Logger logger= LogManager.getLogger(TestOrangHRMLoginPage_PF.class);

    @Test
    @Description("TC#1 : Verify that with Username and Password, redirect to the Dashboard Page")
    @Owner("Avinash Sinha")
    public void test_OrangeHRM() {

        logger.info("Starting the TestCases Page Factory");

        LoginPage_PF loginOrangeHRMPage = new LoginPage_PF(getDriver());
        loginOrangeHRMPage.loginToOrangeHRMCreds();

        EmployeeListHomePage_PF employeeListHomePage = new EmployeeListHomePage_PF(getDriver());

        String loggedInUserName = employeeListHomePage.loggedInUserName();

        logger.info("Finishing the TestCases Page Factory");

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName, PropertiesReader.readKey("ohr_expected_username"));

    }
}
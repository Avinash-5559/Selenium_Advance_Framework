package com.avinashsinha.tests.pom.orangeHRM;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.pages.pageObjectModel.orangeHRM.EmployeeListHomePage;
import com.avinashsinha.pages.pageObjectModel.orangeHRM.LoginPage;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.avinashsinha.driver.DriverManager.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class TestOrangeHRMLoginPage_01 extends CommonToAllTest {

    private static final Logger logger= LogManager.getLogger(TestOrangeHRMLoginPage_01.class);

    @Test
    @Description("TC#1 : Verify that with Username and Password, redirect to the Dashboard Page")
    @Owner("Avinash Sinha")
    public void test_OrangeHRM() {

        logger.info("Starting the TestCases Page Object Model");

        LoginPage loginOrangeHRMPage = new LoginPage(getDriver());
        loginOrangeHRMPage.loginToOrangeHRMCreds(PropertiesReader.readKey("ohr_username"), PropertiesReader.readKey("ohr_password"));

        EmployeeListHomePage employeeListHomePage = new EmployeeListHomePage(getDriver());

        String loggedInUserName = employeeListHomePage.loggedInUserName();

        logger.info("Finishing the TestCases Page Object Model");

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName, PropertiesReader.readKey("ohr_expected_username"));

    }
}
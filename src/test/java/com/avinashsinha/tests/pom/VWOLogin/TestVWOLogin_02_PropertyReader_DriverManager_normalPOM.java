package com.avinashsinha.tests.pom.VWOLogin;

import com.avinashsinha.driver.DriverManager;
import com.avinashsinha.pages.pageObjectModel.appVWO.normal_POM.DashboardPage;
import com.avinashsinha.pages.pageObjectModel.appVWO.normal_POM.LoginPage;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_02_PropertyReader_DriverManager_normalPOM {

    @Test
    @Description("TC#1 : Verify that with Invalid Username and Password, get error message on the Login Page")
    @Owner("Avinash Sinha")
    public void test_VWOLogin_Negative() {

        //Step 1. Driver Manager Code
        DriverManager.openBrowser();

        //Step 2. Page Class Code (POM Code)
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String errorMsg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        //Step 3. Assertions
        assertThat(errorMsg).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(errorMsg, PropertiesReader.readKey("error_message"));

        DriverManager.closeBrowser();
        //DriverManager.getDriver().quit();

    }

    @Test
    @Description("TC#2 : Verify that with Valid Username and Password, redirect to the Dashboard Page")
    @Owner("Avinash Sinha")
    public void test_VWOLogin_Positive() {

        //Step 1. Driver Manager Code
        DriverManager.openBrowser();

        //Step 2. Page Class Code (POM Code)
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String userNameLoggedIn = dashboardPage.loggedInUserName();

        //Step 3. Assertions
        assertThat(userNameLoggedIn).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(userNameLoggedIn, PropertiesReader.readKey("expected_username"));

        DriverManager.closeBrowser();
    }
}
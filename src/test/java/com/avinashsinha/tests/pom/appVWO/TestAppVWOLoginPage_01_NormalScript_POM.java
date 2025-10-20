package com.avinashsinha.tests.pom.appVWO;

import com.avinashsinha.pages.pageObjectModel.appVWO.normal_POM.DashboardPage;
import com.avinashsinha.pages.pageObjectModel.appVWO.normal_POM.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestAppVWOLoginPage_01_NormalScript_POM {

    @Test
    @Description("TC#1 : Verify that with Invalid Username and Password, get error message on the Login Page")
    @Owner("Avinash Sinha")
    public void test_VWOLogin_Negative() {

        //Step 1. Driver Manager Code
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //Step 2. Page Class Code (POM Code)
        LoginPage loginPage = new LoginPage(driver);
        String errorMsg = loginPage.loginToVWOLoginInvalidCreds("admin@gmail.com", "123456");

        //Step 3. Assertions
        assertThat(errorMsg).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(errorMsg, "Your email, password, IP address or location did not match");

        driver.quit();
    }

    @Test
    @Description("TC#2 : Verify that with Valid Username and Password, redirect to the Dashboard Page")
    @Owner("Avinash Sinha")
    public void test_VWOLogin_Positive() {

        //Step 1. Driver Manager Code
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--inprivate");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //Step 2. Page Class Code (POM Code)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOLoginValidCreds("contact+aug@thetestingacademy.com", "TtxkgQ!s$rJBk85");

        DashboardPage dashboardPage = new DashboardPage(driver);
        String userNameLoggedIn = dashboardPage.loggedInUserName();

        //Step 3. Assertions
        assertThat(userNameLoggedIn).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(userNameLoggedIn, "Aman");

        driver.quit();
    }

}
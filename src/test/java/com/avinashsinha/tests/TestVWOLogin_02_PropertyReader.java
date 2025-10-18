package com.avinashsinha.tests;

import com.avinashsinha.driver.DriverManager;
import com.avinashsinha.pages.pageObjectModel.appVWO.LoginPage;
import com.avinashsinha.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_02_PropertyReader {

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
                //getDriver().quit();

    }
}
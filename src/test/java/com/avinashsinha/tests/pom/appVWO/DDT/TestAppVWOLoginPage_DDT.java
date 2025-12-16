package com.avinashsinha.tests.pom.appVWO.DDT;

import com.avinashsinha.base.CommonToAllTest;
import com.avinashsinha.pages.pageObjectModel.appVWO.improved_POM.LoginPage;
import com.avinashsinha.utils.PropertiesReader;
import com.avinashsinha.utils.UtilExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.avinashsinha.driver.DriverManager.getDriver;

public class TestAppVWOLoginPage_DDT extends CommonToAllTest {

    @Test(dataProvider = "getData")
    public void test_VWOLogin(String email, String password) {

        System.out.println(" | " + email + " | " + password + " | ");

        //Here we will write the code to Login

        getDriver().get(PropertiesReader.readKey("url"));

        WebDriverWait wait_title = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait_title.until(ExpectedConditions.titleContains(PropertiesReader.readKey("current_title")));
        String title = getDriver().getTitle();

        Assert.assertEquals(title, PropertiesReader.readKey("current_title"));

        WebDriverWait wait_URL = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait_URL.until(ExpectedConditions.urlContains(PropertiesReader.readKey("current_url")));
        String url = getDriver().getCurrentUrl();

        Assert.assertEquals(url, PropertiesReader.readKey("current_url"));

        LoginPage loginPage = new LoginPage(getDriver());
        String errorMessage = loginPage.loginToVWOLoginInvalidCreds(email, password);

        WebDriverWait wait_error = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait_error.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));

        Assert.assertEquals(errorMessage, PropertiesReader.readKey("error_message"));

    }

    @DataProvider
    public Object[][] getData() {
        /*
            - Read the Data from the Excel File
            - Give them in the 2D Array
        */

        return UtilExcel.getTestDataFromExcel("Sheet1");

    }

}
package com.avinashsinha.pages.pageFactory.katalonCURA;

import com.avinashsinha.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This is Page Class
public class MakeAppointmentPage_PF extends CommonToAllPage {

    WebDriver driver;

    public MakeAppointmentPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Step 1 : These are Page Locators
    @FindBy(id = "btn-make-appointment")
    private WebElement makeAppointment;

    //Step 2 : These are Page Actions
    public void clickToMakeAppointmentBtn() {

        openKatalonCURAUrl();

        clickElement(makeAppointment);

    }

}
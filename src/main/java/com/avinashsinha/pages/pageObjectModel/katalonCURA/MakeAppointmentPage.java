package com.avinashsinha.pages.pageObjectModel.katalonCURA;

import com.avinashsinha.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is Page Class
public class MakeAppointmentPage extends CommonToAllPage {

    WebDriver driver;

    public MakeAppointmentPage(WebDriver driver){
        this.driver=driver;
    }

    //Step 1 : These are Page Locators
    private By makeAppointment= By.id("btn-make-appointment");

    //Step 2 : These are Page Actions
    public void clickToMakeAppointmentBtn(){

        openKatalonCURAUrl();

        clickElement(makeAppointment);

    }

}
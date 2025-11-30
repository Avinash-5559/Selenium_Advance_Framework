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

    //Step 1 : These are Page Locators i.e. Kind of Attributes or Instance Variable or Member Variable
    private By makeAppointment= By.id("btn-make-appointment");

    //Step 2 : These are Page Actions i.e. Kind of Behaviours or Instance Methods or Member Methods
    public void clickToMakeAppointmentBtn(){

        openKatalonCURAUrl();

        clickElement(makeAppointment);

    }

}
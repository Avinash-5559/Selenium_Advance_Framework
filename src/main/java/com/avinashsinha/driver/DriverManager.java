package com.avinashsinha.driver;

import com.avinashsinha.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    //When we want to Start the Browser
    public static void openBrowser() {

        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        switch (browser) {

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--inprivate");
                //edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(" --incognito");
                //chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private-window");
                //firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                break;

            default:
                System.out.println("Browser Not Supported!!!");

        }

    }

    //When we want to Close the Browser
    public static void closeBrowser() {

        if (getDriver() != null) {
            driver.quit();
            driver = null;
        }
    }

}
package com.ait.tests.registration.core;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import registration.core.ApplicationManager;


public class TestBase {


    protected static ApplicationManager app=new ApplicationManager
            (System.getProperty("browser", Browser.CHROME.browserName()));

    //@BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

    //@AfterMethod(enabled=true)
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }



}

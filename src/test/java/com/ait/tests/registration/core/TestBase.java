package com.ait.tests.registration.core;

import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import registration.core.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {

    Logger logger =LoggerFactory.getLogger(TestBase.class);


    protected static ApplicationManager app=new ApplicationManager
            (System.getProperty("browser","chrome"));

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

    @BeforeMethod
    public void startTest(Method method, Object[] p){
        logger.info("Start test {} with data: {}", method.getName(), Arrays.asList(p));
    }

    @AfterMethod(alwaysRun=true)
    public void stopTest(ITestResult result){

        if (result.isSuccess()){
            logger.info("PASSED" + result.getMethod().getMethodName());
        }else {
            logger.error("FAILED" + result.getMethod().getMethodName() + "Screenshot" +
                    app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("=================");
    }
}

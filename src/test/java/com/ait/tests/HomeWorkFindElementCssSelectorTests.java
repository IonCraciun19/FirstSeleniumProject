package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWorkFindElementCssSelectorTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void findElementCssSelector(){
        //id->CssSelector
        WebElement firstIdCssSelector = driver.findElement(By.cssSelector("#dialog-notifications-success"));
        System.out.println(firstIdCssSelector.getText());
        WebElement secondIdCssSelector = driver.findElement(By.cssSelector("#bar-notification"));
        System.out.println(secondIdCssSelector.getText());
        //tadName->CssSelector
        WebElement firstTagNameCssSelector = driver.findElement(By.cssSelector("ul"));
        System.out.println(firstTagNameCssSelector.getText());
        WebElement secondTagNameCssSelector = driver.findElement(By.cssSelector("li"));
        System.out.println(secondTagNameCssSelector.getText());
        //className->CssSelector
        WebElement firstClassNameCssSelector = driver.findElement(By.cssSelector(".leftside-3"));
        System.out.println(firstClassNameCssSelector.getText());
        WebElement secondClassNameCssSelector = driver.findElement(By.cssSelector(".view-all"));
        System.out.println(secondClassNameCssSelector.getText());
        //navLink->CssSelector
        WebElement firstNavLink = driver.findElement(By.cssSelector(".ico-login"));
        System.out.println(firstNavLink.getText());
        WebElement secondNavLink = driver.findElement(By.cssSelector(".cart-label"));
        System.out.println(secondNavLink.getText());
        //nth-child
        WebElement firstNthChild = driver.findElement(By.cssSelector(".header-links:nth-child(1)"));
        System.out.println(firstNthChild.getText());
        //start
        WebElement startClassCss = driver.findElement(By.cssSelector("[class^='top']"));
        System.out.println(startClassCss.getText());
        //end
        WebElement endClassCss =driver.findElement(By.cssSelector("[class$='gle']"));
        System.out.println(endClassCss.getText());
        //contains
        WebElement containsClassCss = driver.findElement(By.cssSelector("[class*='nu']"));
        System.out.println(containsClassCss.getText());
    }
}

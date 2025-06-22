package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWorkFindElementTests {

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
    public void findElementByLocators(){
        WebElement firstId = driver.findElement(By.id("dialog-notifications-success"));
        System.out.println(firstId.getText());
        WebElement secondId = driver.findElement(By.id("bar-notification"));
        System.out.println(secondId.getText());
        List<WebElement> firstTagName = driver.findElements(By.tagName("ul"));
        System.out.println(firstTagName.size());
        List<WebElement> secondTagName = driver.findElements(By.tagName("li"));
        System.out.println(secondTagName.size());
        WebElement searchClassName1 = driver.findElement(By.className("leftside-3"));
        System.out.println(searchClassName1.getText());
        WebElement searchClassName2 = driver.findElement(By.className("view-all"));
        System.out.println(searchClassName2.getText());
        WebElement searchLinkText1 = driver.findElement(By.linkText("COMPUTERS"));
        System.out.println(searchLinkText1.getText());
        WebElement searchLinkText2 = driver.findElement(By.linkText("JEWELRY"));
        System.out.println(searchLinkText2.getText());
        WebElement searchParLinkText1 = driver.findElement(By.partialLinkText("AR"));
        System.out.println(searchParLinkText1.getText());
        WebElement searchParLinkText2 = driver.findElement(By.partialLinkText("IF"));
        System.out.println(searchParLinkText2.getText());
    }
}

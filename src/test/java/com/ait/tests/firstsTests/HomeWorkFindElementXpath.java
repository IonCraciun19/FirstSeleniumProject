package com.ait.tests.firstsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWorkFindElementXpath {

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
    public void findElementXpath(){
        //id-> //tag[@id ='value']
        WebElement id1 = driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
        System.out.println(id1.getText());
        WebElement id2 = driver.findElement(By.xpath("//*[@id='bar-notification']"));
        System.out.println(id2.getText());
        //tagName->//tag
        WebElement tag1 = driver.findElement(By.xpath("//ul"));
        System.out.println(tag1.getText());
        WebElement tag2 = driver.findElement(By.xpath("//li"));
        System.out.println(tag2.getText());
        //className -> //tag[@class='value']
        WebElement className1 = driver.findElement(By.xpath("//*[@class='leftside-3']"));
        System.out.println(className1.getText());
        WebElement className2 = driver.findElement(By.xpath("//*[@class='view-all']"));
        System.out.println(className2.getText());
        //navLink -> *[@href='/navLink'
        WebElement navLink1 = driver.findElement(By.xpath("//*[@href='/login']"));
        System.out.println(navLink1.getText());
        WebElement navLink2 =driver.findElement(By.xpath("//*[@href='/cart']"));
        System.out.println(navLink2.getText());
        //nth-child ->//a[x]
        WebElement nthChild = driver.findElement(By.xpath("//a[2]"));
        System.out.println(nthChild.getText());
        //start -> //tag[starts-with(@attr,'startsValue')]
        WebElement startXpath = driver.findElement(By.xpath("//*[starts-with(@class,'top')]"));
        System.out.println(startXpath.getText());
        //contains ->//tag[contains(text(),'text')]
        WebElement contains1 = driver.findElement(By.xpath("//*[contains(.,'Welcome')]"));
        System.out.println(contains1.getText());
    }

}

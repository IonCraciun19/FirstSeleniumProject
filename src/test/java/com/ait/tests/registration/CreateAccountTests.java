package com.ait.tests.registration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class CreateAccountTests extends TestBase{

    String uniqueId =UUID.randomUUID().toString().substring(0,8);
    String email = "testUser_" + uniqueId + "@example.com";
    String password = "PasswordUser$" + uniqueId + "1234";
    String firstName = "FirstName" + uniqueId;
    String lastName = "LastName" + uniqueId;


    @Test
    public void createAccount(){
        click(By.cssSelector("[href='/register']"));
        type(By.name("FirstName"),firstName);
        type(By.name("LastName"),lastName);
        type(By.name("Email"),email);
        type(By.name("Password"),password);
        type(By.name("ConfirmPassword"),password);
        click(By.name("register-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
   }

}

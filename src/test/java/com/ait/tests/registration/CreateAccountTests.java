package com.ait.tests.registration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void createAccount(){
        click(By.cssSelector("[href='/register']"));
        type(By.name("FirstName"),"Grenck");
        type(By.name("LastName"),"Iovan");
        type(By.name("Email"),"igreck3@mail.com");
        type(By.name("Password"),"Igreck$1222");
        type(By.name("ConfirmPassword"),"Igreck$1222");
        click(By.name("register-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }

}

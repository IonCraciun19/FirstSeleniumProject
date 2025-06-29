package com.ait.tests.registration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void createAccount(){
        click(By.cssSelector("[href='/register']"));
        type(By.name("FirstName"),"Greck");
        type(By.name("LastName"),"Ivan");
        type(By.name("Email"),"igreck2@mail.com");
        type(By.name("Password"),"Igreck$1122");
        type(By.name("ConfirmPassword"),"Igreck$1122");
        click(By.name("register-button"));
    }

}

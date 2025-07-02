package com.ait.tests.registration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void LoginRegisteredUserTest(){
        clickOnLoginLink();
        fillLoginForm(new RegisteredUser().setEmail("igreck4@mail.com")
                .setPassword("Password$123"));
        clickOnLoginButton();
        Assert.assertTrue(isLogOutLinkPresent());
    }
}

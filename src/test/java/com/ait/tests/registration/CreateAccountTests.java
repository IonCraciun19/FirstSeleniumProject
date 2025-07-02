package com.ait.tests.registration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{


    @Test
    public void newUserRegistrationTest(){
        clickOnRegistrationLink();
        fillRegisterForm(new User().setFirstName("Ilia")
                .setLastName("Grenck")
                .setEmail("igreck6@mail.com")
                .setPassword("Password$12345"));
        clickOnRegisterButton();
        Assert.assertTrue(isLogOutLinkPresent());
    }


}

package com.ait.tests.registration.tests;

import com.ait.tests.registration.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.models.User;

public class CreateAccountPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getRegisteredUser().isLoginLinkPresent()) {
            app.getUser().clickOnRegistrationLink();
        } else {
            app.getRegisteredUser().clickOnLogOutLink();
            app.getUser().clickOnRegistrationLink();
        }
    }


    @Test
    public void newUserRegistrationTest() {
        String randomEmail="igreck" + System.currentTimeMillis() + "@qatest.com";
        System.out.println(randomEmail);
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName("Ilia")
                .setLastName("Grenck")
                .setEmail(randomEmail)
                .setPassword("Password$156"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    @AfterMethod
    public void postcondition() {
        app.getRegisteredUser().clickOnLogOutLink();
    }


}

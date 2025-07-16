package com.ait.tests.registration.tests;

import com.ait.tests.registration.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.models.RegisteredUser;

public class LoginPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
    }

    @Test
    public void LoginRegisteredUserTest() {
        app.getRegisteredUser().clickOnLoginLink();
        app.getRegisteredUser().fillLoginForm(new RegisteredUser().setEmail("igreck1@mail.com")
                .setPassword("Igreck$123"));
        app.getRegisteredUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    @AfterMethod
    public void postcondition() {
        app.getRegisteredUser().clickOnLogOutLink();
    }

}

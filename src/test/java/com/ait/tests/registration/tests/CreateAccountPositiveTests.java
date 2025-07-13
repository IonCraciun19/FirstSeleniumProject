package com.ait.tests.registration.tests;

import com.ait.tests.registration.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.models.User;
import registration.utils.MyDataProviders;

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
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName("Ilia")
                .setLastName("Grenck")
                .setEmail("igreck8988@qatest.com")
                .setPassword("Password$9976"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    @AfterMethod
    public void postcondition() {
        app.getRegisteredUser().clickOnLogOutLink();
    }

    @Test(dataProvider = "createUser", dataProviderClass= MyDataProviders.class)
    public void createUserPositiveFromDataProviderTest (String firstName, String lastName,
                                                        String email, String password){
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(new User().setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    @Test(dataProvider =  "createNewUserFromCsv", dataProviderClass = MyDataProviders.class)
    public void createUserPositiveFromDataProviderWithCsvTest(User user){
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }
}

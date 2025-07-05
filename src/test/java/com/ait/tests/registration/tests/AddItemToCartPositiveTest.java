package com.ait.tests.registration.tests;

import com.ait.tests.registration.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import registration.data.UserData;
import registration.models.RegisteredUser;

public class AddItemToCartPositiveTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.getRegisteredUser().login(UserData.email, UserData.password);
    }


    @Test
    public void buyProduct() {
        app.getAddItemToCart().addToCard();
        app.getAddItemToCart().clickOnShoppingCart();
        Assert.assertTrue(app.getAddItemToCart().isItemAddedByText("14.1-inch Laptop"));
    }
}

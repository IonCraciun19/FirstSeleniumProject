package com.ait.tests.registration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCartTest extends TestBase {

    @Test
    public void buyProduct() {
        clickOnProductLink();
        addToCard();
        clickOnShoppingCart();
        Assert.assertTrue(isItemAddedByText());
    }
}

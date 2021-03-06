package com.tests;

import com.base.TestBase;
import com.pages.*;
import com.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ProductPageTest extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;

    public ProductPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        initialization();
        loginPage=new LoginPage();
        productsPage= loginPage.loginToStandardUser();
    }

    @Test(priority = 1)
    public void verifyAddProductToCart() throws InterruptedException {
        productsPage.tapOnProductImage();
        productsPage.tapOnAddToCartButton();
        Assert.assertTrue(productsPage.verifyThatProductHasBeenAddedToCart("REMOVE"), "Product is not added to cart");

    }

    @Test(priority = 2)
    public void verifyRemoveProductFromCart() throws InterruptedException {
        productsPage.tapOnProductName("Sauce Labs Bike Light");
        productsPage.tapOnAddToCartButton();
        productsPage.tapOnRemoveButton();
        Assert.assertTrue(productsPage.verifyThatProductHasBeenRemovedFromCart("ADD TO CART"), "Product is not removed from cart");
    }

    @Test(priority = 3)
    public void verifyTapOnProductImage() throws InterruptedException {
        productsPage.tapOnProductImage();
        productsPage.verifyProductDetailsPage();
    }



    @AfterMethod
    public void tearDown(){


    }
}

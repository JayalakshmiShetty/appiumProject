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
        productsPage.verifyThatProductHasBeenAddedToCart("ADD TO CART");

    }

    @Test(priority = 2)
    public void verifyRemoveProductFromCart() throws InterruptedException {
        productsPage.tapOnProductName("Sauce Labs Bike Light");
        productsPage.tapOnAddToCartButton();
        productsPage.tapOnRemoveButton();
        productsPage.verifyThatProductHasBeenRemovedFromCart("REMOVE");
    }

    @Test(priority = 3)
    public void verifyTapOnProductImage() throws InterruptedException {
        productsPage.tapOnProductImage();
        productsPage.verifyProductDetailsPage();
    }

    @Test(priority = 3)
    public void verifyCheckoutWithValidCheckoutInfo() throws Exception {
        String[] data= TestUtil.readExcelValues("ProductsPage", "product_page_01");
        productsPage.tapOnProductImage();
        productsPage.tapOnAddToCartButton();
        productsPage.tapOnCartIcon();
        productsPage.tapOnCheckoutButton();
        productsPage.enterCheckoutInformation(data[0], data[1], data[2]);
        productsPage.tapOnContinueButton();
        productsPage.tapOnFinishButton();
        productsPage.verifyThatCheckoutIsSuccessful("Your order has been dispatched");
    }

    @Test(priority = 4)
    public void verifyCheckoutWithInvalidCheckoutInfo() throws Exception {
        String[] data= TestUtil.readExcelValues("ProductsPage", "product_page_02");
        productsPage.tapOnProductImage();
        productsPage.tapOnAddToCartButton();
        productsPage.tapOnCartIcon();
        productsPage.tapOnCheckoutButton();
        productsPage.enterCheckoutInformation(data[0], data[1], data[2]);
        productsPage.tapOnContinueButton();
        productsPage.verifyThatCheckoutInfoIsInvaid();
    }


    @AfterMethod
    public void tearDown(){


    }
}

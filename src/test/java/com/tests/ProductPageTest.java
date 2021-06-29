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

    }

    @Test(priority = 2)
    public void verifyRemoveProductFromCart() throws InterruptedException {
        productsPage.tapOnAddToCartButton();
        productsPage.tapOnRemoveButton();
    }

    @Test(priority = 3)
    public void verifyTapOnProductImage() throws InterruptedException {
        productsPage.tapOnProductImage();
    }

    @Test(priority = 3)
    public void verifyCheckoutItem() throws Exception {
        String[] data= TestUtil.ReadExcelValues("ProductsPage", "checkout_information");
        productsPage.tapOnProductImage();
        productsPage.tapOnAddToCartButton();
        productsPage.tapOnCartIcon();
        productsPage.tapOnCheckoutButton();
        productsPage.enterCheckoutInformation(data[0], data[1], data[2]);
        productsPage.tapOnContinueButton();
        productsPage.tapOnFinishButton();
        productsPage.verifyThatCheckoutIsSuccesful("Your order has been dispatched");
    }


    @AfterMethod
    public void tearDown(){


    }
}

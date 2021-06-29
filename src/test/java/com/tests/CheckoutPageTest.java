package com.tests;

import com.base.TestBase;
import com.pages.LoginPage;
import com.pages.ProductsPage;
import com.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CheckoutPageTest extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;

    public CheckoutPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        initialization();
        loginPage=new LoginPage();
        productsPage= loginPage.loginToStandardUser();
    }

    @Test(priority = 1)
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

    @Test(priority = 2)
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

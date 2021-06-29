package com.pages;

import com.base.TestBase;
import com.util.TestUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static com.base.TestBase.wait;

public class ProductsPage extends TestBase {

    public ProductsPage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }
//	//Page Factory - OR for the Home page or Dashboard

    @AndroidFindBy(xpath ="(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView")
    MobileElement productImage;

    @AndroidFindBy(xpath ="(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]")
    MobileElement btnAddToCart;

    @AndroidFindBy(xpath ="/android.view.ViewGroup[@content-desc='test-REMOVE']")
    MobileElement btnRemoveFromCart;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-Cart']")
    MobileElement cartIcon;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
    MobileElement checkoutBtn;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc='test-First Name']")
    MobileElement inputFirstname;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc='test-Last Name']")
    MobileElement inputLastname;

    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    MobileElement inputPostalCode;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-CONTINUE']")
    MobileElement continueBtn;

    @AndroidFindBy(xpath="//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']")
    MobileElement checkoutMessage;



    public void tapOnProductImage(){
        productImage.click();
    }

    public void tapOnCheckoutButton(){
        checkoutBtn.click();
    }

    public void tapOnCartIcon(){
        cartIcon.click();
    }

    public void tapOnContinueButton(){
        continueBtn.click();
    }

    public void tapOnFinishButton(){
        TestUtil.scrollAndTapOnText(this.driver, "FINISH");
    }

    public void verifyThatCheckoutIsSuccesful(String text){
        wait.until(ExpectedConditions.textToBePresentInElement(checkoutMessage, text));
    }


    public void enterCheckoutInformation(String firstName, String lastName, String postalCode){
        inputFirstname.sendKeys(firstName);
        inputLastname.sendKeys(lastName);
        inputPostalCode.sendKeys(postalCode);
    }


    public void tapOnRemoveButton(){
        TestUtil.scrollAndTapOnText(this.driver, "REMOVE");
    }

    public void tapOnAddToCartButton(){
        TestUtil.scrollAndTapOnText(this.driver, "ADD TO CART");
    }






}

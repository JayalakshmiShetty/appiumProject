package com.pages;

import com.base.TestBase;
import com.util.TestUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.pages.ProductsPage;

public class LoginPage extends TestBase {
    ProductsPage productsPage=new ProductsPage();
    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    //Page Factory - OR for the Home page or Dashboard

    @AndroidFindBy(id="test-Username")
    MobileElement inputUsername;

    @AndroidFindBy(id="test-Password")
    MobileElement inputPassword;

    @AndroidFindBy(id="test-LOGIN")
    MobileElement logInButton;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-standard_user']/android.widget.TextView")
    MobileElement stdUserAutofill;

    public void loginWithCredentials(String username, String password) throws InterruptedException {
        enterUserName(username);
        enterPassword(password);
        tapOnLogInButton();
    }



    public void enterUserName(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-Username")));
        inputUsername.sendKeys(email);
    }


    public void enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-Password")));
        inputPassword.sendKeys(password);
    }

    public void tapOnLogInButton() throws InterruptedException {
        TestUtil.scrollAndTapOnText(this.driver,"LOGIN");
    }

    public void tapOnStandardUserAutoFill() throws InterruptedException {

        TestUtil.scrollAndTapOnText(this.driver,"standard_user");
    }

    public ProductsPage loginToStandardUser() throws InterruptedException {
        tapOnStandardUserAutoFill();
        tapOnLogInButton();
        return productsPage;
    }


}

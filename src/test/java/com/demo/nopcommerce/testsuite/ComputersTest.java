package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.customlisteners.CustomListeners;
import com.demo.nopcommerce.pages.*;
import com.demo.nopcommerce.testbase.BaseTest;
import com.demo.nopcommerce.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class ComputersTest extends BaseTest {
    TopMenuPage topMenuPage;
    ProductPage productPage;
    MyOrderPage myOrderPage;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    LoginPage loginPage;
    CheckOutPage checkOutPage;
    RegistrationPage registrationPage;

    // This method contains objects of Pages
    @BeforeMethod(alwaysRun = true)
    public void pageObjects() {
        homePage = new HomePage();
        topMenuPage = new TopMenuPage();
        productPage = new ProductPage();
        myOrderPage= new MyOrderPage();
        shoppingCartPage = new ShoppingCartPage();
        loginPage = new LoginPage();
        checkOutPage = new CheckOutPage();
        registrationPage = new RegistrationPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Click on Computer Menu.
        topMenuPage.selectMenu("Computers");
        //1.2 Click on Desktop
        homePage.selectCategory("Desktops");
        //1.3 Select Sort By position "Name: Z to A"
        productPage.selectSortByType("Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(productPage.beforeSortTheProducts(), productPage.afterSortingTheProducts());

    }

    //Test 2
    @Test(groups = "regression")
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        topMenuPage.selectMenu("Computers");
        //2.2 Click on Desktop
        homePage.selectCategory("Desktops");
        //2.3 Select Sort By position "Name: A to Z"
        productPage.selectSortByType("Name: A to Z");
        Assert.assertEquals(productPage.beforeSortTheProducts(), productPage.afterSortingTheProducts());
        //2.4 Click on "Add To Cart"
        productPage.selectAddToCartProduct("Build your own computer");
        //2.5 Verify the Text "Build your own computer"
        Assert.assertEquals(myOrderPage.getProductName(), "Build your own computer");
        Thread.sleep(1000);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        myOrderPage.selectYourOwnProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select RAM "8GB [+$60.00]" using Select class.
        myOrderPage.SelectAppropriateRam("8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        myOrderPage.clickAndSelectHDD();
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        myOrderPage.clickAndSelectOsPremium();
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        myOrderPage.clickAndSelectTotalCmndr();

        //2.11 Verify the price "$1,475.00"
        Assert.assertEquals(myOrderPage.getPrice(), "$1,475.00");
        //2.12 Click on "ADD TO CARD" Button.
        myOrderPage.clickOnAddToCartBtn();
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals(myOrderPage.getMessageAfterAddingToCart(), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        myOrderPage.clickOnCloseButtonOnMessage();
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        homePage.MouseHooverOnShoppingCartLink();
        homePage.clickOnGoToCartElement();
        //2.15 Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.getShoppingCartText(), "Shopping cart");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.sendTextToQuantityField("2");
        shoppingCartPage.clickOnUpdateCartButton();
        //2.17 Verify the Total"$2,950.00"
        Assert.assertEquals(shoppingCartPage.getTotalPrice(), "$2,950.00");
        Thread.sleep(1000);
        //2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.checkOnTermAndConditions();
        //2.19 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckoutButton();
        //2.20 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome, Please Sign In!");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        loginPage.clickOnCheckoutGuestButton();
        //2.22 Fill the all mandatory field
        checkOutPage.sendTextToFirstNameField("Harshid");
        checkOutPage.sendTextToLastNameField("Patel");
        checkOutPage.sendTextTOEmailField("harshid.patel1234@gmail.com");
        checkOutPage.selectACountryInCountryField("United Kingdom");
        checkOutPage.sendTextToCityField("London");
        checkOutPage.sendTextToAddressField("London Road");
        checkOutPage.sendTextToPostCodeField("En657JR");
        checkOutPage.sendTextToPhoneField("07418529633");
        //2.23 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonCheckout();
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        checkOutPage.clickOnNextDayAirDelivery();
        //2.25 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonDelivery();
        //2.26 Select Radio Button “Credit Card”
        checkOutPage.clickOnCreditCardPaymentMethod();
        checkOutPage.clickOnContinueButtonPayment();
        //2.27 Select “Master card” From Select credit card dropdown
        checkOutPage.selectCreditCard(1);
        //2.28 Fill all the details
        checkOutPage.sendTextToCardholderNameField("Prime");
        checkOutPage.sendTextToCardNumberField("5555555555554444");
        checkOutPage.selectExpiryMonth("5");
        checkOutPage.selectExpiryYear("2024");
        checkOutPage.sendTextToCardCodeField("123");
        //2.29 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonCreditCard();
        //2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(checkOutPage.getPaymentMethodText(), "Payment Method: Credit Card");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals(checkOutPage.getDeliveryMethodText(), "Shipping Method: Next Day Air");
        //2.33 Verify Total is “$2,950.00”
        Assert.assertEquals(checkOutPage.getTotalPriceText(), "$2,950.00");
        //2.34 Click on “CONFIRM”
        checkOutPage.clickOnConfirmButton();
        //2.35 Verify the Text “Thank You”
        Assert.assertEquals(checkOutPage.getThankYouTextAfterOrderConfirmation(), "Thank you");
        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(checkOutPage.getOrderProcessedSuccessfullyTextAfterOrderConfirmation(), "Your order has been successfully processed!");
        //2.37 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonOnThankYouNote();
        //2.37 Verify the text “Welcome to our store”
        Assert.assertEquals(homePage.getWelcomeText(), "Welcome to our store");
    }

}

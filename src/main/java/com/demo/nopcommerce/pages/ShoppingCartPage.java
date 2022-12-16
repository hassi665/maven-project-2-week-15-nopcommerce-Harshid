package com.demo.nopcommerce.pages;

import com.aventstack.extentreports.Status;
import com.demo.nopcommerce.customlisteners.CustomListeners;
import com.demo.nopcommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//td[@class='quantity']/input")
    WebElement quantityField;
    @CacheLookup
    @FindBy(id = "updatecart")
    WebElement updateCartButton;
    @CacheLookup
    @FindBy(xpath = "//span[@class='value-summary'][1]/strong")
    WebElement totalPrice;
    @CacheLookup
    @FindBy(id = "termsofservice")
    WebElement termAndConditions;

    @CacheLookup
    @FindBy(name = "checkout")
    WebElement checkoutButton;


    public String getShoppingCartText() {
        Reporter.log("Shopping cart text : " + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "Shopping cart text :" + shoppingCartText);
        return getTextFromElement(shoppingCartText);
    }


    public void sendTextToQuantityField(String qty) {
        clearTextFromField(quantityField);
        sendTextToElement(quantityField, qty);
    }

    public void clickOnUpdateCartButton() {
        Reporter.log("Click on Update Cart Button " + updateCartButton.toString());
        clickOnElement(updateCartButton);
        CustomListeners.test.log(Status.PASS, "Click on Update Cart Button");

    }


    public String getTotalPrice() {
        Reporter.log("total price :" + totalPrice.toString());
        CustomListeners.test.log(Status.PASS, "total price :" + totalPrice);
        return getTextFromElement(totalPrice);
    }

    public void checkOnTermAndConditions() {
        Reporter.log("Click and checked on erm and conditions box" + termAndConditions.toString());
        clickOnElement(termAndConditions);
        CustomListeners.test.log(Status.PASS, "Click and checked on erm and conditions box");

    }

    public void clickOnCheckoutButton() {
        Reporter.log("Click on checkout button " + checkoutButton.toString());
        clickOnElement(checkoutButton);
        CustomListeners.test.log(Status.PASS, "Click on checkout button ");
    }

    public String getQuantityInQtyField() {
        Reporter.log("Quantity is " + quantityField.toString());
        WebElement actualQuantity = quantityField;
        String actual = actualQuantity.getAttribute("value");
        CustomListeners.test.log(Status.PASS, "The quantity is " + actual);
        return actual;
    }

    public String getShoppingCartTextAgain() {
        Reporter.log("The shopping cart text " + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "The shopping cart text " + shoppingCartText);
        return getTextFromElement(shoppingCartText);
    }

    public void clickOnTermAndConditions2() {
        Reporter.log("Click on erm and conditions box" + termAndConditions.toString());
        clickOnElement(termAndConditions);
        CustomListeners.test.log(Status.PASS, "Click on erm and conditions box");
    }

    public void clickOnCheckoutButton2() {
        Reporter.log("Click on checkout button " + checkoutButton.toString());
        clickOnElement(checkoutButton);
        CustomListeners.test.log(Status.PASS, "Click on checkout button ");
    }

}

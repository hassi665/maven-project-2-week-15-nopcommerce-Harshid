package com.demo.nopcommerce.pages;

import com.aventstack.extentreports.Status;
import com.demo.nopcommerce.customlisteners.CustomListeners;
import com.demo.nopcommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MyOrderPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-name']/h1")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement selectProcessor;
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement selectRam;
    @CacheLookup
    @FindBy(id = "product_attribute_3_7")
    WebElement selectModel;
    @CacheLookup
    @FindBy(id = "product_attribute_4_9")
    WebElement selectVistaPremium;
    @CacheLookup
    @FindBy(id = "product_attribute_5_12")
    WebElement selectTotalCommander;
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-price']")
    WebElement productPrice;
    @CacheLookup
    @FindBy(id = "product_enteredQuantity_20")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 add-to-cart-button']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/p[1]")
    WebElement textAfterAddingToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@id='bar-notification']/div[1]/span[1]")
    WebElement closeButtonOnMessage;

    public String getProductName() {
        Reporter.log("The product " + productName.toString());
        CustomListeners.test.log(Status.PASS, "The product");
        return getTextFromElement(productName);
    }

    public void selectYourOwnProcessor(String process) {
        Reporter.log("Select the processor " + selectProcessor.toString());
        selectByVisibleTextFromDropDown(selectProcessor, process);
        CustomListeners.test.log(Status.PASS, "Selected the processor is " + process);
    }


    public void SelectAppropriateRam(String ram) {
        Reporter.log("Select RAM " + selectRam.toString());
        selectByVisibleTextFromDropDown(selectRam, ram);
        CustomListeners.test.log(Status.PASS, "Selected RAM : " + ram);
    }

    public void clickAndSelectHDD() {
        Reporter.log("Select HDD " + selectModel.toString());
        clickOnElement(selectModel);
        CustomListeners.test.log(Status.PASS, "Selected HDD : ");
    }

    public void clickAndSelectOsPremium() {
        Reporter.log("Click on OS Premium " + selectVistaPremium.toString());
        clickOnElement(selectVistaPremium);
        CustomListeners.test.log(Status.PASS, "Click on OS Premium ");
    }

    public void clickAndSelectTotalCmndr() {
        Reporter.log("Click on Total Commander " + selectTotalCommander.toString());
        clickOnElement(selectTotalCommander);
        CustomListeners.test.log(Status.PASS, "Click on Total Commander ");
    }

    public String getPrice() {
        Reporter.log("The price is " + productPrice.toString());
        CustomListeners.test.log(Status.PASS, "The price is " + productPrice.getText());
        return getTextFromElement(productPrice);
    }

    public void clickOnAddToCartBtn() {
        Reporter.log("Click on add card button " + addToCart.toString());
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Click on add card link ");

    }

    public String getMessageAfterAddingToCart() {
        Reporter.log("The Message after Adding to cart is " + textAfterAddingToCart.toString());
        CustomListeners.test.log(Status.PASS, "The Message after Adding to cart is " + textAfterAddingToCart.getText());
        return getTextFromElement(textAfterAddingToCart);
    }


    public void clickOnCloseButtonOnMessage() {
        Reporter.log("Click on close Button on Message " + closeButtonOnMessage.toString());
        clickOnElement(closeButtonOnMessage);
        CustomListeners.test.log(Status.PASS, "Click on close Button on Message");
    }

    public void sentTextToQuantityField(String qty) {
        Reporter.log("Click quantity field " + quantity.toString());
        clearTextFromField(quantity);
        sendTextToElement(quantity, qty);
        CustomListeners.test.log(Status.PASS, "The quantity is " + qty);
    }
}

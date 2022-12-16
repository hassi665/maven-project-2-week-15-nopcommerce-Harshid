package com.demo.nopcommerce.pages;

import com.aventstack.extentreports.Status;
import com.demo.nopcommerce.customlisteners.CustomListeners;
import com.demo.nopcommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckOutPage extends Utility {
    @CacheLookup
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_Email")
    WebElement emailIdField;
    @CacheLookup
    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    WebElement countryField;
    @CacheLookup
    @FindBy(name = "BillingNewAddress.City")
    WebElement cityField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postCodeField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement telephoneNoField;
    @CacheLookup
    @FindBy(name = "save")
    WebElement continueButtonCheckout;
    @CacheLookup
    @FindBy(id = "shippingoption_1")
    WebElement nextDayDelivery;
    @CacheLookup
    @FindBy(id = "shippingoption_2")
    WebElement nextSecondDayDelivery;
    @CacheLookup
    @FindBy(xpath = "//button[@class ='button-1 shipping-method-next-step-button']")
    WebElement continueButtonDelivery;
    @CacheLookup
    @FindBy(id = "paymentmethod_1")
    WebElement creditCardPaymentMethod;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
    WebElement continueButtonPayment;
    @CacheLookup
    @FindBy(id = "CreditCardType")
    WebElement selectCreditCardFiled;
    @CacheLookup
    @FindBy(xpath = "//input[@id='CardholderName']")
    WebElement cardholderNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='CardNumber']")
    WebElement cardNumberFiled;
    @CacheLookup
    @FindBy(xpath = "//select[@id='ExpireMonth']")
    WebElement expiryMonthFiled;
    @CacheLookup
    @FindBy(xpath = "//select[@id='ExpireYear']")
    WebElement expiryYearFiled;
    @CacheLookup
    @FindBy(xpath = "//input[@id='CardCode']")
    WebElement cardCodeFiled;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    WebElement continueButtonCreditCard;
    @CacheLookup
    @FindBy(xpath = "//li[@class='payment-method']")
    WebElement paymentMethodText;
    @CacheLookup
    @FindBy(xpath = "//li[@class='shipping-method']")
    WebElement shippingMethod;
    @CacheLookup
    @FindBy(xpath = "//tr[@class='order-total']/td[2]")
    WebElement totalFinalPrice;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 confirm-order-next-step-button']")
    WebElement confirmButton;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Thank you')]")
    WebElement thankYouText;
    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
    WebElement orderProcessedMessage;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 order-completed-continue-button']")
    WebElement continueButtonOnThankYouNote;


    public void sendTextToFirstNameField(String fName) {
        Reporter.log("Enter user first name " + fName + " to firstname field " + firstNameField.toString());
        sendTextToElement(firstNameField, fName);
        CustomListeners.test.log(Status.PASS, "Entered  first name " + fName);

    }

    public void sendTextToLastNameField(String lName) {
        Reporter.log("Enter user last name " + lName + " to lastname field " + lastNameField.toString());
        sendTextToElement(lastNameField, lName);
        CustomListeners.test.log(Status.PASS, "Entered  last name " + lName);

    }

    public void sendTextTOEmailField(String gEmail) {
        Reporter.log("Enter user email " + gEmail + " to Email field " + emailIdField.toString());
        sendTextToElement(emailIdField, gEmail + getAlphaNumericString(2) + "@gmail.com");
        CustomListeners.test.log(Status.PASS, "Entered  gmail " + gEmail);


    }

    public void sendTextToCityField(String gCity) {
        Reporter.log("Enter city name " + gCity + " to City field " + cityField.toString());
        sendTextToElement(cityField, gCity);
        CustomListeners.test.log(Status.PASS, "Entered  city name " + gCity);

    }

    public void selectACountryInCountryField(String gCountry) {
        Reporter.log("Select a country" + countryField.toString());
        selectByVisibleTextFromDropDown(countryField, gCountry);
        CustomListeners.test.log(Status.PASS, "Selected country is " + gCountry);

    }

    public void sendTextToAddressField(String gAddress) {
        Reporter.log("Enter Address " + gAddress + " to Address field " + addressField.toString());
        sendTextToElement(addressField, gAddress);
        CustomListeners.test.log(Status.PASS, "Entered  Address " + gAddress);

    }

    public void sendTextToPostCodeField(String gPostCode) {
        Reporter.log("Enter postcode " + gPostCode + " to Postcode field " + postCodeField.toString());
        sendTextToElement(postCodeField, gPostCode);
        CustomListeners.test.log(Status.PASS, "Entered  Postcode " + gPostCode);

    }


    public void sendTextToPhoneField(String gtele) {
        Reporter.log("Enter telephone number " + gtele + " to Telephone Number field " + telephoneNoField.toString());
        sendTextToElement(telephoneNoField, gtele);
        CustomListeners.test.log(Status.PASS, "Entered  first name " + gtele);

    }

    public void clickOnContinueButtonCheckout() {
        Reporter.log("Clicking on continue Button " + continueButtonCheckout.toString());
        clickOnElement(continueButtonCheckout);
        CustomListeners.test.log(Status.PASS, "Click on continue Button");

    }

    public void clickOnNextDayAirDelivery() {
        Reporter.log("Click on Next Day Air Delivery Button " + nextDayDelivery.toString());
        clickOnElement(nextDayDelivery);
        CustomListeners.test.log(Status.PASS, "Click on Next Day Air Delivery Button");

    }

    public void clickOnSecondDayAirDelivery() {
        Reporter.log("Click on Second Day Air Delivery Button " + nextSecondDayDelivery.toString());
        clickOnElement(nextSecondDayDelivery);
        CustomListeners.test.log(Status.PASS, "Click on Second Day Air Delivery Button");

    }

    public void clickOnContinueButtonDelivery() {
        Reporter.log("Click on continue Button on delivery section " + continueButtonDelivery.toString());
        clickOnElement(continueButtonDelivery);
        CustomListeners.test.log(Status.PASS, "Click on continue Button on delivery section");

    }

    public void clickOnCreditCardPaymentMethod() {
        Reporter.log("Clicking on Credit Card Payment Button " + creditCardPaymentMethod.toString());
        clickOnElement(creditCardPaymentMethod);
        CustomListeners.test.log(Status.PASS, "Clicking on Credit Card Payment Button ");

    }

    public void clickOnContinueButtonPayment() {
        Reporter.log("Click on continue Button on payment method " + continueButtonPayment.toString());
        clickOnElement(continueButtonPayment);
        CustomListeners.test.log(Status.PASS, "Click on continue Button on payment method ");

    }


    public void selectCreditCard(int cCard) {
        Reporter.log("Select Credit " + selectCreditCardFiled.toString());
        selectByIndexFromDropDown(selectCreditCardFiled, cCard);
        CustomListeners.test.log(Status.PASS, "Selected Credit Card is " + cCard);

    }

    public void sendTextToCardholderNameField(String cardholder) {
        Reporter.log("Enter cardholder name " + cardholder + " to Cardholder Name field " + cardholderNameField.toString());
        sendTextToElement(cardholderNameField, cardholder);
        CustomListeners.test.log(Status.PASS, "Entered  cardholder name " + cardholder);

    }

    public void sendTextToCardNumberField(String cardNumber) {
        Reporter.log("Enter card number " + cardNumber + " to Telephone Number field " + cardholderNameField.toString());
        sendTextToElement(cardNumberFiled, cardNumber);
        CustomListeners.test.log(Status.PASS, "Entered  card number " + cardNumber);

    }

    public void selectExpiryMonth(String month) {
        Reporter.log("Enter expiry month " + month + " to Telephone Number field " + expiryMonthFiled.toString());
        selectByValueFromDropDown(expiryMonthFiled, month);
        CustomListeners.test.log(Status.PASS, "Entered expiry month " + month);

    }
    public void selectExpiryYear(String year) {
        Reporter.log("Enter expiry year " + year + " to Telephone Number field " + expiryYearFiled.toString());
        selectByValueFromDropDown(expiryYearFiled, year);
        CustomListeners.test.log(Status.PASS, "Entered  expiry year " + year);

    }

    public void sendTextToCardCodeField(String cardCode) {
        Reporter.log("Enter card code number " + cardCode + " to Telephone Number field " + cardCodeFiled.toString());
        sendTextToElement(cardCodeFiled, cardCode);
        CustomListeners.test.log(Status.PASS, "Entered  first name " + cardCode);

    }

    public void clickOnContinueButtonCreditCard() {
        Reporter.log("Click on continue Button on card section " + continueButtonCreditCard.toString());
        clickOnElement(continueButtonCreditCard);
        CustomListeners.test.log(Status.PASS, "Click on continue Button on card section");


    }

    public String getPaymentMethodText() {
        Reporter.log("The payment method text " + paymentMethodText.toString());
        CustomListeners.test.log(Status.PASS, "The payment method text");
        return getTextFromElement(paymentMethodText);

    }

    public String getDeliveryMethodText() {
        Reporter.log("The delivery method text " + shippingMethod.toString());
        CustomListeners.test.log(Status.PASS, "The delivery method text");
        return getTextFromElement(shippingMethod);

    }

    public String getTotalPriceText() {
        Reporter.log("The total price text " + totalFinalPrice.toString());
        CustomListeners.test.log(Status.PASS, "The total price text");
        return getTextFromElement(totalFinalPrice);
    }

    public void clickOnConfirmButton() {
        Reporter.log("Click on confirm Button " + confirmButton.toString());
        clickOnElement(confirmButton);
        CustomListeners.test.log(Status.PASS, "Click on confirm Button ");

    }

    public String getThankYouTextAfterOrderConfirmation() {
        Reporter.log("The thank you text " + thankYouText.toString());
        CustomListeners.test.log(Status.PASS, "The thank you text ");
        return getTextFromElement(thankYouText);
    }

    public String getOrderProcessedSuccessfullyTextAfterOrderConfirmation() {
        Reporter.log("The order process Successful text " + orderProcessedMessage.toString());
        CustomListeners.test.log(Status.PASS, "The order process Successful text ");
        return getTextFromElement(orderProcessedMessage);
    }

    public void clickOnContinueButtonOnThankYouNote() {
        Reporter.log("Click on continue Button after thank you " + continueButtonOnThankYouNote.toString());
        clickOnElement(continueButtonOnThankYouNote);
        CustomListeners.test.log(Status.PASS, "Click on continue Button after thank you ");
    }
}

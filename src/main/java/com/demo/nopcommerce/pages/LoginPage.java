package com.demo.nopcommerce.pages;

import com.aventstack.extentreports.Status;
import com.demo.nopcommerce.customlisteners.CustomListeners;
import com.demo.nopcommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;
    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 checkout-as-guest-button']")
    WebElement checkoutAsGuest;

    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 register-button']")
    WebElement registerButton;

    public String getWelcomeText() {
        Reporter.log("The Welcome text " + welcomeText.toString());
        CustomListeners.test.log(Status.PASS, "The Welcome text");
        return getTextFromElement(welcomeText);
    }

    public void enterEmailId(String userEmail) {
        Reporter.log("Enter Email ID " + userEmail + " to Email field " + emailField.toString());
        sendTextToElement(emailField, userEmail);
        CustomListeners.test.log(Status.PASS, "Email ID is " + userEmail);
    }

    public void enterPassword(String userPassword) {
        Reporter.log("Enter password  " + userPassword + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, userPassword);
        CustomListeners.test.log(Status.PASS, "Entered password is " + userPassword);
    }

    public void clickOnLogInButton() {
        Reporter.log("Click on Login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on continue Button on card section");
    }

    public String getErrorMessage() {
        Reporter.log("The Error Message " + errorMessage.toString());
        CustomListeners.test.log(Status.PASS, "The Error Message is ");
        return getTextFromElement(errorMessage);
    }

    public void clickOnCheckoutGuestButton() {
        Reporter.log("Click on checkout Button in guest section " + checkoutAsGuest.toString());
        clickOnElement(checkoutAsGuest);
        CustomListeners.test.log(Status.PASS, "Click on checkout Button in guest section");
    }

    public void clickOnRegisterLink() {
        Reporter.log("Click on Register Button " + registerButton.toString());
        clickOnElement(registerButton);
        CustomListeners.test.log(Status.PASS, "Click on Register Button");
    }
}

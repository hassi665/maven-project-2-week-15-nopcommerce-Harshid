package com.demo.nopcommerce.pages;

import com.aventstack.extentreports.Status;
import com.demo.nopcommerce.customlisteners.CustomListeners;
import com.demo.nopcommerce.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutLink;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement goToCartLink;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement welcomeTextMessage;
    @CacheLookup
    @FindBy(xpath = "//div[@class='item-grid']/child::*")
    List<WebElement> categoriesList;

    public void clickOnLoginLink() {
        Reporter.log("Click on login link " + loginLink.toString());
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS, "Click on login link");
    }

    public void clickOnRegisterLink() {
        Reporter.log("Click on Register link " + registerLink.toString());
        clickOnElement(registerLink);
        CustomListeners.test.log(Status.PASS, "Click on Register link");
    }


    public void MouseHooverOnShoppingCartLink() {
        Reporter.log("Click on Shopping cart link " + shoppingCartLink.toString());
        mouseHoverToElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS, "Click on Shopping cart link");
    }

    public void clickOnGoToCartElement() {
        Reporter.log("Click on Go to Cart " + goToCartLink.toString());
        clickOnElement(goToCartLink);
        CustomListeners.test.log(Status.PASS, "Click on Go to Cart");

    }

    public String getWelcomeText() {
        Reporter.log("The welcome text " + welcomeTextMessage.toString());
        CustomListeners.test.log(Status.PASS, "The welcome text ");
        return getTextFromElement(welcomeTextMessage);
    }

    public void clickOnLogOutLink() {
        Reporter.log("Click on logout link " + logoutLink.toString());
        clickOnElement(logoutLink);
        CustomListeners.test.log(Status.PASS, "Click on logout link");
    }

    public String currentUrl() {
        Reporter.log("The url is ");
        String url = driver.getCurrentUrl();
        CustomListeners.test.log(Status.PASS, "The current url is " +url);
        return url;
    }

    public void selectCategory(String cat) {
        Reporter.log("The Category List is " + categoriesList.toString());
        List<WebElement> catList = categoriesList;
        try {
            for (WebElement list : catList) {
                if (list.getText().equalsIgnoreCase(cat)) {
                    list.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            catList = categoriesList;
        }
        CustomListeners.test.log(Status.PASS, "The category is \"" + cat + "\"");
    }

}

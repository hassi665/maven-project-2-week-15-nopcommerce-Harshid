package com.demo.nopcommerce.pages;

import com.aventstack.extentreports.Status;
import com.demo.nopcommerce.customlisteners.CustomListeners;
import com.demo.nopcommerce.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement sortBy;
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-grid']//child::*")
    List<WebElement> listOfProductsOptions;
    @CacheLookup
    @FindBy(xpath = "//div[@class='item-grid']/div//h2")
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(xpath = "//div[@class='buttons']")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'List')]")
    WebElement listView;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-grid']//div[1]/div[2]//h2")
    WebElement productTitle;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Nokia Lumia 1020')]")
    WebElement mobileNokia;

    public String getProductName() {
        Reporter.log("The product " + mobileNokia.toString());
        CustomListeners.test.log(Status.PASS, "The product");
        return getTextFromElement(mobileNokia);
    }
    public void selectSortByType(String sortByType) {
        Reporter.log("Select Sort By" + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, sortByType);
        CustomListeners.test.log(Status.PASS, "Selected Sort By " + sortByType);
    }

    public void selectAddToCartProduct(String product) {
        Reporter.log("List of Products" + listOfProductsOptions.toString());

        List<WebElement> productsList = listOfProductsOptions;
        try {
            for (WebElement list : productsList) {
                if (list.getText().equalsIgnoreCase(product)) {
                    Actions actions = new Actions(driver);
                    WebElement addCart = addToCartButton;
                    actions.click(addCart).build().perform();
                }
            }
        } catch (StaleElementReferenceException e) {
            productsList = listOfProductsOptions;
        }
        CustomListeners.test.log(Status.PASS, "Selected Product " + product);

    }

    public ArrayList beforeSortTheProducts() {
        Reporter.log("Product List" + productsList.toString());

        List<WebElement> products = productsList;
        ArrayList<String> originalProductList = new ArrayList<>();
        for (WebElement list : products) {
            originalProductList.add(list.getText());
        }
        CustomListeners.test.log(Status.PASS, "Selected country is ");
        return originalProductList;
    }

    public ArrayList afterSortingTheProducts() {
        Reporter.log("List of Products after sorting" + productsList.toString());

        System.out.println(beforeSortTheProducts());
        Collections.reverse(beforeSortTheProducts());
        System.out.println(beforeSortTheProducts());
        List<WebElement> products = productsList;
        ArrayList<String> afterSortList = new ArrayList<>();
        for (WebElement newList : products) {
            afterSortList.add(newList.getText());
        }
        CustomListeners.test.log(Status.PASS, "Selected country is ");
        return afterSortList;
    }

    public void clickOnListViewIcon() {
        Reporter.log("Click on List view" + listView.toString());
        clickOnElement(listView);
        CustomListeners.test.log(Status.PASS, "List View Clicked ");
    }


    public void clickOnTheProduct(String product) {
        Reporter.log("Select a product" + listOfProductsOptions.toString());

        List<WebElement> productList = listOfProductsOptions;
        try {
            for (WebElement list : productList) {
                if (list.getText().equalsIgnoreCase(product)) {
                    Actions actions = new Actions(driver);
                    WebElement products = productTitle;
                    actions.moveToElement(products).click().build().perform();
                }
            }
        } catch (StaleElementReferenceException e) {
            productList = listOfProductsOptions;
        }
        CustomListeners.test.log(Status.PASS, "Selected product is " + product);

    }

    public void clickOnNokiaLumia() {
        Reporter.log("Click on Nokia Lumia" + mobileNokia.toString());
        clickOnElement(mobileNokia);
        CustomListeners.test.log(Status.PASS, "Nokia Lumia Clicked");

    }

}

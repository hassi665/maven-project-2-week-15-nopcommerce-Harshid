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

import java.util.List;

public class TopMenuPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']//ul/child::*")
    List<WebElement> topMenuBar;
    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']")
    WebElement pageTitle;

    //This method will choose the options from main menu
    public void selectMenu(String menu) {
        Reporter.log("The menu options are " + topMenuBar.toString());

        List<WebElement> topMenuList = topMenuBar;
        try {
            for (WebElement list : topMenuList) {
                if (list.getText().equalsIgnoreCase(menu)) {
                    list.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenuBar;
        }
        CustomListeners.test.log(Status.PASS, "The selected menu is " + menu);

    }
    //This method will over the mouse
    public void hoverOverMenu(String mMenu) {
        Reporter.log("The menu options are" + topMenuBar.toString());

        Actions actions = new Actions(driver);
        List<WebElement> topMenuList = topMenuBar;
        try {
            for (WebElement list : topMenuList) {
                if (list.getText().equalsIgnoreCase(mMenu)) {
                    actions.moveToElement(list).build().perform();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenuBar;
        }
        CustomListeners.test.log(Status.PASS, "The selected menu is " + mMenu);

    }

    //This method will return title of each page for verification purpose
    public String textOnEachPage() {
        Reporter.log("The page title are " + pageTitle.toString());
        CustomListeners.test.log(Status.PASS, "The page title is " + pageTitle);
        return getTextFromElement(pageTitle);
    }
}

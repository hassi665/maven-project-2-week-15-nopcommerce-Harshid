package com.demo.nopcommerce.testsuite;


import com.demo.nopcommerce.customlisteners.CustomListeners;
import com.demo.nopcommerce.pages.TopMenuPage;
import com.demo.nopcommerce.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuPageTest extends BaseTest {

    TopMenuPage topMenuPage;

    @BeforeMethod(alwaysRun = true)
    public void pageObjects() {
        topMenuPage = new TopMenuPage();

    }


    @Test(groups = {"sanity", "regression"})
    public void verifySuccessfulPageNavigation() {
        topMenuPage.selectMenu("Electronics");
        Assert.assertEquals(topMenuPage.textOnEachPage(), "Electronics");
    }

    @Test(groups = "regression")
    public void verifySuccessfulPageNavigation2() {
        topMenuPage.selectMenu("Computers");
        Assert.assertEquals(topMenuPage.textOnEachPage(), "Computers");
    }
}


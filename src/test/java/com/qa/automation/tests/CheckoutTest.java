package com.qa.automation.tests;

import com.qa.automation.pages.CartPage;

import com.qa.automation.pages.CheckoutPage;

import com.qa.automation.pages.InventoryPage;

import com.qa.automation.pages.LoginPage;

import com.qa.automation.utils.DriverFactory;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.*;

public class CheckoutTest {

    WebDriver driver;

    @BeforeMethod

    public void setUp() {

        driver = DriverFactory.getDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.goTo();

        loginPage.login("standard_user", "secret_sauce");

    }

    @Test

    public void validCheckoutTest() {

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addBackpackToCart();

        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        cartPage.goToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.fillInfo("Jane", "Doe", "10100");

        checkoutPage.finishOrder();

        Assert.assertEquals(checkoutPage.getConfirmationText(), "Thank you for your order!",

                "Order confirmation message should appear after completing checkout");

    }

    @AfterMethod

    public void tearDown() {

        driver.quit();

    }

}

package com.qa.automation.tests;

import com.qa.automation.pages.CartPage;

import com.qa.automation.pages.InventoryPage;

import com.qa.automation.pages.LoginPage;

import com.qa.automation.utils.DriverFactory;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.*;

public class CartContentsTest {

    WebDriver driver;

    @BeforeMethod

    public void setUp() {

        driver = DriverFactory.getDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.goTo();

        loginPage.login("standard_user", "secret_sauce");

    }

    @Test

    public void cartShowsCorrectItemTest() {

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addBackpackToCart();

        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.getItemNames().contains("Sauce Labs Backpack"),

                "Cart should contain the item that was added on the inventory page");

    }

    @AfterMethod

    public void tearDown() {

        driver.quit();

    }

}

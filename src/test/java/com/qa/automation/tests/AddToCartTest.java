package com.qa.automation.tests;

import com.qa.automation.pages.InventoryPage;

import com.qa.automation.pages.LoginPage;

import com.qa.automation.utils.DriverFactory;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.*;

public class AddToCartTest {

    WebDriver driver;

    @BeforeMethod

    public void setUp() {

        driver = DriverFactory.getDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.goTo();

        loginPage.login("standard_user", "secret_sauce");

    }

    @Test

    public void addItemToCartTest() {

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addBackpackToCart();

        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1",

                "Cart badge should show 1 after adding one item");

    }

    @AfterMethod

    public void tearDown() {

        driver.quit();

    }

}

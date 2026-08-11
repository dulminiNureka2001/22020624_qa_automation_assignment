package com.qa.automation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");

    By cartBadge = By.className("shopping_cart_badge");

    By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {

        this.driver = driver;

    }

    public void addBackpackToCart() {

        driver.findElement(addBackpackButton).click();

    }

    public String getCartBadgeCount() {

        return driver.findElement(cartBadge).getText();

    }

    public void goToCart() {

        driver.findElement(cartIcon).click();

    }

}

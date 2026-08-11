package com.qa.automation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class CartPage {

    WebDriver driver;

    By cartItemNames = By.className("inventory_item_name");

    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {

        this.driver = driver;

    }

    public List<String> getItemNames() {

        return driver.findElements(cartItemNames).stream()

                .map(el -> el.getText())

                .toList();

    }

    public void goToCheckout() {

        driver.findElement(checkoutButton).click();

    }

}

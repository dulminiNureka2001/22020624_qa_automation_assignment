package com.qa.automation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    By firstNameField = By.id("first-name");

    By lastNameField = By.id("last-name");

    By postalCodeField = By.id("postal-code");

    By continueButton = By.id("continue");

    By finishButton = By.id("finish");

    By confirmationHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

    }

    public void fillInfo(String first, String last, String postal) {

        driver.findElement(firstNameField).sendKeys(first);

        driver.findElement(lastNameField).sendKeys(last);

        driver.findElement(postalCodeField).sendKeys(postal);

        driver.findElement(continueButton).click();

    }

    public void finishOrder() {

        driver.findElement(finishButton).click();

    }

    public String getConfirmationText() {

        return driver.findElement(confirmationHeader).getText();

    }

}

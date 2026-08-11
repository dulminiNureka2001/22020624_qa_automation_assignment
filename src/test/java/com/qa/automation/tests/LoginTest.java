package com.qa.automation.tests;

import com.qa.automation.pages.LoginPage;

import com.qa.automation.utils.DriverFactory;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;

    LoginPage loginPage;

    @BeforeMethod

    public void setUp() {

        driver = DriverFactory.getDriver();

        loginPage = new LoginPage(driver);

        loginPage.goTo();

    }

    @Test

    public void validLoginTest() {

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),

                "User should land on the inventory page after valid login");

    }

    @Test

    public void invalidPasswordLoginTest() {

        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.getErrorText().contains("do not match"),

                "Error message should indicate username/password mismatch");

    }

    @AfterMethod

    public void tearDown() {

        driver.quit();

    }

}

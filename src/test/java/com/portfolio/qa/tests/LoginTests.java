package com.portfolio.qa.tests;
import com.portfolio.qa.base.BaseTest;
import com.portfolio.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends BaseTest {
    @Test public void validUserCanOpenInventory() {
        new LoginPage(driver).open().enterUsername("standard_user").enterPassword("secret_sauce").submitLogin();
        InventoryPage page = new InventoryPage(driver);
        Assert.assertTrue(page.isLoaded(), "Inventory page should be visible");
        Assert.assertTrue(page.getProductCount() > 0, "Inventory should contain products");
    }
    @Test public void invalidPasswordShowsError() {
        LoginPage page = new LoginPage(driver).open().enterUsername("standard_user").enterPassword("wrong_password");
        page.submitLogin();
        Assert.assertTrue(page.getErrorMessage().contains("Username and password do not match"),
            "Invalid credentials should show an error");
    }
    @Test public void emptyCredentialsShowError() {
        LoginPage page = new LoginPage(driver).open();
        page.submitLogin();
        Assert.assertTrue(page.getErrorMessage().contains("Username is required"),
            "Missing username should show an error");
    }
}

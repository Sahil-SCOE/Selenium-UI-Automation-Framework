package com.portfolio.qa.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By login = By.id("login-button");
    private final By error = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver; this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        return this;
    }
    public LoginPage enterUsername(String value) {
        driver.findElement(username).clear(); driver.findElement(username).sendKeys(value); return this;
    }
    public LoginPage enterPassword(String value) {
        driver.findElement(password).clear(); driver.findElement(password).sendKeys(value); return this;
    }
    public void submitLogin() { wait.until(ExpectedConditions.elementToBeClickable(login)).click(); }
    public String getErrorMessage() { return wait.until(ExpectedConditions.visibilityOfElementLocated(error)).getText(); }
}

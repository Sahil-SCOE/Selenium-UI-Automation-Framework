package com.portfolio.qa.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
public class InventoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By title = By.cssSelector("[data-test='title']");
    private final By items = By.cssSelector(".inventory_item");
    public InventoryPage(WebDriver driver) {
        this.driver = driver; this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText().equals("Products");
    }
    public int getProductCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(items));
        return driver.findElements(items).size();
    }
}

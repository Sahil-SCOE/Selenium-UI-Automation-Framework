package com.portfolio.qa.base;
import com.portfolio.qa.driver.DriverFactory;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BaseTest {
    protected WebDriver driver;
    @BeforeMethod public void setUp() { driver = DriverFactory.createDriver(); }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver == null) return;
        if (!result.isSuccess()) captureScreenshot(result.getName());
        driver.quit();
    }

    private void captureScreenshot(String testName) {
        try {
            Path dir = Path.of("target", "screenshots");
            Files.createDirectories(dir);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            Path output = dir.resolve(testName + "-" + timestamp + ".png");
            Files.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath(),
                output, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Failure screenshot saved: " + output.toAbsolutePath());
        } catch (IOException | WebDriverException ex) {
            System.err.println("Could not capture screenshot: " + ex.getMessage());
        }
    }
}

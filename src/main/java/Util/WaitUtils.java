package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Author: Sivaraman M
 * User:Sivaraman M
 */
public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor initializes WebDriverWait with a timeout (in seconds)
    public WaitUtils(WebDriver driver, long timeoutInSeconds) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // Wait for an element to be visible on the page
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForVisibility(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    // Wait for an element to be clickable
    public WebElement waitForElementForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementForClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for an element to be present in the DOM
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait until an element is no longer visible on the page
    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public boolean waitForInvisibility(WebElement locator) {
        return wait.until(ExpectedConditions.invisibilityOf(locator));
    }
    public WebElement fluentWait(By locator) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(locator));
    }

}

/*
 ============================================================================
 Name        : FluentWaitExample.java
 Copyright   : Edges For Training
 Description : Using fluent wait with custom polling and exception handling
 ============================================================================
 */

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        browser.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        
        // Create fluent wait with custom configuration
        Wait<WebDriver> fluentWait = new FluentWait<>(browser)
                .withTimeout(Duration.ofSeconds(15))           // Maximum wait time
                .pollingEvery(Duration.ofMillis(500))          // Check every 500ms
                .withMessage("Element not found within timeout")
                .ignoring(NoSuchElementException.class);       // Ignore this exception during polling
        
        // Start the loading process
        browser.findElement(By.cssSelector("#start button")).click();
        System.out.println("Loading started - using fluent wait");
        
        // Wait for the finish element to be visible using fluent wait
        WebElement finishElement = fluentWait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("finish"))
        );
        
        System.out.println("Element found with fluent wait: " + finishElement.getText());
        browser.quit();
    }
}

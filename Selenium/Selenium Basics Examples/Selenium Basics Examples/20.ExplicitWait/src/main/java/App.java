/*
 ============================================================================
 Name        : ExplicitWaitExample.java
 Copyright   : Edges For Training
 Description : Using WebDriverWait and ExpectedConditions
 ============================================================================
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        browser.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        
        browser.findElement(By.cssSelector("#start button")).click();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement finishText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        
        System.out.println("Loaded text: " + finishText.getText());
        browser.quit();
    }
}

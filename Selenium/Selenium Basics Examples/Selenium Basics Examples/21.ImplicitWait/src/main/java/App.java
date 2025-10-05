/*
 ============================================================================
 Name        : ImplicitWaitExample.java
 Copyright   : Edges For Training
 Description : Using implicit wait for global element finding timeout
 ============================================================================
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        
        // Set implicit wait - applies to all findElement calls
        // Will wait up to 10 seconds for any element to be present in DOM
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        browser.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        
        // Start the dynamic loading process
        WebElement startButton = browser.findElement(By.cssSelector("#start button"));
        startButton.click();
        System.out.println("Start button clicked - loading began");
        
        // This findElement will wait up to 10 seconds (implicit wait) for element to appear
        WebElement finishText = browser.findElement(By.id("finish"));
        System.out.println("Finish text found: " + finishText.getText());
        
        browser.quit();
    }
}

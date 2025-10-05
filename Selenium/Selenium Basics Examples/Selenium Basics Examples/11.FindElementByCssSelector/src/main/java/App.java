/*
 ============================================================================
 Name        : FindElementByCssSelector.java
 Copyright   : Edges For Training
 Description : Finding elements by CSS selector using the-internet.herokuapp.com
 ============================================================================
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        browser.get("https://the-internet.herokuapp.com/login");
        
        // Find username input by CSS selector on attribute
        WebElement userField = browser.findElement(By.cssSelector("input#username"));
        System.out.println("Found element by CSS selector: " + userField.getAttribute("id"));
        
        browser.quit();
    }
}

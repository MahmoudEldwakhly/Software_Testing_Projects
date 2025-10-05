/*
 ============================================================================
 Name        : ClearTextExample.java
 Copyright   : Edges For Training
 Description : Clearing text from input fields using clear()
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
        
        WebElement userField = browser.findElement(By.id("username"));
        userField.sendKeys("someuser");
        System.out.println("Before clear: " + userField.getAttribute("value"));
        userField.clear();
        System.out.println("After clear: '" + userField.getAttribute("value") + "'");
        
        browser.quit();
    }
}

/*
 ============================================================================
 Name        : FindElementByName.java
 Copyright   : Edges For Training
 Description : Finding elements by name attribute using the-internet.herokuapp.com
 ============================================================================
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        
        // Navigate to login page
        browser.get("https://the-internet.herokuapp.com/login");
        
        // Find username field by name attribute
        WebElement usernameField = browser.findElement(By.name("username"));
        System.out.println("Found element with name: username");
        
        // Find password field by name attribute
        WebElement passwordField = browser.findElement(By.name("password"));
        System.out.println("Found element with name: password");
        
        // Display element information
        System.out.println("Username field type: " + usernameField.getAttribute("type"));
        System.out.println("Password field type: " + passwordField.getAttribute("type"));
        
        browser.quit();
    }
}

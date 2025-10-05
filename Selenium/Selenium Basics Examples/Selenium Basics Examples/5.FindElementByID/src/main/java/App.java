/*
 ============================================================================
 Name        : FindElementByID.java
 Copyright   : Edges For Training
 Description : Finding elements by ID attribute using the-internet.herokuapp.com
 ============================================================================
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        
        // Navigate to login page which has elements with ID attributes
        browser.get("https://the-internet.herokuapp.com/login");
        
        // Find username input field by its ID attribute
        WebElement usernameField = browser.findElement(By.id("username"));
        System.out.println("Found username field with ID: username");
        
        // Find password input field by its ID attribute
        WebElement passwordField = browser.findElement(By.id("password"));
        System.out.println("Found password field with ID: password");
        
        // Print the tag names of found elements
        System.out.println("Username field tag: " + usernameField.getTagName());
        System.out.println("Password field tag: " + passwordField.getTagName());
        
        browser.quit();
    }
}

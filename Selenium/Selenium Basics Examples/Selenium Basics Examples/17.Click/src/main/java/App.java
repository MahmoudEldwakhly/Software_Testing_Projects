/*
 ============================================================================
 Name        : ClickExample.java
 Copyright   : Edges For Training
 Description : Clicking a button using click()
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
        
        // Find username input field by its ID attribute
        WebElement usernameField = browser.findElement(By.id("username")); 
        // Writing the user name in the username field
        usernameField.sendKeys("tomsmith");
        
        // Find password input field by its ID attribute
        WebElement passwordField = browser.findElement(By.id("password"));       
        // Writing the Password in the password field
        passwordField.sendKeys("SuperSecretPassword!");
        
        // Clicking Login Button
        WebElement loginButton = browser.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        System.out.println("Clicked login button");
        
        browser.quit();
    }
}

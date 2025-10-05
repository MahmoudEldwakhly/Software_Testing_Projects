/*
 ============================================================================
 Name        : SeleniumBasicSetup.java
 Copyright   : Edges For Training
 Description : Basic Selenium WebDriver setup and browser initialization
 ============================================================================
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        // Create a static WebDriver instance - this opens Chrome browser
        WebDriver browser = new ChromeDriver();
        
        // Browser is now open and ready for automation
        System.out.println("Chrome browser opened successfully");
        
        // Close the browser when done
        browser.quit();
    }
}

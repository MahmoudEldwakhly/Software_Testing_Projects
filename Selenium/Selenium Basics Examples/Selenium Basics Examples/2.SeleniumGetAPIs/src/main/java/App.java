/*
 ============================================================================
 Name        : SeleniumGetAPIs.java
 Copyright   : Edges For Training
 Description : Demonstration of Selenium get methods using the-internet.herokuapp.com
 ============================================================================
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        // Initialize ChromeDriver
        WebDriver browser = new ChromeDriver();
        
        // get(String URL) - Navigate to the specified URL
        browser.get("https://the-internet.herokuapp.com/");
        
        // getCurrentUrl() - Returns the current URL as a string
        String currentUrl = browser.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        
        // getTitle() - Returns the page title as a string
        String title = browser.getTitle();
        System.out.println("Page Title: " + title);
        
        // getPageSource() - Returns the entire HTML source code
        String pageSource = browser.getPageSource();
        System.out.println("Page Source Length: " + pageSource.length() + " characters");
        
        // getWindowHandle() - Returns unique identifier of current window/tab
        String windowHandle = browser.getWindowHandle();
        System.out.println("Current Window Handle: " + windowHandle);
        
        // quit() - Closes all browser windows and ends the WebDriver session
        browser.quit();
    }
}

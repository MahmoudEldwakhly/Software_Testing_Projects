/*
 ============================================================================
 Name        : SeleniumNavigateAPIs.java
 Copyright   : Edges For Training
 Description : Demonstration of navigation methods using the-internet.herokuapp.com
 ============================================================================
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        
        // navigate().to(String url) - Navigate to specified URL
        browser.navigate().to("https://the-internet.herokuapp.com/");
        System.out.println("Navigated to homepage: " + browser.getCurrentUrl());
        
        // Navigate to login page
        browser.navigate().to("https://the-internet.herokuapp.com/login");
        System.out.println("Navigated to login page: " + browser.getCurrentUrl());
        
        // navigate().back() - Go back to previous page in browser history
        browser.navigate().back();
        System.out.println("After back: " + browser.getCurrentUrl());
        
        // navigate().forward() - Go forward to next page in browser history
        browser.navigate().forward();
        System.out.println("After forward: " + browser.getCurrentUrl());
        
        // navigate().refresh() - Refresh/reload the current page
        browser.navigate().refresh();
        System.out.println("Page refreshed: " + browser.getCurrentUrl());
        
        browser.quit();
    }
}

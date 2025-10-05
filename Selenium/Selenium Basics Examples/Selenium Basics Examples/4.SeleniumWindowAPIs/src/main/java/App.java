/*
 ============================================================================
 Name        : SeleniumWindowAPIs.java
 Copyright   : Edges For Training
 Description : Demonstration of window management methods
 ============================================================================
 */

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        browser.get("https://the-internet.herokuapp.com/");
        
        // manage().window().maximize() - Maximize the browser window
        browser.manage().window().maximize();
        System.out.println("Window maximized");
        
        // manage().window().getSize() - Get current window dimensions
        Dimension currentSize = browser.manage().window().getSize();
        System.out.println("Current size - Width: " + currentSize.width + ", Height: " + currentSize.height);
        
        // manage().window().setSize(Dimension) - Set custom window size
        browser.manage().window().setSize(new Dimension(800, 600));
        System.out.println("Window size set to 800x600");
        
        // manage().window().getPosition() - Get current window position
        Point currentPosition = browser.manage().window().getPosition();
        System.out.println("Current position - X: " + currentPosition.x + ", Y: " + currentPosition.y);
        
        // manage().window().setPosition(Point) - Set window position on screen
        browser.manage().window().setPosition(new Point(100, 100));
        System.out.println("Window position set to (100, 100)");
        
        // manage().window().fullscreen() - Enter fullscreen mode
        browser.manage().window().fullscreen();
        System.out.println("Window set to fullscreen mode");
        
        browser.quit();
    }
}

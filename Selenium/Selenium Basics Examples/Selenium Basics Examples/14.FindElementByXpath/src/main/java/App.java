/*
 ============================================================================
 Name        : FindElementByXpath.java
 Copyright   : Edges For Training
 Description : Finding elements by XPath using the-internet.herokuapp.com
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
        
        // Locate login button with XPath matching type and text
        WebElement loginButton = browser.findElement(
            By.xpath("//button[@type='submit' and normalize-space()='Login']"));
        System.out.println("Found XPath button text: " + loginButton.getText());
        
        browser.quit();
    }
}

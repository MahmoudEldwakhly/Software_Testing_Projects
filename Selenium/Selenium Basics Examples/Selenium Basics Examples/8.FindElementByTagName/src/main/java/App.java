/*
 ============================================================================
 Name        : FindElementByTagName.java
 Copyright   : Edges For Training
 Description : Finding elements by tag name using the-internet.herokuapp.com
 ============================================================================
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        browser.get("https://the-internet.herokuapp.com/");
        
        // Find the first <h1> heading on the homepage
        WebElement heading = browser.findElement(By.tagName("h1"));
        System.out.println("Found heading tag: " + heading.getTagName());
        System.out.println("Heading text: " + heading.getText());
        
        browser.quit();
    }
}

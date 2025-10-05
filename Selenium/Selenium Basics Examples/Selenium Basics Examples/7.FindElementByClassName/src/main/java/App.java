/*
 ============================================================================
 Name        : FindElementByClassName.java
 Copyright   : Edges For Training
 Description : Finding elements by class attribute using the-internet.herokuapp.com
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
        
        // Find element by class name - looking for submit button
        WebElement submitButton = browser.findElement(By.className("radius"));
        System.out.println("Found element with class: radius");
        
        // Display button information
        System.out.println("Button tag: " + submitButton.getTagName());
        System.out.println("Button text: " + submitButton.getText());
        System.out.println("Button type: " + submitButton.getAttribute("type"));
        
        browser.quit();
    }
}

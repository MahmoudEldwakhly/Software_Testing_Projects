/*
 ============================================================================
 Name        : FindElementByLinkText.java
 Copyright   : Edges For Training
 Description : Finding elements by link text using the-internet.herokuapp.com
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
        
        // Find link with exact visible text "A/B Testing"
        WebElement abTestingLink = browser.findElement(By.linkText("A/B Testing"));
        System.out.println("Found link text: " + abTestingLink.getText());
        System.out.println("Link URL: " + abTestingLink.getAttribute("href"));
        
        browser.quit();
    }
}

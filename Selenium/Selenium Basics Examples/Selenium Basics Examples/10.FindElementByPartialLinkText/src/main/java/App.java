/*
 ============================================================================
 Name        : FindElementByPartialLinkText.java
 Copyright   : Edges For Training
 Description : Finding elements by partial link text using the-internet.herokuapp.com
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
        
        // Find link containing the word "Dro"
        WebElement dropdownLink = browser.findElement(By.partialLinkText("Dro"));
        System.out.println("Found partial link text: " + dropdownLink.getText());
        System.out.println("Link URL: " + dropdownLink.getAttribute("href"));
        
        browser.quit();
    }
}

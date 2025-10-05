/*
 ============================================================================
 Name        : FindNthOfTypeCss.java
 Copyright   : Edges For Training
 Description : Locate nth-of-type using CSS selector on the-internet.herokuapp.com
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
        
        // Locate the third list item under ul > li:nth-of-type(3)
        WebElement thirdExample = browser.findElement(By.cssSelector("ul li:nth-of-type(3)"));
        System.out.println("Third example text: " + thirdExample.getText());
        
        browser.quit();
    }
}

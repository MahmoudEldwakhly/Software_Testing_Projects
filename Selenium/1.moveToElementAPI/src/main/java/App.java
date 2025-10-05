/*
 ============================================================================
 Name       : 1.moveToElement.java
 Copyright  : Edges For Training
 Description: Demonstrates mouse hover action using Selenium Actions class
 ============================================================================
*/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class App {
    // Initialize WebDriver instance used across methods
    static WebDriver browser = new ChromeDriver();

    public static void main(String[] args) {
        // Navigate to the hovers demo page on the 'the-internet' website
        browser.navigate().to("https://the-internet.herokuapp.com/hovers");

        // Create Actions instance linked to the current browser session
        Actions a1 = new Actions(browser);
        System.out.println("Hello" + Keys.TAB + Keys.ALT);
        // Locate the third image on the page by XPath and perform mouse hover
        a1.moveToElement(browser.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/img"))).perform();
    }
}

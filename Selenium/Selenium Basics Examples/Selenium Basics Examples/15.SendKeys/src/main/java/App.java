/*
 ============================================================================
 Name        : SendKeysExample.java
 Copyright   : Edges For Training
 Description : Using sendKeys to enter text into input fields
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
        
        WebElement userField = browser.findElement(By.id("username"));
        userField.sendKeys("tomsmith");
        System.out.println("Entered username: " + userField.getAttribute("value"));
        
        browser.quit();
    }
}

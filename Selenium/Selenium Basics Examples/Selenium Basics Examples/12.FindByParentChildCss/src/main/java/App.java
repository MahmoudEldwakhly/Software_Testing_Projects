/*
 ============================================================================
 Name        : FindByParentChildCss.java
 Copyright   : Edges For Training
 Description : Locate elements by parent > child CSS selector using the-internet.herokuapp.com
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
        
        // Locate the login button which is child of form#login
        WebElement loginButton = browser.findElement(By.cssSelector("form#login > button"));
        System.out.println("Found button tag: " + loginButton.getTagName());
        System.out.println("Button text: " + loginButton.getText());
        
        browser.quit();
    }
}

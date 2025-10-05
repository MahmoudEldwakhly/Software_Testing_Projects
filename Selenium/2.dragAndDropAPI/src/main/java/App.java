/*
 ============================================================================
 Name       : 2.dragAndDrop.java
 Copyright  : Edges For Training
 Description: Demonstrates drag and drop interaction using Selenium Actions class
 ============================================================================ 
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class App {
    // Initialize WebDriver as a static field to use across methods
    static WebDriver browser = new ChromeDriver();

    public static void main(String[] args) {
        // Navigate to the drag and drop demo page on 'the-internet' website
        browser.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");

        // Create a new Actions instance linked to the current browser
        Actions a1 = new Actions(browser);

        // Locate the two draggable elements by absolute XPath
        WebElement e1 = browser.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]"));
        WebElement e2 = browser.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]"));

        // Perform drag-and-drop from e1 to e2
        a1.dragAndDrop(e1, e2).perform();
    }
}

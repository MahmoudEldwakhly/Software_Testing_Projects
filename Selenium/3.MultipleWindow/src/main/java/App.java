/*
 ============================================================================
 Name       : 3.MultipleWindowHandling.java
 Copyright  : Edges For Training
 Description: Demonstrates handling and switching between multiple browser windows or tabs in Selenium
 ============================================================================
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        // Initialize a Chrome browser session
        WebDriver browser = new ChromeDriver();

        // Navigate to the page with a link that opens a new window/tab
        browser.get("https://the-internet.herokuapp.com/windows");

        // Store the original window handle
        String originalWindow = browser.getWindowHandle();

        // Click the link that opens a new window
        browser.findElement(By.linkText("Click Here")).click();

        // Wait for the new window to appear and switch to it
        Set<String> allWindows = browser.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                browser.switchTo().window(windowHandle);
                break;
            }
        }

        // Now we are in the new window/tab - print its title
        System.out.println("New window title: " + browser.getTitle());

        // Optionally, close the new window and switch back to the original window
        browser.close(); // closes current window

        // Switch back to the original window
        browser.switchTo().window(originalWindow);
        System.out.println("Back to original window title: " + browser.getTitle());

        // Clean up and quit browser
        browser.quit();
        
    }
}

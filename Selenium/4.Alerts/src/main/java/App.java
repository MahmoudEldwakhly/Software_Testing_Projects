/*
 ============================================================================
 Name        : 4.Alerts.java
 Copyright   : Edges For Training
 Description : Demonstrates Selenium Alert API functions: accept, dismiss, sendKeys, getText
               without storing Alert object, using anonymous usage
 ============================================================================
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to demo page with alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1. Simple Alert - accept()
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        System.out.println("Alert message: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();  // Click OK

        // 2. Confirmation Alert - dismiss()
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        System.out.println("Confirm message: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();  // Click Cancel

        // 3. Prompt Alert - sendKeys() and accept()
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        System.out.println("Prompt message: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Selenium Input");  // Enter text
        driver.switchTo().alert().accept();  // Click OK

        // 4. Reading alert text is demonstrated above inline in System.out.println

        driver.quit();
    }
}

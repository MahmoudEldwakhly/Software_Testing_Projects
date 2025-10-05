/*
 ============================================================================
 Name        : DropdownExample.java
 Copyright   : Edges For Training
 Description : Selecting options from a <select> dropdown
 ============================================================================
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        browser.get("https://the-internet.herokuapp.com/dropdown");
        
        WebElement dropdown = browser.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        
        select.selectByVisibleText("Option 2");
        System.out.println("Selected option: " + select.getFirstSelectedOption().getText());
        
        browser.quit();
    }
}

/*
 ============================================================================
 Name        : WebElementStateExample.java
 Copyright   : Edges For Training
 Description : Checking element states isSelected, isDisplayed, isEnabled
 ============================================================================
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        WebDriver browser = new ChromeDriver();
        browser.get("https://the-internet.herokuapp.com/checkboxes");
        
        WebElement firstCheckbox = browser.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        System.out.println("Checkbox1 displayed: " + firstCheckbox.isDisplayed());
        System.out.println("Checkbox1 enabled: " + firstCheckbox.isEnabled());
        System.out.println("Checkbox1 selected: " + firstCheckbox.isSelected());
        
        firstCheckbox.click();
        System.out.println("Checkbox1 selected after click: " + firstCheckbox.isSelected());
        
        browser.quit();
    }
}

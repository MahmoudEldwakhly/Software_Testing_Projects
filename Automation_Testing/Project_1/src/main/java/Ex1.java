import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Ex1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // ---------- Implicit Wait ----------
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        WebElement elementImplicit = driver.findElement(By.id("finish"));
        System.out.println("Implicit Wait -> '" + elementImplicit.getText() + "'");

        // ---------- Explicit Wait ----------
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementExplicit = explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish"))
        );
        System.out.println("Explicit Wait -> '" + elementExplicit.getText() + "'");

        // ---------- Fluent Wait ----------
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))       // total wait time
                .pollingEvery(Duration.ofMillis(500))      // check every 500ms
                .ignoring(Exception.class);                // ignore exceptions during polling

        WebElement elementFluent = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement el = driver.findElement(By.id("finish"));
                if (el.isDisplayed()) {
                    return el;
                }
                return null;
            }
        });

        System.out.println("Fluent Wait -> '" + elementFluent.getText() + "'");

      //  driver.quit();
    }
}

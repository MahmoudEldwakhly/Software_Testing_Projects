/*
 ============================================================================
 Name        : ReadingDataFromJSON.java
 Copyright   : Edges For Training
 Description : Page Object Model class for login page interactions using Selenium WebDriver
 ============================================================================
 */
package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Models the Login page functionality for the application.
 * Encapsulates locators and actions related to the login interface.
 */
public class Login_Page {

    // WebDriver instance to interact with browser (injected via constructor)
    public WebDriver Browser;

    // Locator for username input field
    private final By usernameLocator = By.id("username");

    // Locator for password input field
    private final By passwordLocator = By.id("password");

    // Locator for login button
    private final By loginButtonLocator = By.cssSelector(".radius > i");

    // Locator for success/failure messages
    private final By CorrectLoginLocator = By.cssSelector(".flash.success");
    private final By incorrectLoginLocator = By.cssSelector(".flash.error");

    /**
     * Waits for a specific element to be present in the DOM.
     * Used for synchronizing tests and avoiding flaky failures due to timing.
     *
     * @param locator By object representing the element to wait for
     * @param timeoutSeconds Number of seconds before timeout
     * @param driver WebDriver instance used for waiting
     */
    public static void explicitWait(By locator, int timeoutSeconds, WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        System.out.println("Edges: Explicit wait for presence of " + locator);
    }

    /**
     * Constructor initializes with the given WebDriver instance.
     *
     * @param Browser Instance for browser control
     */
    public Login_Page(WebDriver Browser) {
        this.Browser = Browser;
    }

    /**
     * Types the given username into the username input field.
     *
     * @param Text The username to enter
     */
    public void enter_user_name(String Text) {
        Browser.findElement(usernameLocator).sendKeys(Text);
    }

    /**
     * Types the given password into the password input field.
     *
     * @param Text The password to enter
     */
    public void enter_password(String Text) {
        Browser.findElement(passwordLocator).sendKeys(Text);
    }

    /**
     * Clicks the login button to submit credentials.
     */
    public void click_login() {
        Browser.findElement(loginButtonLocator).click();
    }

    /**
     * Retrieves and returns the message shown after a successful login.
     * Uses explicit wait to ensure element is present before reading text.
     *
     * @return Success message text
     */
    public String read_valid_div() {
        explicitWait(CorrectLoginLocator, 10, Browser);
        return Browser.findElement(CorrectLoginLocator).getText();
    }

    /**
     * Retrieves and returns the message shown after a failed login.
     * Uses explicit wait to ensure element is present before reading text.
     *
     * @return Invalid login message text
     */
    public String read_invalid_div() {
        explicitWait(incorrectLoginLocator, 10, Browser);
        return Browser.findElement(incorrectLoginLocator).getText();
    }
}

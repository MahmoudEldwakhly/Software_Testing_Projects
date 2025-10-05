/*
 ============================================================================
 Name        : Login_Page.java
 Copyright   : Edges For Training
 Description : Page Object Model class for login page interactions using Selenium WebDriver
 ============================================================================
 */

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Login page in the application.
 * Encapsulates all interactions with the login page elements.
 */
public class Login_Page {
    // WebDriver instance to interact with the browser
    public WebDriver Browser;

    // Locators for web elements on the login page
    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By loginButtonLocator = By.cssSelector(".radius > i");
    private final By CorrectLoginLocator = By.cssSelector(".flash.success");
    private final By incorrectLoginLocator = By.cssSelector(".flash.error");

    /**
     * Constructor to inject WebDriver instance.
     * @param Browser WebDriver to control browser actions
     */
    public Login_Page(WebDriver Browser) {
        this.Browser = Browser;
    }

    /** Enters username into the username field */
    public void enter_user_name(String Text) {
        Browser.findElement(usernameLocator).sendKeys(Text);
    }

    /** Enters password into the password field */
    public void enter_password(String Text) {
        Browser.findElement(passwordLocator).sendKeys(Text);
    }

    /** Clicks the login button */
    public void click_login() {
        Browser.findElement(loginButtonLocator).click();
    }

    /** Reads the message displayed on successful login */
    public String read_valid_div() {
        return Browser.findElement(CorrectLoginLocator).getText();
    }

    /** Reads the message displayed on failed login */
    public String read_invalid_div() {
        return Browser.findElement(incorrectLoginLocator).getText();
    }
}

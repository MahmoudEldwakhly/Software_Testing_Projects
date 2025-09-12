package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class LoginPage {
    private SeleniumFrameWork framework;
    
    // Locators with data-qa attributes
    private By signupName = By.cssSelector("input[data-qa='signup-name']");
    private By signupEmail = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private By newUserSignupText = By.cssSelector("div.signup-form h2");
    
    // Login locators
    private By loginEmail = By.cssSelector("input[data-qa='login-email']");
    private By loginPassword = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By loginAccountText = By.cssSelector("div.login-form h2");
    
    public LoginPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }
    
    public boolean isNewUserSignupVisible() {
        try {
            framework.explicitWait(newUserSignupText, 10);
            String text = framework.getText(newUserSignupText);
            return text.contains("New User Signup!") || text.contains("Signup");
        } catch (Exception e) {
            System.out.println("New User Signup text not found: " + e.getMessage());
            return false;
        }
    }
    
    public boolean isLoginToAccountVisible() {
        try {
            framework.explicitWait(loginAccountText, 10);
            String text = framework.getText(loginAccountText);
            return text.contains("Login to your account") || text.contains("Login");
        } catch (Exception e) {
            System.out.println("Login to account text not found: " + e.getMessage());
            return false;
        }
    }
    
    public void enterSignupName(String name) {
        framework.explicitWait(signupName, 10);
        framework.sendKeys(signupName, name);
    }
    
    public void enterSignupEmail(String email) {
        framework.explicitWait(signupEmail, 10);
        framework.sendKeys(signupEmail, email);
    }
    
    public void clickSignup() {
        framework.explicitWait(signupButton, 10);
        framework.click(signupButton);
    }
    
    public void enterLoginEmail(String email) {
        framework.explicitWait(loginEmail, 10);
        framework.sendKeys(loginEmail, email);
    }
    
    public void enterLoginPassword(String password) {
        framework.explicitWait(loginPassword, 10);
        framework.sendKeys(loginPassword, password);
    }
    
    public void clickLogin() {
        framework.explicitWait(loginButton, 10);
        framework.click(loginButton);
    }
}
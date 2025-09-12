package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class HomePage {
    private SeleniumFrameWork framework;
    
    // Locators with data-qa attributes
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By loggedInAs = By.cssSelector("a:has(> i.fa-user)");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    
    public HomePage(SeleniumFrameWork framework) {
        this.framework = framework;
    }
    
    public void navigateToHomePage(String url) {
        framework.navigateToURL(url);
    }
    
    public void clickSignupLogin() {
        framework.explicitWait(signupLoginButton, 10);
        framework.click(signupLoginButton);
    }
    
    public boolean isLoggedInAsVisible() {
        try {
            framework.explicitWait(loggedInAs, 10);
            return framework.getText(loggedInAs).contains("Logged in as");
        } catch (Exception e) {
            return false;
        }
    }
    
    public void clickDeleteAccount() {
        framework.explicitWait(deleteAccountButton, 10);
        framework.click(deleteAccountButton);
    }
    
    public boolean isHomePageVisible() {
        return framework.getPageTitle().contains("Automation Exercise");
    }
}
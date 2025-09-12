package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class HomePage {
    private SeleniumFrameWork framework;
    
    // Locators
    private By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    private By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
    
    public HomePage(SeleniumFrameWork framework) {
        this.framework = framework;
    }
    
    public void navigateToHomePage(String url) {
        framework.navigateToURL(url);
    }
    
    public void clickSignupLogin() {
        framework.click(signupLoginButton);
    }
    
    public boolean isLoggedInAsVisible() {
        try {
            return framework.getText(loggedInAs).contains("Logged in as");
        } catch (Exception e) {
            return false;
        }
    }
    
    public void clickDeleteAccount() {
        framework.click(deleteAccountButton);
    }
    
    public boolean isHomePageVisible() {
        return framework.getPageTitle().contains("Automation Exercise");
    }
}
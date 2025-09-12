package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class RegistrationPage {
    private SeleniumFrameWork framework;
    
    // Locators
    private By accountCreatedText = By.cssSelector("h2[data-qa='account-created']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");
    private By accountDeletedText = By.cssSelector("h2[data-qa='account-deleted']");
    
    public RegistrationPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }
    
    public boolean isAccountCreatedVisible() {
        try {
            // Add explicit wait and try multiple locators
            framework.explicitWait(accountCreatedText, 10);
            String text = framework.getText(accountCreatedText);
            return text.contains("ACCOUNT CREATED!") || text.contains("Account Created");
        } catch (Exception e) {
            System.out.println("Account Created text not found: " + e.getMessage());
            
            // Try alternative locators
            try {
                By alternativeLocator = By.xpath("//h2[contains(text(),'created') or contains(text(),'Created')]");
                framework.explicitWait(alternativeLocator, 5);
                String altText = framework.getText(alternativeLocator);
                return altText.contains("ACCOUNT CREATED!") || altText.contains("Account Created");
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    public boolean isAccountDeletedVisible() {
        try {
            framework.explicitWait(accountDeletedText, 10);
            String text = framework.getText(accountDeletedText);
            return text.contains("ACCOUNT DELETED!") || text.contains("Account Deleted");
        } catch (Exception e) {
            System.out.println("Account Deleted text not found: " + e.getMessage());
            return false;
        }
    }
    
    public void clickContinue() {
        try {
            framework.click(continueButton);
        } catch (Exception e) {
            System.out.println("Continue button not found with primary locator, trying alternatives...");
            // Try alternative locators
            try {
                By alternativeLocator = By.xpath("//a[contains(text(),'Continue')]");
                framework.click(alternativeLocator);
            } catch (Exception ex) {
                System.out.println("Continue button not found with alternative locator either");
            }
        }
    }
}
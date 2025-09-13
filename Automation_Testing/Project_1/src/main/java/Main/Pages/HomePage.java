package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class HomePage {
    private SeleniumFrameWork framework;
    
    // Locators
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By loggedInAs = By.cssSelector("a:has(> i.fa-user)");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private By logoutButton = By.cssSelector("a[href='/logout']");
    private By testCasesButton = By.cssSelector("a[href='/test_cases']");
    private By productsButton = By.cssSelector("a[href='/products']");
    
    // Subscription section
    private By subscriptionText = By.xpath("//h2[contains(text(),'Subscription')]");
    private By subscriptionInput = By.id("susbscribe_email");
    private By subscriptionButton = By.id("subscribe");
    private By successMessage = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");

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

    public void clickLogout() {
        framework.explicitWait(logoutButton, 10);
        framework.click(logoutButton);
        System.out.println("Clicked Logout button");
    }

    public void clickTestCases() {
        framework.explicitWait(testCasesButton, 10);
        framework.click(testCasesButton);
        System.out.println("Clicked Test Cases button");
    }

    public void clickProducts() {
        framework.explicitWait(productsButton, 10);
        framework.click(productsButton);
        System.out.println("Clicked Products button");
    }

    public void scrollToSubscription() {
        framework.scrollToElement(subscriptionText);
        System.out.println("Scrolled to Subscription section");
    }

    public boolean isSubscriptionTextVisible() {
        try {
            framework.explicitWait(subscriptionText, 10);
            return framework.getText(subscriptionText).toLowerCase().contains("subscription");
        } catch (Exception e) {
            return false;
        }
    }

    public void enterSubscriptionEmail(String email) {
        framework.sendKeys(subscriptionInput, email);
    }

    public void clickSubscribeButton() {
        framework.click(subscriptionButton);
    }

    public boolean isSubscriptionSuccessMessageVisible() {
        try {
            framework.explicitWait(successMessage, 10);
            String text = framework.getText(successMessage);
            return text.contains("You have been successfully subscribed!");
        } catch (Exception e) {
            return false;
        }
    }
}

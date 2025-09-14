package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class CheckoutPage {
    private SeleniumFrameWork framework;

    // Locators
    private By proceedToCheckoutButton = By.cssSelector("a.check_out");
    private By registerLoginButton = By.xpath("//u[contains(text(),'Register / Login')]");
    private By addressDetails = By.cssSelector("#address_delivery");
    private By reviewOrder = By.cssSelector("#cart_info");
    private By commentTextArea = By.name("message");
    private By placeOrderButton = By.cssSelector("a.check_out");

    public CheckoutPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    public void clickProceedToCheckout() {
        framework.explicitWait(proceedToCheckoutButton, 10);
        framework.click(proceedToCheckoutButton);
    }

    public void clickRegisterLogin() {
        framework.explicitWait(registerLoginButton, 10);
        framework.click(registerLoginButton);
    }

    public boolean isAddressDetailsVisible() {
        try {
            framework.explicitWait(addressDetails, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isReviewOrderVisible() {
        try {
            framework.explicitWait(reviewOrder, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void enterComment(String text) {
        framework.explicitWait(commentTextArea, 10);
        framework.sendKeys(commentTextArea, text);
    }

    public void clickPlaceOrder() {
        framework.explicitWait(placeOrderButton, 10);
        framework.click(placeOrderButton);
    }
}

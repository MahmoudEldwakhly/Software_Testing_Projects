package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class CheckoutPage {
    private final SeleniumFrameWork framework;

    // Cart/checkout controls
    private final By proceedToCheckoutBtn = By.cssSelector("a.check_out");
    private final By placeOrderBtn = By.cssSelector("a.check_out"); // reused in some flows after comment
    private final By registerLoginLink = By.xpath("//u[contains(text(),'Register / Login')]");
    private final By reviewOrderTable = By.cssSelector("#cart_info");
    private final By commentTextarea = By.name("message");

    // Address boxes on checkout page
    private final By deliveryAddressBox = By.cssSelector("#address_delivery");
    private final By billingAddressBox  = By.cssSelector("#address_invoice");

    public CheckoutPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    // Clicks the Proceed To Checkout button on the cart page
    public void clickProceedToCheckout() {
        framework.explicitWait(proceedToCheckoutBtn, 10);
        framework.click(proceedToCheckoutBtn);
    }

    // Opens the Register / Login flow from the order summary
    public void clickRegisterLogin() {
        framework.explicitWait(registerLoginLink, 10);
        framework.click(registerLoginLink);
    }

    // Verifies the address section is visible
    public boolean isAddressDetailsVisible() {
        try {
            framework.explicitWait(deliveryAddressBox, 10);
            framework.explicitWait(billingAddressBox, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Verifies the review-order table is visible
    public boolean isReviewOrderVisible() {
        try {
            framework.explicitWait(reviewOrderTable, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Types a comment in the order textarea
    public void enterComment(String text) {
        framework.explicitWait(commentTextarea, 10);
        framework.sendKeys(commentTextarea, text);
    }

    // Clicks Place Order (in this site the same styled control is reused)
    public void clickPlaceOrder() {
        framework.explicitWait(placeOrderBtn, 10);
        framework.click(placeOrderBtn);
    }

    // Helper to verify the cart page is displayed before checkout
    public boolean isProceedToCheckoutVisible() {
        try {
            framework.explicitWait(proceedToCheckoutBtn, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Returns the full visible text of the delivery address block
    public String getDeliveryAddressText() {
        framework.explicitWait(deliveryAddressBox, 10);
        return framework.getText(deliveryAddressBox);
    }

    // Returns the full visible text of the billing address block
    public String getBillingAddressText() {
        framework.explicitWait(billingAddressBox, 10);
        return framework.getText(billingAddressBox);
    }
}

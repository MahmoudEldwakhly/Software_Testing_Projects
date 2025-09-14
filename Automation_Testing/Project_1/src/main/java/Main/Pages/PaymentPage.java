package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class PaymentPage {
    private final SeleniumFrameWork framework;

    // Existing locators
    private final By nameOnCard   = By.name("name_on_card");
    private final By cardNumber   = By.name("card_number");
    private final By cvc          = By.name("cvc");
    private final By expiryMonth  = By.name("expiry_month");
    private final By expiryYear   = By.name("expiry_year");
    private final By payButton    = By.id("submit");
    private final By successAlert = By.cssSelector(".alert-success");

    // New locators for this test
    private final By downloadInvoiceBtn = By.xpath("//a[contains(.,'Download Invoice')]");
    private final By continueAfterOrder = By.xpath("//a[contains(.,'Continue')]");

    public PaymentPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    // Fill payment form
    public void fillPaymentDetails(String name, String number, String cvcStr, String month, String year) {
        framework.explicitWait(nameOnCard, 10);
        framework.sendKeys(nameOnCard, name);
        framework.sendKeys(cardNumber, number);
        framework.sendKeys(cvc, cvcStr);
        framework.sendKeys(expiryMonth, month);
        framework.sendKeys(expiryYear, year);
    }

    // Click Pay & Confirm with resilient click
    public void clickPayAndConfirm() {
        try {
            framework.explicitWait(payButton, 10);
            framework.click(payButton);
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JavaScript click...");
            framework.clickWithJS(payButton);
        }
    }

    // Verify order success banner
    public boolean isSuccessMessageVisible() {
        try {
            framework.explicitWait(successAlert, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // New: click Download Invoice
    public void clickDownloadInvoice() {
        framework.explicitWait(downloadInvoiceBtn, 10);
        try { framework.click(downloadInvoiceBtn); }
        catch (Exception e) { framework.clickWithJS(downloadInvoiceBtn); }
    }

    // New: click Continue on the order success page
    public void clickContinueAfterOrder() {
        framework.explicitWait(continueAfterOrder, 10);
        try { framework.click(continueAfterOrder); }
        catch (Exception e) { framework.clickWithJS(continueAfterOrder); }
    }
}

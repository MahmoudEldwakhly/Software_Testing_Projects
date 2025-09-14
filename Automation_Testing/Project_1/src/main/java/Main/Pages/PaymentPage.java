package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class PaymentPage {
    private SeleniumFrameWork framework;

    // Locators
    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");
    private By payButton = By.id("submit");
    private By successMessage = By.xpath("//*[contains(text(),'ORDER PLACED') or contains(text(),'Your order has been confirmed')]");



    public PaymentPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    // Fill payment details
    public void fillPaymentDetails(String name, String number, String cvcCode, String month, String year) {
        framework.explicitWait(nameOnCard, 10);
        framework.sendKeys(nameOnCard, name);

        framework.explicitWait(cardNumber, 10);
        framework.sendKeys(cardNumber, number);

        framework.explicitWait(cvc, 10);
        framework.sendKeys(cvc, cvcCode);

        framework.explicitWait(expiryMonth, 10);
        framework.sendKeys(expiryMonth, month);

        framework.explicitWait(expiryYear, 10);
        framework.sendKeys(expiryYear, year);
    }

    // Click Pay and Confirm (safe fallback to JS click if intercepted)
    public void clickPayAndConfirm() {
        framework.explicitWait(payButton, 10);
        try {
            framework.click(payButton); // normal Selenium click
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JavaScript click...");
            framework.clickWithJs(payButton); // fallback JS click
        }
    }

    // Verify success message is visible
    public boolean isSuccessMessageVisible() {
        try {
            framework.explicitWait(successMessage, 10);
            return framework.getText(successMessage)
                    .contains("Congratulations! Your order has been confirmed!");
        } catch (Exception e) {
            return false;
        }
    }
}

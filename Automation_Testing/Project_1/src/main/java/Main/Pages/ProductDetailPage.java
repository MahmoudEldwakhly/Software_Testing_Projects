package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class ProductDetailPage {
    private SeleniumFrameWork framework;

    // Locators
    private By productDetail = By.cssSelector(".product-information");
    private By quantityInput = By.id("quantity");
    private By addToCartButton = By.cssSelector("button.cart");

    private By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");

    public ProductDetailPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    // Verify product detail page is visible
    public boolean isProductDetailVisible() {
        try {
            framework.explicitWait(productDetail, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Set product quantity
    public void setQuantity(String qty) {
        framework.explicitWait(quantityInput, 10);
        // Clear the field then set value
        framework.clearAndSendKeys(quantityInput, qty);
    }

    // Click Add to Cart
    public void clickAddToCart() {
        framework.explicitWait(addToCartButton, 10);
        framework.click(addToCartButton);
    }

    // Click View Cart
    public void clickViewCart() {
        framework.explicitWait(viewCartButton, 10);
        framework.click(viewCartButton);
    }
}

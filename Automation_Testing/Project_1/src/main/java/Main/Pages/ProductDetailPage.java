package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class ProductDetailPage {
    private SeleniumFrameWork framework;

    // Existing locators (kept)
    private By productDetail = By.cssSelector(".product-information");
    private By quantityInput = By.id("quantity");
    private By addToCartButton = By.cssSelector("button.cart");
    private By viewCartButton = By.cssSelector("a[href='/view_cart']");

    // --- Review section locators (added) ---
    private By reviewsTab = By.cssSelector("a[href='#reviews']");
    private By writeReviewHeader = By.xpath("//*[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'WRITE YOUR REVIEW')]");
    private By reviewNameInput = By.id("name");
    private By reviewEmailInput = By.id("email");
    private By reviewTextArea = By.id("review");
    private By submitReviewButton = By.id("button-review");
    private By reviewSuccessMsg = By.xpath("//*[contains(text(),'Thank you for your review.')]");

    public ProductDetailPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    // Existing methods (kept)
    public boolean isProductDetailVisible() {
        try {
            framework.explicitWait(productDetail, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setQuantity(String qty) {
        framework.explicitWait(quantityInput, 10);
        framework.clearAndSendKeys(quantityInput, qty);
    }

    public void clickAddToCart() {
        framework.explicitWait(addToCartButton, 10);
        framework.click(addToCartButton);
    }

    public void clickViewCart() {
        framework.explicitWait(viewCartButton, 10);
        framework.click(viewCartButton);
    }

    // ---------------- Review helpers (added) ----------------

    /** Some pages require switching to the Reviews tab before the form appears. */
    public void openReviewsTabIfPresent() {
        try {
            framework.explicitWait(reviewsTab, 3);
            framework.click(reviewsTab);
        } catch (Exception ignore) {
            // If not present, the form is already visible; proceed silently.
        }
    }

    /** Verifies the "Write Your Review" section is visible. */
    public boolean isWriteYourReviewVisible() {
        try {
            framework.explicitWait(writeReviewHeader, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Fills the review form (name, email, review) and submits it. */
    public void submitReview(String name, String email, String reviewText) {
        framework.explicitWait(reviewNameInput, 10);
        framework.sendKeys(reviewNameInput, name);

        framework.explicitWait(reviewEmailInput, 10);
        framework.sendKeys(reviewEmailInput, email);

        framework.explicitWait(reviewTextArea, 10);
        framework.sendKeys(reviewTextArea, reviewText);

        framework.explicitWait(submitReviewButton, 10);
        try {
            framework.scrollToElement(submitReviewButton);
        } catch (Exception ignore) {}
        // Use a robust click in case of overlays
        try {
            framework.click(submitReviewButton);
        } catch (Exception e) {
            framework.clickWithJS(submitReviewButton);
        }
    }

    /** Checks for the green success message after submitting a review. */
    public boolean isReviewSuccessVisible() {
        try {
            framework.explicitWait(reviewSuccessMsg, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

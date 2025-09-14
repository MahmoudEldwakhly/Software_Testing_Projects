package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

/**
 * Page Object: Home page (header nav, footer subscription, and recommended items).
 * <p>
 * Notes:
 * - Keeps backward-compatibility aliases used by older tests (e.g., scrollToSubscription, clickTestCases).
 * - Does not remove or rename any existing methods to avoid breaking previous test cases.
 */
public class HomePage {
    private final SeleniumFrameWork framework;

    // ------------------------------ Header / top navigation ------------------------------

    /** "Products" link in the header navigation bar. */
    private final By productsLink      = By.cssSelector("a[href='/products']");
    /** "Cart" link in the header navigation bar. */
    private final By cartLink          = By.cssSelector("a[href='/view_cart']");
    /** "Signup / Login" link in the header navigation bar. */
    private final By signupLoginLink   = By.cssSelector("a[href='/login']");
    /** "Logout" link in the header navigation bar. */
    private final By logoutLink        = By.cssSelector("a[href='/logout']");
    /** "Delete Account" link in the header navigation bar. */
    private final By deleteAccountLink = By.cssSelector("a[href='/delete_account']");
    /** "Test Cases" link in the header navigation bar. */
    private final By testCasesLink     = By.cssSelector("a[href='/test_cases']");
    /** "Logged in as &lt;username&gt;" label shown when a user is authenticated. */
    private final By loggedInAs        = By.cssSelector("a:has(> i.fa-user)");

    // ------------------------------ Footer subscription section ------------------------------

    /** "SUBSCRIPTION" title in the footer (robust upper-case match). */
    /* convert that text to UPPERCASE. XPath 1.0 doesn’t have case-insensitive matching, so we map every lowercase letter to its uppercase equivalent.*/
    private final By subscriptionTitle = By.xpath(
        "//footer//h2[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'SUBSCRIPTION')]"
    );
    /**
     * Email input in subscription form.
     * Site uses a misspelled id attribute 'susbscribe_email' (kept as-is).
     */
    private final By subscriptionEmail   = By.id("susbscribe_email");
    /** Subscribe/arrow button in subscription form. */
    private final By subscriptionButton  = By.id("subscribe");
    /** Success toast/text shown after subscribing. */
    private final By subscriptionSuccess = By.xpath("//*[contains(.,'You have been successfully subscribed')]");

    // ------------------------------ Recommended items widget ------------------------------

    /** "RECOMMENDED ITEMS" title container. */
    private final By recommendedTitle          = By.xpath("//div[contains(@class,'recommended_items')]//h2");
    /** First "Add to cart" button inside the recommended items widget. */
    private final By recommendedAddToCartFirst = By.xpath("(//div[contains(@class,'recommended_items')]//a[contains(text(),'Add to cart')])[1]");
    /** Underlined "View Cart" text inside the add-to-cart modal. */
    private final By viewCartUnderlineInModal  = By.xpath("//u[contains(text(),'View Cart')]");
    /** Fallback "View Cart" link in modal (plain anchor). */
    private final By viewCartLinkInModal       = By.cssSelector("a[href='/view_cart']");

    public HomePage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    // ======================================================================================
    // Navigation helpers
    // ======================================================================================

    /** Navigate to the given URL (name preferred by some tests). */
    public void navigateToURL(String url) {
        framework.navigateToURL(url);
    }

    /** Navigate to the given URL (legacy alias kept for older tests). */
    public void navigateToHomePage(String url) {
        framework.navigateToURL(url);
    }

    /** Returns true when the home page header has loaded (uses presence of "Products" link). */
    public boolean isHomePageVisible() {
        try { framework.explicitWait(productsLink, 10); return true; }
        catch (Exception e) { return false; }
    }

    // ======================================================================================
    // Header actions
    // ======================================================================================

    /** Open the Products catalog from the header. */
    public void clickProducts() {
        framework.explicitWait(productsLink, 10);
        try { framework.click(productsLink); } catch (Exception e) { framework.clickWithJS(productsLink); }
        System.out.println("Clicked Products button");
    }

    /** Open the Cart from the header. */
    public void clickCart() {
        framework.explicitWait(cartLink, 10);
        try { framework.click(cartLink); } catch (Exception e) { framework.clickWithJS(cartLink); }
        System.out.println("Clicked Cart button");
    }

    /** Open the Signup/Login page from the header. */
    public void clickSignupLogin() {
        framework.explicitWait(signupLoginLink, 10);
        try { framework.click(signupLoginLink); } catch (Exception e) { framework.clickWithJS(signupLoginLink); }
    }

    /** Click the Logout link in the header. */
    public void clickLogout() {
        framework.explicitWait(logoutLink, 10);
        try { framework.click(logoutLink); } catch (Exception e) { framework.clickWithJS(logoutLink); }
    }

    /** Click the Delete Account link in the header. */
    public void clickDeleteAccount() {
        framework.explicitWait(deleteAccountLink, 10);
        try { framework.click(deleteAccountLink); } catch (Exception e) { framework.clickWithJS(deleteAccountLink); }
    }

    /** Open the Test Cases page (legacy alias used by some tests). */
    public void clickTestCases() {
        framework.explicitWait(testCasesLink, 10);
        try { framework.click(testCasesLink); } catch (Exception e) { framework.clickWithJS(testCasesLink); }
    }

    /** Returns true if the "Logged in as &lt;username&gt;" label is visible. */
    public boolean isLoggedInAsVisible() {
        try { framework.explicitWait(loggedInAs, 10); return true; }
        catch (Exception e) { return false; }
    }

    /** Returns the full "Logged in as &lt;username&gt;" text, or empty string if not present. */
    public String getLoggedInAsText() {
        try { framework.explicitWait(loggedInAs, 10); return framework.getText(loggedInAs); }
        catch (Exception e) { return ""; }
    }

    // ======================================================================================
    // Footer subscription
    // ======================================================================================

    /** Scroll the page to the footer subscription section. */
    public void scrollToFooter() {
        try { framework.scrollToElement(subscriptionTitle); } catch (Exception ignore) {}
    }

    /** Legacy alias used by older tests: scroll to the subscription section. */
    public void scrollToSubscription() { scrollToFooter(); }

    /** Returns true if the "SUBSCRIPTION" footer title is visible. */
    public boolean isSubscriptionVisible() {
        try {
            framework.explicitWait(subscriptionTitle, 10);
            String t = framework.getText(subscriptionTitle);
            return t != null && t.trim().toUpperCase().contains("SUBSCRIPTION");
        } catch (Exception e) {
            return false;
        }
    }

    /** Legacy alias used by older tests: same as {@link #isSubscriptionVisible()}. */
    public boolean isSubscriptionTextVisible() { return isSubscriptionVisible(); }

    /** Type an email address into the subscription input field. */
    public void enterSubscriptionEmail(String email) {
        framework.explicitWait(subscriptionEmail, 10);
        framework.clearAndSendKeys(subscriptionEmail, email);
    }

    /** Click the subscription arrow/button. */
    public void clickSubscriptionArrow() {
        framework.explicitWait(subscriptionButton, 10);
        try { framework.click(subscriptionButton); } catch (Exception e) { framework.clickWithJS(subscriptionButton); }
    }

    /** Legacy alias used by older tests: click the subscribe button. */
    public void clickSubscribeButton() { clickSubscriptionArrow(); }

    /** Returns true when the subscription success message is visible. */
    public boolean isSubscriptionSuccessVisible() {
        try { framework.explicitWait(subscriptionSuccess, 10); return true; }
        catch (Exception e) { return false; }
    }

    /** Legacy alias used by older tests: same as {@link #isSubscriptionSuccessVisible()}. */
    public boolean isSubscriptionSuccessMessageVisible() { return isSubscriptionSuccessVisible(); }

    // ======================================================================================
    // Recommended items (home page widget)
    // ======================================================================================

    /** Scroll the page so the "RECOMMENDED ITEMS" widget is in view. */
    public void scrollToRecommended() {
        try { framework.scrollToElement(recommendedTitle); } catch (Exception ignore) {}
    }

    /** Returns true if the "RECOMMENDED ITEMS" title is visible. */
    public boolean isRecommendedVisible() {
        try {
            framework.explicitWait(recommendedTitle, 10);
            String t = framework.getText(recommendedTitle);
            return t != null && t.trim().toUpperCase().contains("RECOMMENDED ITEMS");
        } catch (Exception e) {
            return false;
        }
    }

    /** Clicks "Add to cart" for the first product within the recommended items widget. */
    public void addFirstRecommendedToCart() {
        framework.explicitWait(recommendedAddToCartFirst, 10);
        try { framework.click(recommendedAddToCartFirst); } catch (Exception e) { framework.clickWithJS(recommendedAddToCartFirst); }
    }

    /**
     * In the add-to-cart modal, click "View Cart".
     * Tries the underlined text first, then falls back to the standard link.
     */
    public void clickViewCartFromModal() {
        try {
            framework.explicitWait(viewCartUnderlineInModal, 5);
            framework.click(viewCartUnderlineInModal);
            return;
        } catch (Exception ignore) { }
        framework.explicitWait(viewCartLinkInModal, 10);
        try { framework.click(viewCartLinkInModal); } catch (Exception e) { framework.clickWithJS(viewCartLinkInModal); }
    }
}

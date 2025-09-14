package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaceOrderLoginBeforeCheckoutTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;
    private RegistrationPage registrationPage;

    // Reuse a known existing account on AutomationExercise
    private final String EXISTING_EMAIL = "mahmoudaldwakhly53@gmail.com";
    private final String EXISTING_PASSWORD = "123456789";

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
        loginPage = new LoginPage(framework);
        productsPage = new ProductsPage(framework);
        productDetailPage = new ProductDetailPage(framework);
        cartPage = new CartPage(framework);
        checkoutPage = new CheckoutPage(framework);
        paymentPage = new PaymentPage(framework);
        registrationPage = new RegistrationPage(framework);
    }

    @Test
    public void testPlaceOrderLoginBeforeCheckout() {
        // Open site and verify landing
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Go to login and sign in with existing credentials
        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.isLoginToAccountVisible(), "Login form not visible");
        loginPage.enterLoginEmail(EXISTING_EMAIL);
        loginPage.enterLoginPassword(EXISTING_PASSWORD);
        loginPage.clickLogin();

        // Confirm user state in header
        Assert.assertTrue(homePage.isLoggedInAsVisible(), "Logged in as username not visible");

        // Add a product to cart from Products → first product detail page
        homePage.clickProducts();
        productsPage.clickFirstProductView();
        productDetailPage.clickAddToCart();
        productDetailPage.clickViewCart();

        // Ensure the cart shows at least one product (quantity cell has a value)
        String qty = cartPage.getFirstProductQuantity();
        Assert.assertTrue(qty != null && !qty.isEmpty(), "Cart page not showing product/quantity");

        // Proceed to checkout and verify address + order review sections
        checkoutPage.clickProceedToCheckout();
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details not visible");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order not visible");

        // Add a small order comment and place the order
        checkoutPage.enterComment("Please deliver between 9am-5pm.");
        checkoutPage.clickPlaceOrder();

        // Fill payment info and confirm
        paymentPage.fillPaymentDetails("Login User", "4111111111111111", "123", "12", "2026");
        paymentPage.clickPayAndConfirm();
        Assert.assertTrue(paymentPage.isSuccessMessageVisible(), "Success message not visible");

        // Clean up account per test case
        homePage.clickDeleteAccount();
        Assert.assertTrue(registrationPage.isAccountDeletedVisible(), "Account deletion failed");
        registrationPage.clickContinue();
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}

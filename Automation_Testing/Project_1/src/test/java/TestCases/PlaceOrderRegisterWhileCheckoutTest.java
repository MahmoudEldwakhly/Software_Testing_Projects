package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaceOrderRegisterWhileCheckoutTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private RegistrationPage registrationPage;
    private PaymentPage paymentPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
        productsPage = new ProductsPage(framework);
        productDetailPage = new ProductDetailPage(framework);
        cartPage = new CartPage(framework);
        checkoutPage = new CheckoutPage(framework);
        loginPage = new LoginPage(framework);
        signupPage = new SignupPage(framework);
        registrationPage = new RegistrationPage(framework);
        paymentPage = new PaymentPage(framework);
    }

    @Test
    public void testPlaceOrderRegisterWhileCheckout() {
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Add a product to cart
        homePage.clickProducts();
        productsPage.clickFirstProductView();
        productDetailPage.setQuantity("2");
        productDetailPage.clickAddToCart();
        productDetailPage.clickViewCart();

        // Verify cart page and proceed
        Assert.assertTrue(cartPage.getFirstProductQuantity().equals("2"), "Cart not showing product");
        checkoutPage.clickProceedToCheckout();

        // Click Register/Login
        checkoutPage.clickRegisterLogin();

        // Register new account
        String uniqueEmail = "orderuser" + System.currentTimeMillis() + "@example.com";
        loginPage.enterSignupName("Order User");
        loginPage.enterSignupEmail(uniqueEmail);
        loginPage.clickSignup();

        Assert.assertTrue(signupPage.isAccountInfoVisible(), "Account info page not visible");
        signupPage.selectTitle("Mr");
        signupPage.enterPassword("orderpass123");
        signupPage.selectDateOfBirth("10", "5", "1995");
        signupPage.checkNewsletter();
        signupPage.checkOffers();
        signupPage.enterAddressInfo("Order", "User", "Order Company", "123 Street", "Apt 5", "United States",
                "CA", "Los Angeles", "90001", "1234567890");
        signupPage.clickCreateAccount();

        Assert.assertTrue(registrationPage.isAccountCreatedVisible(), "Account creation failed");
        registrationPage.clickContinue();

        // Verify logged in
        Assert.assertTrue(homePage.isLoggedInAsVisible(), "Logged in as not visible");

        // Go back to cart and checkout
        homePage.clickCart();
        checkoutPage.clickProceedToCheckout();
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details not visible");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order not visible");

        // Enter comment and place order
        checkoutPage.enterComment("Please deliver between 9am-5pm.");
        checkoutPage.clickPlaceOrder();

        // Enter payment and confirm
        paymentPage.fillPaymentDetails("Order User", "4111111111111111", "123", "12", "2026");
        paymentPage.clickPayAndConfirm();
        Assert.assertTrue(paymentPage.isSuccessMessageVisible(), "Success message not visible");

        // Delete account
        homePage.clickDeleteAccount();
        Assert.assertTrue(registrationPage.isAccountDeletedVisible(), "Account deletion failed");
        registrationPage.clickContinue();
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}

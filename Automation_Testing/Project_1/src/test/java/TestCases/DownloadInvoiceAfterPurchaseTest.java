package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadInvoiceAfterPurchaseTest {

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
    public void testDownloadInvoiceAfterPurchase() throws Exception {
        // Open site and verify home
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Add a product to cart
        homePage.clickProducts();
        productsPage.clickFirstProductView();
        productDetailPage.clickAddToCart();
        productDetailPage.clickViewCart();

        // Verify cart page has at least one row
        String qty = cartPage.getFirstProductQuantity();
        Assert.assertTrue(!qty.isEmpty(), "Cart page not displayed / empty");

        // Checkout then go to Register/Login
        checkoutPage.clickProceedToCheckout();
        checkoutPage.clickRegisterLogin();

        // Sign up a new user
        String email = "invoiceuser" + System.currentTimeMillis() + "@example.com";
        loginPage.enterSignupName("Invoice User");
        loginPage.enterSignupEmail(email);
        loginPage.clickSignup();

        Assert.assertTrue(signupPage.isAccountInfoVisible(), "Account info page not visible");
        signupPage.selectTitle("Mr");
        signupPage.enterPassword("invoicePass123");
        signupPage.selectDateOfBirth("14", "2", "2003");
        signupPage.checkNewsletter();
        signupPage.checkOffers();
        signupPage.enterAddressInfo(
                "Invoice", "User", "Invoice Co",
                "123 Street", "Apt 5",
                "United States", "CA", "Los Angeles", "90001", "1234567890"
        );
        signupPage.clickCreateAccount();

        Assert.assertTrue(registrationPage.isAccountCreatedVisible(), "Account creation failed");
        registrationPage.clickContinue();
        Assert.assertTrue(homePage.isLoggedInAsVisible(), "Logged in as not visible");

        // Back to cart and proceed again
        homePage.clickCart();
        checkoutPage.clickProceedToCheckout();
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details not visible");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order not visible");

        // Leave a note and place order
        checkoutPage.enterComment("Please deliver invoice by email too.");
        checkoutPage.clickPlaceOrder();

        // Pay
        paymentPage.fillPaymentDetails("Invoice User", "4111111111111111", "123", "12", "2026");
        paymentPage.clickPayAndConfirm();
        Assert.assertTrue(paymentPage.isSuccessMessageVisible(), "Order success message not visible");

        // Prepare download verification 
        long clickTime = System.currentTimeMillis();
        Path downloads = getDefaultDownloadsDir();
        // Create folder if it doesn't exist so Files.list won't fail
        if (downloads != null && !Files.exists(downloads)) {
            try { Files.createDirectories(downloads); } catch (Exception ignored) {}
        }

        // Click "Download Invoice" and verify a new invoice*.txt appears
        paymentPage.clickDownloadInvoice();
        boolean downloaded = waitForNewInvoice(downloads, clickTime, 15);
        Assert.assertTrue(downloaded, "Invoice was not downloaded into the default Downloads folder");

        // Continue and delete account
        paymentPage.clickContinueAfterOrder();
        homePage.clickDeleteAccount();
        Assert.assertTrue(registrationPage.isAccountDeletedVisible(), "Account deletion failed");
        registrationPage.clickContinue();
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }

    // ---------- helpers (kept inside test; no framework change) ----------
    private Path getDefaultDownloadsDir() {
        try {
            String userHome = System.getProperty("user.home");
            if (userHome == null) return null;
            // Windows & macOS & most Linux desktops
            return Paths.get(userHome, "Downloads");
        } catch (Exception e) {
            return null;
        }
    }

    private boolean waitForNewInvoice(Path downloadsDir, long sinceMillis, int timeoutSeconds) throws Exception {
        if (downloadsDir == null) return false;
        int waited = 0;
        while (waited < timeoutSeconds) {
            if (Files.exists(downloadsDir)) {
                try {
                    boolean found = Files.list(downloadsDir)
                            .filter(Files::isRegularFile)
                            .map(Path::toFile)
                            .anyMatch(f ->
                                    f.getName().toLowerCase().startsWith("invoice") &&
                                    f.getName().toLowerCase().endsWith(".txt") &&
                                    f.lastModified() >= sinceMillis
                            );
                    if (found) return true;
                } catch (Exception ignored) {}
            }
            Thread.sleep(1000);
            waited++;
        }
        return false;
    }
}

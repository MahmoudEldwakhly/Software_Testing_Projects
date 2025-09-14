package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartFromRecommendedItemsTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
        cartPage  = new CartPage(framework);
    }

    @Test
    public void testAddToCartFromRecommendedItems() {
        // Navigate to home page
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Scroll to Recommended section and verify it
        homePage.scrollToRecommended();
        Assert.assertTrue(homePage.isRecommendedVisible(), "'RECOMMENDED ITEMS' not visible");

        // Add first recommended item to cart
        homePage.addFirstRecommendedToCart();

        // Open cart from the add-to-cart modal
        homePage.clickViewCartFromModal();

        // Verify product is displayed in cart (quantity cell/button should exist)
        String qty = cartPage.getFirstProductQuantity();
        Assert.assertTrue(qty != null && !qty.trim().isEmpty(), "Product not found in cart");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}

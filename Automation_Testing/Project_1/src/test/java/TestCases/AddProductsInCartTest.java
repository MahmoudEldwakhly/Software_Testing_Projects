package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.ProductsPage;
import Main.Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductsInCartTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
        productsPage = new ProductsPage(framework);
        cartPage = new CartPage(framework);
    }

    @Test
    public void testAddProductsInCart() {
        // Navigate to home page
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // Click Products button
        homePage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page not visible");
        Assert.assertTrue(productsPage.isProductsListVisible(), "Products list is not visible");

        // Add first product and continue shopping
        productsPage.addFirstProductToCart();
        productsPage.clickContinueShopping();

        // Add second product and go to cart
        productsPage.addSecondProductToCart();
        productsPage.clickViewCart();

        // Verify both products are in cart
        Assert.assertTrue(cartPage.areTwoProductsInCart(), "Two products not found in cart");

        // Verify prices, quantity, and total price exist
        Assert.assertTrue(cartPage.areDetailsPresentForBoth(), "Product details missing in cart");

        // Verify total = price * quantity for each line
        Assert.assertTrue(cartPage.lineTotalsAreCorrect(), "Line totals do not match price * quantity");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }

}

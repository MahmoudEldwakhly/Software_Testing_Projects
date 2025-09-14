package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.ProductsPage;
import Main.Pages.ProductDetailPage;
import Main.Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyProductQuantityInCartTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
        productsPage = new ProductsPage(framework);
        productDetailPage = new ProductDetailPage(framework);
        cartPage = new CartPage(framework);
    }

    @Test
    public void testVerifyProductQuantityInCart() {
        // Navigate to home page
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Go to Products and open first product detail
        homePage.clickProducts();
        productsPage.clickFirstProductView();

        // Verify product detail page
        Assert.assertTrue(productDetailPage.isProductDetailVisible(), "Product detail page not visible");

        // Set quantity to 4
        productDetailPage.setQuantity("4");

        // Add to cart
        productDetailPage.clickAddToCart();

        // View cart
        productDetailPage.clickViewCart();

        // Verify cart shows quantity = 4
        String qty = cartPage.getFirstProductQuantity();
        Assert.assertEquals(qty, "4", "Cart quantity is not 4 as expected");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}

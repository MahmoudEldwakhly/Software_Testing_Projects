package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProductsFromCartTest {
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
    public void testRemoveProductFromCart() {
        // Open site and verify home
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Add a product to cart
        homePage.clickProducts();
        productsPage.clickFirstProductView();
        Assert.assertTrue(productDetailPage.isProductDetailVisible(), "Product detail page not visible");
        productDetailPage.clickAddToCart();

        // Open Cart from the modal
        productDetailPage.clickViewCart();

        // Verify cart shows the product
        String qtyBefore = cartPage.getFirstProductQuantity();
        Assert.assertTrue(qtyBefore != null && !qtyBefore.isEmpty(), "Cart does not show a product before deletion");

        // Remove the product
        cartPage.clickDeleteFirstProduct();

        // Verify the product is removed (cart empty message appears)
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty after removing the product");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }

}

package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ViewBrandProductsTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
        productsPage = new ProductsPage(framework);
    }

    @Test
    public void testViewAndSwitchBrands() {
        // Open home page
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Go to Products
        homePage.clickProducts();

        // Verify Brands sidebar is visible
        Assert.assertTrue(productsPage.isBrandsSidebarVisible(), "Brands sidebar not visible");

        // Click first brand and verify brand page and products
        String firstBrand = "Polo";
        productsPage.clickBrand(firstBrand);
        Assert.assertTrue(
                productsPage.isOnCategoryPageWithHeader("BRAND - " + firstBrand.toUpperCase() + " PRODUCTS")
                || productsPage.isOnBrandPageFor(firstBrand),
                "Not on the expected brand page: " + firstBrand);
        Assert.assertTrue(productsPage.areBrandProductsVisible(), "Brand products not visible for " + firstBrand);

        // Click another brand and verify brand page and products
        String secondBrand = "Madame";
        productsPage.clickBrand(secondBrand);
        Assert.assertTrue(
                productsPage.isOnCategoryPageWithHeader("BRAND - " + secondBrand.toUpperCase() + " PRODUCTS")
                || productsPage.isOnBrandPageFor(secondBrand),
                "Not on the expected brand page: " + secondBrand);
        Assert.assertTrue(productsPage.areBrandProductsVisible(), "Brand products not visible for " + secondBrand);
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}

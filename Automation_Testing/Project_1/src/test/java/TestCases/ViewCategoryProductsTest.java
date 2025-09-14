package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ViewCategoryProductsTest {
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
    public void testViewCategoryProducts() {
        // Open site and verify home
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Go to Products page
        homePage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "All Products page not visible");

        // Verify categories sidebar is visible
        Assert.assertTrue(productsPage.isCategoriesSidebarVisible(), "Categories sidebar not visible");

        // Expand Women and click sub-category Tops
        productsPage.expandWomenCategory();
        productsPage.clickWomenSubcategory("Tops");
        Assert.assertTrue(
                productsPage.isOnCategoryPageWithHeader("WOMEN - TOPS PRODUCTS"),
                "Expected header 'WOMEN - TOPS PRODUCTS' not visible"
        );

        // Expand Men and click sub-category Tshirts
        productsPage.expandMenCategory();
        productsPage.clickMenSubcategory("Tshirts");
        Assert.assertTrue(
                productsPage.isOnCategoryPageWithHeader("MEN - TSHIRTS PRODUCTS"),
                "Expected header for MEN - TSHIRTS PRODUCTS not visible"
        );
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }

}

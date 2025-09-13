package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest {
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
    public void testSearchProduct() {
        // 1. Navigate to url
        homePage.navigateToHomePage("http://automationexercise.com");

        // 2. Verify home page
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // 3. Click Products
        homePage.clickProducts();

        // 4. Verify ALL PRODUCTS page
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page not visible");

        // 5. Search for product
        productsPage.searchProduct("Tshirt");

        // 6. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(productsPage.isSearchedProductsHeaderVisible(), "'SEARCHED PRODUCTS' header not visible");

        // 7. Verify searched products are displayed
        Assert.assertTrue(productsPage.areSearchedProductsVisible(), "Searched products not visible");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}

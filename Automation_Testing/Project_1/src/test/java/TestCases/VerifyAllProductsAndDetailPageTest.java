package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyAllProductsAndDetailPageTest {
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
    public void testVerifyAllProductsAndDetailPage() {
        // 1. Navigate to url
        homePage.navigateToHomePage("http://automationexercise.com");

        // 2. Verify home page
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // 3. Click Products
        homePage.clickProducts();

        // 4. Verify ALL PRODUCTS page
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page not visible");

        // 5. Verify products list
        Assert.assertTrue(productsPage.isProductsListVisible(), "Products list is not visible");

        // 6. Click 'View Product' of first product
        productsPage.clickFirstProductView();

        // 7. Verify product detail page
        Assert.assertTrue(productsPage.isProductDetailVisible(), "Product detail page not visible");

        // 8. Verify all details (name, category, price, availability, condition, brand)
        Assert.assertTrue(productsPage.areAllDetailsVisible(), "Not all product details are visible");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }
}

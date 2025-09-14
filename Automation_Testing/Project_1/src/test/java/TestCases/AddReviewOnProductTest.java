package testCases;

import Frameworks.SeleniumFrameWork;
import Main.Pages.HomePage;
import Main.Pages.ProductsPage;
import Main.Pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddReviewOnProductTest {
    private SeleniumFrameWork framework;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;

    @BeforeMethod
    public void setUp() {
        framework = new SeleniumFrameWork();
        framework.initializeBrowser();
        framework.implicitWait(15);

        homePage = new HomePage(framework);
        productsPage = new ProductsPage(framework);
        productDetailPage = new ProductDetailPage(framework);
    }

    @Test
    public void testAddReviewOnProduct() {
        // Open site and verify home
        homePage.navigateToHomePage("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        // Go to Products and verify ALL PRODUCTS
        homePage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "ALL PRODUCTS page not visible");

        // Open the first product detail
        productsPage.clickFirstProductView();
        Assert.assertTrue(productDetailPage.isProductDetailVisible(), "Product detail page not visible");

        // Ensure the review form is accessible
        productDetailPage.openReviewsTabIfPresent();
        Assert.assertTrue(productDetailPage.isWriteYourReviewVisible(), "'Write Your Review' not visible");

        // Fill review and submit
        String uniqEmail = "reviewer+" + System.currentTimeMillis() + "@example.com";
        productDetailPage.submitReview("Review Tester", uniqEmail, "This is an automated review. Looks good.");

        // Verify success
        Assert.assertTrue(productDetailPage.isReviewSuccessVisible(), "Success message not visible");
    }

    @AfterMethod
    public void tearDown() {
        framework.closeBrowser();
    }

}

package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class ProductsPage {
    private SeleniumFrameWork framework;

    // Locators
    private By productsHeader = By.xpath("//h2[contains(text(),'All Products')]");
    private By productsList = By.cssSelector(".features_items");
    private By firstProductView = By.cssSelector("a[href*='/product_details/1']");

    // Search locators
    private By searchInput = By.cssSelector("input#search_product");
    private By searchButton = By.cssSelector("button#submit_search");
    private By searchedProductsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By searchedProducts = By.cssSelector(".features_items .product-image-wrapper");

    // Add to Cart locators
    private By firstProductAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    private By secondProductAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[3]");
    private By continueShoppingButton = By.cssSelector(".btn.btn-success.close-modal.btn-block");
    private By viewCartButton = By.cssSelector("a[href='/view_cart']");

    // Product detail page locators
    private By productDetail = By.cssSelector(".product-information");
    private By productName = By.cssSelector(".product-information h2");
    private By productCategory = By.xpath("//p[contains(text(),'Category')]");
    private By productPrice = By.cssSelector(".product-information span span");
    private By productAvailability = By.xpath("//b[contains(text(),'Availability')]");
    private By productCondition = By.xpath("//b[contains(text(),'Condition')]");
    private By productBrand = By.xpath("//b[contains(text(),'Brand')]");

    // Category sidebar locators (added)
    private By leftSidebarContainer = By.cssSelector(".left-sidebar .panel-group");
    private By womenToggle = By.cssSelector("a[href='#Women']");
    private By menToggle = By.cssSelector("a[href='#Men']");
    private By categoryHeader = By.cssSelector(".features_items h2.title.text-center");

    public ProductsPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    // Verify ALL PRODUCTS page is visible
    public boolean isAllProductsPageVisible() {
        try {
            framework.explicitWait(productsHeader, 10);
            String text = framework.getText(productsHeader);
            return text.contains("ALL PRODUCTS");
        } catch (Exception e) {
            return false;
        }
    }

    // Verify product list is visible
    public boolean isProductsListVisible() {
        try {
            framework.explicitWait(productsList, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Click on first product's "View Product"
    public void clickFirstProductView() {
        try {
            framework.explicitWait(firstProductView, 10);
            framework.clickWithJS(firstProductView);
        } catch (Exception e) {
            System.out.println("Failed to click first product view: " + e.getMessage());
            throw e;
        }
    }

    // Search for a product
    public void searchProduct(String productName) {
        framework.explicitWait(searchInput, 10);
        framework.sendKeys(searchInput, productName);
        framework.click(searchButton);
    }

    // Verify "SEARCHED PRODUCTS" header
    public boolean isSearchedProductsHeaderVisible() {
        try {
            framework.explicitWait(searchedProductsHeader, 10);
            String text = framework.getText(searchedProductsHeader);
            return text.contains("SEARCHED PRODUCTS");
        } catch (Exception e) {
            return false;
        }
    }

    // Verify searched products are visible (no direct driver usage)
    public boolean areSearchedProductsVisible() {
        try {
            framework.explicitWait(searchedProducts, 10);
            String text = framework.getText(searchedProducts);
            return text != null && !text.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    // Add first product to cart
    public void addFirstProductToCart() {
        framework.explicitWait(firstProductAddToCart, 10);
        framework.clickWithJS(firstProductAddToCart);
    }

    // Add second product to cart
    public void addSecondProductToCart() {
        framework.explicitWait(secondProductAddToCart, 10);
        framework.clickWithJS(secondProductAddToCart);
    }

    // Click "Continue Shopping"
    public void clickContinueShopping() {
        framework.explicitWait(continueShoppingButton, 10);
        framework.click(continueShoppingButton);
    }

    // Click "View Cart"
    public void clickViewCart() {
        framework.explicitWait(viewCartButton, 10);
        framework.click(viewCartButton);
    }

    // Verify product detail page is visible
    public boolean isProductDetailVisible() {
        try {
            framework.explicitWait(productDetail, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Verify all product details are visible
    public boolean areAllDetailsVisible() {
        try {
            framework.explicitWait(productName, 10);
            framework.explicitWait(productCategory, 10);
            framework.explicitWait(productPrice, 10);
            framework.explicitWait(productAvailability, 10);
            framework.explicitWait(productCondition, 10);
            framework.explicitWait(productBrand, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Sidebar visibility check (added)
    public boolean isCategoriesSidebarVisible() {
        try {
            framework.explicitWait(leftSidebarContainer, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Expand Women category (added)
    public void expandWomenCategory() {
        framework.scrollToElement(womenToggle);
        framework.explicitWait(womenToggle, 10);
        try {
            framework.click(womenToggle);
        } catch (Exception e) {
            framework.clickWithJS(womenToggle);
        }
    }

    // Click a subcategory under Women (added)
    public void clickWomenSubcategory(String subcategoryText) {
        By sub = By.xpath("//div[@id='Women']//a[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'"
                + subcategoryText.toUpperCase() + "')]");
        framework.explicitWait(sub, 10);
        try {
            framework.click(sub);
        } catch (Exception e) {
            framework.clickWithJS(sub);
        }
    }

    // Expand Men category (added)
    public void expandMenCategory() {
        framework.scrollToElement(menToggle);
        framework.explicitWait(menToggle, 10);
        try {
            framework.click(menToggle);
        } catch (Exception e) {
            framework.clickWithJS(menToggle);
        }
    }

    // Click a subcategory under Men (added)
    public void clickMenSubcategory(String subcategoryText) {
        By sub = By.xpath("//div[@id='Men']//a[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'"
                + subcategoryText.toUpperCase() + "')]");
        framework.explicitWait(sub, 10);
        try {
            framework.click(sub);
        } catch (Exception e) {
            framework.clickWithJS(sub);
        }
    }

    // Verify category header text like "WOMEN - TOPS PRODUCTS" (added)
    public String getCategoryHeaderUpper() {
        framework.explicitWait(categoryHeader, 10);
        String txt = framework.getText(categoryHeader);
        return txt == null ? "" : txt.trim().toUpperCase();
    }

    public boolean isOnCategoryPageWithHeader(String expectedUpper) {
        return getCategoryHeaderUpper().contains(expectedUpper.toUpperCase());
    }
}

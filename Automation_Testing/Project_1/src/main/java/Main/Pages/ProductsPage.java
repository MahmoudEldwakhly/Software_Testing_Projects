package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class ProductsPage {
    private SeleniumFrameWork framework;

    // ===== Existing locators you already had =====
    private By productsHeader = By.xpath("//h2[contains(text(),'All Products')]");
    private By productsList = By.cssSelector(".features_items");
    private By firstProductView = By.cssSelector("a[href*='/product_details/1']");

    // Search
    private By searchInput = By.cssSelector("input#search_product");
    private By searchButton = By.cssSelector("button#submit_search");
    private By searchedProductsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By searchedProducts = By.cssSelector(".features_items .product-image-wrapper");

    // Add to Cart (generic)
    private By firstProductAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    private By secondProductAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[3]");
    private By continueShoppingButton = By.cssSelector(".btn.btn-success.close-modal.btn-block");
    private By viewCartButton = By.cssSelector("a[href='/view_cart']");

    // Product detail page bits
    private By productDetail = By.cssSelector(".product-information");
    private By productName = By.cssSelector(".product-information h2");
    private By productCategory = By.xpath("//p[contains(text(),'Category')]");
    private By productPrice = By.cssSelector(".product-information span span");
    private By productAvailability = By.xpath("//b[contains(text(),'Availability')]");
    private By productCondition = By.xpath("//b[contains(text(),'Condition')]");
    private By productBrand = By.xpath("//b[contains(text(),'Brand')]");

    // Category sidebar (TC18)
    private By leftSidebarContainer = By.cssSelector(".left-sidebar .panel-group");
    private By womenToggle = By.cssSelector("a[href='#Women']");
    private By menToggle = By.cssSelector("a[href='#Men']");
    private By categoryHeader = By.cssSelector(".features_items h2.title.text-center");

    // Brands sidebar (TC19)
    private By brandsBox = By.cssSelector(".brands_products");
    private By brandsTitle = By.xpath("//div[@class='brands_products']//h2");

    public ProductsPage(SeleniumFrameWork framework) { this.framework = framework; }

    // ===== Existing public APIs you already used =====
    public boolean isAllProductsPageVisible() {
        try {
            framework.explicitWait(productsHeader, 10);
            String text = framework.getText(productsHeader);
            return text != null && text.contains("ALL PRODUCTS");
        } catch (Exception e) { return false; }
    }

    public boolean isProductsListVisible() {
        try { framework.explicitWait(productsList, 10); return true; }
        catch (Exception e) { return false; }
    }

    public void clickFirstProductView() {
        framework.explicitWait(firstProductView, 10);
        framework.clickWithJS(firstProductView);
    }

    public void searchProduct(String productName) {
        framework.explicitWait(searchInput, 10);
        framework.clearAndSendKeys(searchInput, productName);
        framework.click(searchButton);
    }

    public boolean isSearchedProductsHeaderVisible() {
        try {
            framework.explicitWait(searchedProductsHeader, 10);
            String text = framework.getText(searchedProductsHeader);
            return text != null && text.contains("SEARCHED PRODUCTS");
        } catch (Exception e) { return false; }
    }

    public boolean areSearchedProductsVisible() {
        try {
            framework.explicitWait(searchedProducts, 10);
            String text = framework.getText(searchedProducts);
            return text != null && !text.isEmpty();
        } catch (Exception e) { return false; }
    }

    public void addFirstProductToCart() {
        framework.explicitWait(firstProductAddToCart, 10);
        framework.clickWithJS(firstProductAddToCart);
    }

    public void addSecondProductToCart() {
        framework.explicitWait(secondProductAddToCart, 10);
        framework.clickWithJS(secondProductAddToCart);
    }

    public void clickContinueShopping() {
        framework.explicitWait(continueShoppingButton, 10);
        framework.click(continueShoppingButton);
    }

    public void clickViewCart() {
        framework.explicitWait(viewCartButton, 10);
        framework.click(viewCartButton);
    }

    public boolean isProductDetailVisible() {
        try { framework.explicitWait(productDetail, 10); return true; }
        catch (Exception e) { return false; }
    }

    public boolean areAllDetailsVisible() {
        try {
            framework.explicitWait(productName, 10);
            framework.explicitWait(productCategory, 10);
            framework.explicitWait(productPrice, 10);
            framework.explicitWait(productAvailability, 10);
            framework.explicitWait(productCondition, 10);
            framework.explicitWait(productBrand, 10);
            return true;
        } catch (Exception e) { return false; }
    }

    // ===== Categories (TC18) =====
    public boolean isCategoriesSidebarVisible() {
        try { framework.explicitWait(leftSidebarContainer, 10); return true; }
        catch (Exception e) { return false; }
    }

    public void expandWomenCategory() {
        framework.scrollToElement(womenToggle);
        framework.explicitWait(womenToggle, 10);
        try { framework.click(womenToggle); } catch (Exception e) { framework.clickWithJS(womenToggle); }
    }

    public void clickWomenSubcategory(String subcategoryText) {
        By sub = By.xpath("//div[@id='Women']//a[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'"
                + subcategoryText.toUpperCase() + "')]");
        framework.explicitWait(sub, 10);
        try { framework.click(sub); } catch (Exception e) { framework.clickWithJS(sub); }
    }

    public void expandMenCategory() {
        framework.scrollToElement(menToggle);
        framework.explicitWait(menToggle, 10);
        try { framework.click(menToggle); } catch (Exception e) { framework.clickWithJS(menToggle); }
    }

    public void clickMenSubcategory(String subcategoryText) {
        By sub = By.xpath("//div[@id='Men']//a[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'"
                + subcategoryText.toUpperCase() + "')]");
        framework.explicitWait(sub, 10);
        try { framework.click(sub); } catch (Exception e) { framework.clickWithJS(sub); }
    }

    public String getCategoryHeaderUpper() {
        framework.explicitWait(categoryHeader, 10);
        String txt = framework.getText(categoryHeader);
        return txt == null ? "" : txt.trim().toUpperCase();
    }

    public boolean isOnCategoryPageWithHeader(String expectedUpper) {
        return getCategoryHeaderUpper().contains(expectedUpper.toUpperCase());
    }

    // ===== Brands (TC19) =====
    public boolean isBrandsSidebarVisible() {
        try {
            framework.explicitWait(brandsBox, 10);
            framework.explicitWait(brandsTitle, 10);
            String t = framework.getText(brandsTitle);
            return t != null && t.trim().toUpperCase().contains("BRANDS");
        } catch (Exception e) { return false; }
    }

    public void clickBrand(String brandName) {
        By brandLink = By.xpath("//div[@class='brands_products']//a[contains(translate(.,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'"
                + brandName.toUpperCase() + "')]");
        framework.scrollToElement(brandLink);
        framework.explicitWait(brandLink, 10);
        try { framework.click(brandLink); } catch (Exception e) { framework.clickWithJS(brandLink); }
    }

    public boolean isOnBrandPageFor(String brandName) {
        String hdr = getCategoryHeaderUpper();
        return hdr.contains("BRAND -") && hdr.contains(brandName.toUpperCase()) && hdr.contains("PRODUCTS");
    }

    public boolean areBrandProductsVisible() {
        try {
            framework.explicitWait(searchedProducts, 10);
            String text = framework.getText(searchedProducts);
            return text != null && !text.isEmpty();
        } catch (Exception e) { return false; }
    }

    // ======== NEW: helpers that add ONLY items from current SEARCH RESULTS grid ========

    // Nth result card inside the SEARCHED PRODUCTS grid
    private By searchCardAt(int index1) {
        return By.xpath("(//div[@class='features_items']//div[@class='product-image-wrapper'])[" + index1 + "]");
    }
    // The ALWAYS-VISIBLE add-to-cart inside the card (no overlay)
    private By addToCartVisibleInCard(int index1) {
        return By.xpath("(//div[@class='features_items']//div[@class='product-image-wrapper'])[" + index1 + "]//div[contains(@class,'productinfo')]//a[contains(text(),'Add to cart')]");
    }
    // Overlay add-to-cart in the same card (fallback)
    private By addToCartOverlayInCard(int index1) {
        return By.xpath("(//div[@class='features_items']//div[@class='product-image-wrapper'])[" + index1 + "]//div[contains(@class,'product-overlay')]//a[contains(text(),'Add to cart')]");
    }

    /** Counts how many product cards are currently rendered in the SEARCHED PRODUCTS grid. */
    public int getSearchedResultsCount() {
        int count = 0;
        for (int i = 1; i <= 30; i++) {
            try {
                framework.explicitWait(searchCardAt(i), 2);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        return count;
    }

    /**
     * Adds ALL items from the current SEARCHED PRODUCTS grid (first page only).
     * Returns how many add attempts succeeded (modal handled inside).
     * No page refreshes, no re-search; strictly within the visible grid.
     */
    public int addAllSearchedResultsToCart() {
        int total = getSearchedResultsCount();
        int added = 0;
        for (int i = 1; i <= total; i++) {
            try {
                // Scroll card into view
                framework.scrollToElement(searchCardAt(i));
                // Prefer the visible button in productinfo
                try {
                    framework.explicitWait(addToCartVisibleInCard(i), 5);
                    framework.clickWithJS(addToCartVisibleInCard(i));
                } catch (Exception notVisible) {
                    // Fallback: overlay button (if site requires hover)
                    framework.explicitWait(addToCartOverlayInCard(i), 5);
                    framework.clickWithJS(addToCartOverlayInCard(i));
                }
                // Close modal
                framework.explicitWait(continueShoppingButton, 10);
                framework.click(continueShoppingButton);
                added++;
            } catch (Exception e) {
                System.out.println("Add-to-cart failed for search card #" + i + ": " + e.getMessage());
            }
        }
        return added;
    }
}

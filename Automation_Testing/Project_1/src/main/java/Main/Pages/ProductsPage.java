package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class ProductsPage {
    private SeleniumFrameWork framework;

    // Locators
    private By allProductsHeader = By.xpath("//h2[contains(text(),'All Products')]");
    private By productsList = By.cssSelector(".features_items");
    private By firstProductViewButton = By.cssSelector("a[href*='/product_details/1']");
    
    // Product detail page locators
    private By productName = By.cssSelector(".product-information h2");
    private By productCategory = By.xpath("//p[contains(text(),'Category:')]");
    private By productPrice = By.cssSelector(".product-information span span");
    private By productAvailability = By.xpath("//b[contains(text(),'Availability:')]");
    private By productCondition = By.xpath("//b[contains(text(),'Condition:')]");
    private By productBrand = By.xpath("//b[contains(text(),'Brand:')]");

    public ProductsPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    public boolean isAllProductsPageVisible() {
        try {
            framework.explicitWait(allProductsHeader, 10);
            String text = framework.getText(allProductsHeader);
            return text.toLowerCase().contains("all products");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProductsListVisible() {
        try {
            framework.explicitWait(productsList, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickFirstProductView() {
        try {
            framework.explicitWait(firstProductViewButton, 10);
            framework.click(firstProductViewButton); // normal click
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JavaScript click due to overlay issue...");
            framework.clickWithJS(firstProductViewButton); // fallback
        }
    }

    public boolean isProductDetailVisible() {
        try {
            framework.explicitWait(productName, 10);
            return framework.getText(productName).length() > 0;
        } catch (Exception e) {
            return false;
        }
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
        } catch (Exception e) {
            return false;
        }
    }
}

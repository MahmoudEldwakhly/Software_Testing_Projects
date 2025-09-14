package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class CartPage {
    private SeleniumFrameWork framework;

    // Rows
    private By firstRow = By.cssSelector("#cart_info_table tbody tr:nth-of-type(1)");
    private By secondRow = By.cssSelector("#cart_info_table tbody tr:nth-of-type(2)");

    // First product cells
    private By firstProductPrice = By.cssSelector("#cart_info_table tbody tr:nth-of-type(1) td.cart_price");
    private By firstProductQuantityCell = By.cssSelector("#cart_info_table tbody tr:nth-of-type(1) td.cart_quantity");
    private By firstProductQuantityButton = By.cssSelector("#cart_info_table tbody tr:nth-of-type(1) td.cart_quantity button");
    private By firstProductTotal = By.cssSelector("#cart_info_table tbody tr:nth-of-type(1) td.cart_total");

    // Second product cells
    private By secondProductPrice = By.cssSelector("#cart_info_table tbody tr:nth-of-type(2) td.cart_price");
    private By secondProductQuantityCell = By.cssSelector("#cart_info_table tbody tr:nth-of-type(2) td.cart_quantity");
    private By secondProductQuantityButton = By.cssSelector("#cart_info_table tbody tr:nth-of-type(2) td.cart_quantity button");
    private By secondProductTotal = By.cssSelector("#cart_info_table tbody tr:nth-of-type(2) td.cart_total");

    // Delete (X) for first row
    private By firstRowDelete = By.cssSelector("#cart_info_table tbody tr:nth-of-type(1) a.cart_quantity_delete");

    // Cart empty message
    private By cartEmptyMessage = By.xpath("//*[contains(text(),'Cart is empty')]");

    // Generic row marker and nth-row helper (added)
    private By anyCartRowDelete = By.cssSelector("#cart_info_table tbody tr a.cart_quantity_delete");
    private By cartRowAt(int index) {
        return By.cssSelector("#cart_info_table tbody tr:nth-of-type(" + index + ")");
    }

    public CartPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    // Verify two products are present
    public boolean areTwoProductsInCart() {
        try {
            framework.explicitWait(firstRow, 10);
            framework.explicitWait(secondRow, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Verify details cells exist for both rows
    public boolean areDetailsPresentForBoth() {
        try {
            framework.explicitWait(firstProductPrice, 10);
            framework.explicitWait(firstProductQuantityCell, 10);
            framework.explicitWait(firstProductTotal, 10);
            framework.explicitWait(secondProductPrice, 10);
            framework.explicitWait(secondProductQuantityCell, 10);
            framework.explicitWait(secondProductTotal, 10);

            String p1 = framework.getText(firstProductPrice);
            String q1 = framework.getText(firstProductQuantityButton);
            String t1 = framework.getText(firstProductTotal);

            String p2 = framework.getText(secondProductPrice);
            String q2 = framework.getText(secondProductQuantityButton);
            String t2 = framework.getText(secondProductTotal);

            return !p1.isEmpty() && !q1.isEmpty() && !t1.isEmpty()
                && !p2.isEmpty() && !q2.isEmpty() && !t2.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    // Verify line totals math
    public boolean lineTotalsAreCorrect() {
        try {
            int price1 = parseMoney(framework.getText(firstProductPrice));
            int qty1   = parseIntSafe(framework.getText(firstProductQuantityButton));
            int total1 = parseMoney(framework.getText(firstProductTotal));

            int price2 = parseMoney(framework.getText(secondProductPrice));
            int qty2   = parseIntSafe(framework.getText(secondProductQuantityButton));
            int total2 = parseMoney(framework.getText(secondProductTotal));

            boolean ok1 = (price1 * qty1) == total1;
            boolean ok2 = (price2 * qty2) == total2;

            if (!ok1) {
                System.out.println("Line 1 mismatch: price=" + price1 + " qty=" + qty1 + " total=" + total1);
            }
            if (!ok2) {
                System.out.println("Line 2 mismatch: price=" + price2 + " qty=" + qty2 + " total=" + total2);
            }
            return ok1 && ok2;
        } catch (Exception e) {
            return false;
        }
    }

    // Read quantity for first product (button text)
    public String getFirstProductQuantity() {
        try {
            framework.explicitWait(firstProductQuantityButton, 10);
            return framework.getText(firstProductQuantityButton).trim();
        } catch (Exception e) {
            return "";
        }
    }

    // Click the X for the first product row
    public void clickDeleteFirstProduct() {
        framework.explicitWait(firstRowDelete, 10);
        framework.click(firstRowDelete);
    }

    // Check if the empty-cart message appears
    public boolean isCartEmpty() {
        try {
            framework.explicitWait(cartEmptyMessage, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Check if at least one cart row is present (added)
    public boolean isAnyCartRowPresent() {
        try {
            framework.explicitWait(anyCartRowDelete, 5);
            return true;
        } catch (Exception e) {
            try {
                framework.explicitWait(firstRow, 3);
                return true;
            } catch (Exception ignore) {}
            try {
                framework.explicitWait(secondRow, 3);
                return true;
            } catch (Exception ignore) {}
            return false;
        }
    }

    // Count visible cart rows by probing sequentially (added)
    public int countItemsInCart() {
        int count = 0;
        for (int i = 1; i <= 20; i++) {
            try {
                framework.explicitWait(cartRowAt(i), 2);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        return count;
    }

    private int parseMoney(String txt) {
        String digits = txt.replaceAll("[^0-9]", "");
        return digits.isEmpty() ? 0 : Integer.parseInt(digits);
    }

    private int parseIntSafe(String txtCell) {
        String digits = txtCell.replaceAll("[^0-9]", "");
        return digits.isEmpty() ? 0 : Integer.parseInt(digits);
    }
}

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

    public CartPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    public boolean areTwoProductsInCart() {
        try {
            framework.explicitWait(firstRow, 10);
            framework.explicitWait(secondRow, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areDetailsPresentForBoth() {
        try {
            framework.explicitWait(firstProductPrice, 10);
            framework.explicitWait(firstProductQuantityCell, 10);
            framework.explicitWait(firstProductTotal, 10);
            framework.explicitWait(secondProductPrice, 10);
            framework.explicitWait(secondProductQuantityCell, 10);
            framework.explicitWait(secondProductTotal, 10);

            String p1 = framework.getText(firstProductPrice);
            String q1 = framework.getText(firstProductQuantityButton); // button text
            String t1 = framework.getText(firstProductTotal);

            String p2 = framework.getText(secondProductPrice);
            String q2 = framework.getText(secondProductQuantityButton); // button text
            String t2 = framework.getText(secondProductTotal);

            return !p1.isEmpty() && !q1.isEmpty() && !t1.isEmpty()
                && !p2.isEmpty() && !q2.isEmpty() && !t2.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

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

    public String getFirstProductQuantity() {
        try {
            framework.explicitWait(firstProductQuantityButton, 10);
            return framework.getText(firstProductQuantityButton).trim();
        } catch (Exception e) {
            return "";
        }
    }

    private int parseMoney(String txt) {
        // Example: "Rs. 500" -> 500
        String digits = txt.replaceAll("[^0-9]", "");
        return digits.isEmpty() ? 0 : Integer.parseInt(digits);
    }

    private int parseIntSafe(String txtCell) {
        // Extract digits from any cell/button text
        String digits = txtCell.replaceAll("[^0-9]", "");
        return digits.isEmpty() ? 0 : Integer.parseInt(digits);
    }
}

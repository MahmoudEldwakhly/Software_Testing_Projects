package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class SignupPage {
    private SeleniumFrameWork framework;
    
    // Updated locators
    private By accountInfoText = By.cssSelector("h2.title:nth-child(1)");
    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By offersCheckbox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");
    
    public SignupPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }
    
    public boolean isAccountInfoVisible() {
        try {
            // Add explicit wait
            framework.explicitWait(accountInfoText, 10);
            String text = framework.getText(accountInfoText);
            return text.contains("ENTER ACCOUNT INFORMATION") || text.contains("Account Information");
        } catch (Exception e) {
            System.out.println("Account Info text not found: " + e.getMessage());
            return false;
        }
    }
    
 public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            framework.click(titleMr);
        } else {
            framework.click(titleMrs);
        }
    }
    
    public void enterPassword(String pwd) {
        framework.sendKeys(passwordField, pwd);
    }
    
    public void selectDateOfBirth(String day, String month, String year) {
        // Convert month name to numeric value if needed
        String monthValue = convertMonthToValue(month);
        
        framework.selectDropdownByValue(daysDropdown, day);
        framework.selectDropdownByValue(monthsDropdown, monthValue);
        framework.selectDropdownByValue(yearsDropdown, year);
    }
    
    private String convertMonthToValue(String month) {
        switch (month.toLowerCase()) {
            case "january": return "1";
            case "february": return "2";
            case "march": return "3";
            case "april": return "4";
            case "may": return "5";
            case "june": return "6";
            case "july": return "7";
            case "august": return "8";
            case "september": return "9";
            case "october": return "10";
            case "november": return "11";
            case "deccember": return "12";
            default: return month;
        }
    }
    
  public void checkNewsletter() {
    try {
        // First try normal click
        framework.checkCheckbox(newsletterCheckbox);
    } catch (Exception e) {
        System.out.println("Normal click failed, trying JavaScript click...");
        // If normal click fails, use JavaScript click
        framework.clickWithJS(newsletterCheckbox);
    }
}

public void checkOffers() {
    try {
        // First try normal click
        framework.checkCheckbox(offersCheckbox);
    } catch (Exception e) {
        System.out.println("Normal click failed, trying JavaScript click...");
        // If normal click fails, use JavaScript click
        framework.clickWithJS(offersCheckbox);
    }
}
    
    public void enterAddressInfo(String fName, String lName, String comp, 
                               String addr1, String addr2, String countryVal,
                               String stateVal, String cityVal, String zipcodeVal, String mobile) {
        framework.sendKeys(firstNameField, fName);
        framework.sendKeys(lastNameField, lName);
        framework.sendKeys(companyField, comp);
        framework.sendKeys(address1Field, addr1);
        framework.sendKeys(address2Field, addr2);
        framework.selectDropdownByVisibleText(countryDropdown, countryVal);
        framework.sendKeys(stateField, stateVal);
        framework.sendKeys(cityField, cityVal);
        framework.sendKeys(zipcodeField, zipcodeVal);
        framework.sendKeys(mobileNumberField, mobile);
    }
    
    public void clickCreateAccount() {
        framework.click(createAccountButton);
    }
}
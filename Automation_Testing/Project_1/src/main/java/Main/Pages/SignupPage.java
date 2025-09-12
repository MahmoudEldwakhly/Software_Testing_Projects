package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class SignupPage {
    private SeleniumFrameWork framework;
    
    // Locators with data-qa attributes
    private By accountInfoText = By.cssSelector("h2.title");
    private By titleMr = By.cssSelector("input#id_gender1");
    private By titleMrs = By.cssSelector("input#id_gender2");
    private By passwordField = By.cssSelector("input[data-qa='password']");
    private By daysDropdown = By.cssSelector("select#days");
    private By monthsDropdown = By.cssSelector("select#months");
    private By yearsDropdown = By.cssSelector("select#years");
    private By newsletterCheckbox = By.cssSelector("input#newsletter");
    private By offersCheckbox = By.cssSelector("input#optin");
    private By firstNameField = By.cssSelector("input[data-qa='first_name']");
    private By lastNameField = By.cssSelector("input[data-qa='last_name']");
    private By companyField = By.cssSelector("input[data-qa='company']");
    private By address1Field = By.cssSelector("input[data-qa='address']");
    private By address2Field = By.cssSelector("input[data-qa='address2']");
    private By countryDropdown = By.cssSelector("select[data-qa='country']");
    private By stateField = By.cssSelector("input[data-qa='state']");
    private By cityField = By.cssSelector("input[data-qa='city']");
    private By zipcodeField = By.cssSelector("input[data-qa='zipcode']");
    private By mobileNumberField = By.cssSelector("input[data-qa='mobile_number']");
    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");
    
    public SignupPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }
    
    public boolean isAccountInfoVisible() {
        try {
            framework.explicitWait(accountInfoText, 10);
            String text = framework.getText(accountInfoText);
            return text.contains("ENTER ACCOUNT INFORMATION") || text.contains("Account Information");
        } catch (Exception e) {
            System.out.println("Account Info text not found: " + e.getMessage());
            return false;
        }
    }
    
    public void selectTitle(String title) {
        framework.explicitWait(titleMr, 10);
        if (title.equalsIgnoreCase("Mr")) {
            framework.click(titleMr);
        } else {
            framework.click(titleMrs);
        }
    }
    
    public void enterPassword(String pwd) {
        framework.explicitWait(passwordField, 10);
        framework.sendKeys(passwordField, pwd);
    }
    
    public void selectDateOfBirth(String day, String month, String year) {
        String monthValue = convertMonthToValue(month);
        
        framework.explicitWait(daysDropdown, 10);
        framework.selectDropdownByValue(daysDropdown, day);
        
        framework.explicitWait(monthsDropdown, 10);
        framework.selectDropdownByValue(monthsDropdown, monthValue);
        
        framework.explicitWait(yearsDropdown, 10);
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
            case "december": return "12";
            default: return month;
        }
    }
    
    public void checkNewsletter() {
        try {
            framework.explicitWait(newsletterCheckbox, 10);
            framework.checkCheckbox(newsletterCheckbox);
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JavaScript click...");
            framework.clickWithJS(newsletterCheckbox);
        }
    }
    
    public void checkOffers() {
        try {
            framework.explicitWait(offersCheckbox, 10);
            framework.checkCheckbox(offersCheckbox);
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JavaScript click...");
            framework.clickWithJS(offersCheckbox);
        }
    }
    
    public void enterAddressInfo(String fName, String lName, String comp, 
                               String addr1, String addr2, String countryVal,
                               String stateVal, String cityVal, String zipcodeVal, String mobile) {
        framework.explicitWait(firstNameField, 10);
        framework.sendKeys(firstNameField, fName);
        
        framework.explicitWait(lastNameField, 10);
        framework.sendKeys(lastNameField, lName);
        
        framework.explicitWait(companyField, 10);
        framework.sendKeys(companyField, comp);
        
        framework.explicitWait(address1Field, 10);
        framework.sendKeys(address1Field, addr1);
        
        framework.explicitWait(address2Field, 10);
        framework.sendKeys(address2Field, addr2);
        
        framework.explicitWait(countryDropdown, 10);
        framework.selectDropdownByVisibleText(countryDropdown, countryVal);
        
        framework.explicitWait(stateField, 10);
        framework.sendKeys(stateField, stateVal);
        
        framework.explicitWait(cityField, 10);
        framework.sendKeys(cityField, cityVal);
        
        framework.explicitWait(zipcodeField, 10);
        framework.sendKeys(zipcodeField, zipcodeVal);
        
        framework.explicitWait(mobileNumberField, 10);
        framework.sendKeys(mobileNumberField, mobile);
    }
    
    public void clickCreateAccount() {
        framework.explicitWait(createAccountButton, 10);
        framework.click(createAccountButton);
    }
}
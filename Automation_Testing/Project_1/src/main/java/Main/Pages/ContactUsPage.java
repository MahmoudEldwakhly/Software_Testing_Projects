package Main.Pages;

import Frameworks.SeleniumFrameWork;
import org.openqa.selenium.By;

public class ContactUsPage {
    private SeleniumFrameWork framework;

    // Locators
    private By getInTouchText = By.xpath("//h2[contains(text(),'Get In Touch')]");
    private By nameField = By.cssSelector("input[data-qa='name']");
    private By emailField = By.cssSelector("input[data-qa='email']");
    private By subjectField = By.cssSelector("input[data-qa='subject']");
    private By messageField = By.cssSelector("textarea[data-qa='message']");
    private By uploadFileField = By.cssSelector("input[name='upload_file']");
    private By submitButton = By.cssSelector("input[data-qa='submit-button']");
    private By successMessage = By.xpath("//div[contains(@class,'status') and contains(text(),'Success!')]");
    private By homeButton = By.cssSelector("a.btn-success");

    public ContactUsPage(SeleniumFrameWork framework) {
        this.framework = framework;
    }

    public boolean isGetInTouchVisible() {
        try {
            framework.explicitWait(getInTouchText, 10);
            String text = framework.getText(getInTouchText);
            return text.toLowerCase().contains("get in touch");
        } catch (Exception e) {
            return false;
        }
    }

    public void enterName(String name) {
        framework.sendKeys(nameField, name);
    }

    public void enterEmail(String email) {
        framework.sendKeys(emailField, email);
    }

    public void enterSubject(String subject) {
        framework.sendKeys(subjectField, subject);
    }

    public void enterMessage(String message) {
        framework.sendKeys(messageField, message);
    }

    public void uploadFile(String filePath) {
        framework.sendKeys(uploadFileField, filePath);
    }

    public void clickSubmit() {
        framework.click(submitButton);
    }

    public void acceptAlert() {
        framework.acceptAlert();
    }

    public boolean isSuccessMessageVisible() {
        try {
            framework.explicitWait(successMessage, 10);
            String text = framework.getText(successMessage);
            return text.contains("Success! Your details have been submitted successfully.");
        } catch (Exception e) {
            return false;
        }
    }

    public void clickHome() {
        framework.click(homeButton);
    }
}

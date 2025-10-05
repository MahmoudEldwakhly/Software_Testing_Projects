/*
 ============================================================================
 Name        : Login_Tests.java
 Copyright   : Edges For Training
 Description : TestNG login tests using Selenium WebDriver and Page Object Model (POM)
 ============================================================================
 */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Pages.Login_Page;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Tests {
    
    // Page object representing the login page, instantiated before each test
    Login_Page PageUnderTest;

    /**
     * Setup method runs before each test.
     * It creates a new ChromeDriver instance, assigns it to the page object,
     * and opens the login page URL.
     */
    @BeforeMethod
    public void setUpMethod(){
        PageUnderTest = new Login_Page(new ChromeDriver());
        PageUnderTest.Browser.get("https://the-internet.herokuapp.com/login");
    }

    /**
     * Tear down method runs after each test.
     * It quits the browser to clean up resources.
     */
    @AfterMethod
    public void tearDownMethod(){
        PageUnderTest.Browser.quit();
    }

    /**
     * Positive test case: valid username and password.
     * Asserts that the successful login message is displayed.
     */
    @Test
    public void Valid_TC()
    {
        PageUnderTest.enter_user_name("tomsmith");
        PageUnderTest.enter_password("SuperSecretPassword!");
        PageUnderTest.click_login();

        String Expected_Result = "You logged into a secure area!";
        String Actual_Result = PageUnderTest.read_valid_div();

        boolean successCondition = Actual_Result.contains(Expected_Result);
        Assert.assertTrue(successCondition, Actual_Result + " Should Have Contained " + Expected_Result);
    }

    /**
     * Negative test case: invalid username.
     * Asserts that the invalid username error message is displayed.
     */
    @Test
    public void invalidUserName_TC1()
    {
        PageUnderTest.enter_user_name("admin");
        PageUnderTest.enter_password("SuperSecretPassword!");
        PageUnderTest.click_login();

        String Expected_Result = "Your username is invalid!";
        String Actual_Result = PageUnderTest.read_invalid_div();

        boolean successCondition = Actual_Result.contains(Expected_Result);
        Assert.assertTrue(successCondition, Actual_Result + " Should Have Contained " + Expected_Result);
    }

    /**
     * Negative test case: invalid password.
     * Asserts that the invalid password error message is displayed.
     */
    @Test
    public void invalidPassword_TC1()
    {
        PageUnderTest.enter_user_name("tomsmith");
        PageUnderTest.enter_password("WrongPassword");
        PageUnderTest.click_login();

        String Expected_Result = "Your password is invalid!";
        String Actual_Result = PageUnderTest.read_invalid_div();

        boolean successCondition = Actual_Result.contains(Expected_Result);
        Assert.assertTrue(successCondition, Actual_Result + " Should Have Contained " + Expected_Result);
    }
}

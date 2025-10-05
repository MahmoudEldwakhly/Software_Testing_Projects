/*
 ============================================================================
 Name        : ReadingDataFromJSON.java
 Copyright   : Edges For Training
 Description : TestNG login tests using Selenium WebDriver and Page Object Model (POM).
               This class performs invalid username login tests using data-driven
               approach reading user credentials from JSON.
 ============================================================================
 */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Pages.Login_Page;
import java.io.FileNotFoundException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_Tests {

    // Page object representing the login page, instantiated before each test
    Login_Page PageUnderTest;
    
    // Array holding user credentials loaded from JSON file
    static User[] ListOfUsers;

    /**
     * Runs once before all tests.
     * Reads list of users from JSON file into static array.
     * @throws FileNotFoundException if JSON file does not exist.
     */
    @BeforeClass
    public void setUpClass() throws FileNotFoundException {
        ListOfUsers = HelperClass.ReadUsers("LoginCredentials.json");
        System.out.println("Number of users loaded: " + ListOfUsers.length);
    }

    /**
     * Setup method runs before each test.
     * Creates a new ChromeDriver instance and navigates to the login page.
     */
    @BeforeMethod
    public void setUpMethod() {
        PageUnderTest = new Login_Page(new ChromeDriver());
        PageUnderTest.Browser.get("https://the-internet.herokuapp.com/login");
    }

    /**
     * Tear down method runs after each test.
     * Quits the browser to clean up resources.
     */
    @AfterMethod
    public void tearDownMethod() {
        PageUnderTest.Browser.quit();
    }

    /**
     * Data Provider returns array of User objects for all test users.
     * @return User[] of user credentials
     */
    @DataProvider(name = "usersData")
    public User[] userDataProvider() {
        return ListOfUsers;
    }

    /**
     * Test runs for each username/password from DataProvider.
     * Attempts to login with invalid username credentials.
     * Validates error message for invalid username is displayed.
     *
     * @param TestUser User object containing credentials for test
     */
    @Test(dataProvider = "usersData")
    public void invalidUserName_TC(User TestUser) {
        PageUnderTest.enter_user_name(TestUser.username);
        PageUnderTest.enter_password(TestUser.password);
        PageUnderTest.click_login();
        String Expected_Result = "Your username is invalid!";
        String Actual_Result = PageUnderTest.read_invalid_div();

        Assert.assertTrue(Actual_Result.contains(Expected_Result),
                Actual_Result + " Should Have Contained " + Expected_Result);
    }
}

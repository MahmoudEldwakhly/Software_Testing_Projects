package suite1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupB1Test {

    // Runs once before the entire suite of tests begins
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("1B Before Suite: Setup for entire test suite");
    }

    // Runs once after the entire suite of tests is finished
    @AfterSuite
    public void afterSuite() {
        System.out.println("1B After Suite: Cleanup for entire test suite");
    }

    // Runs before all tests inside the <test> tag in testng.xml
    @BeforeTest
    public void beforeTest() {
        System.out.println("1B Before Test: Setup before <test> tag tests");
    }

    // Runs after all tests inside the <test> tag in testng.xml
    @AfterTest
    public void afterTest() {
        System.out.println("1B After Test: Cleanup after <test> tag tests");
    }

    // Runs once before any test methods in this class
    @BeforeClass
    public void beforeClass() {
        System.out.println("1B Before Class: Run once before all test methods in this class");
    }

    // Runs once after all test methods in this class have run
    @AfterClass
    public void afterClass() {
        System.out.println("1B After Class: Run once after all test methods in this class");
    }

    // Runs before each test method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("1B Before Method: Run before each test method");
    }

    // Runs after each test method
    @AfterMethod
    public void afterMethod() {
        System.out.println("1B After Method: Run after each test method");
    }
    @Test(groups = {"GroupB"})
    public void testB1() {
        System.out.println("Suite1 - GroupB1Test: testB1 running");
    }
}

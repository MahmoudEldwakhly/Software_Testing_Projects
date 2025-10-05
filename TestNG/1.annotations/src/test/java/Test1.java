/*
 ============================================================================
 Name        : 1.TestNGAnotationsDemo.java
 Copyright   : Edges For Training
 Description : Simple TestNG example illustrating common TestNG annotations and execution flow
 ============================================================================
*/

import org.testng.annotations.*;

public class Test1 {

    // Runs once before the entire suite of tests begins
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Setup for entire test suite");
    }

    // Runs once after the entire suite of tests is finished
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Cleanup for entire test suite");
    }

    // Runs before all tests inside the <test> tag in testng.xml
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test: Setup before <test> tag tests");
    }

    // Runs after all tests inside the <test> tag in testng.xml
    @AfterTest
    public void afterTest() {
        System.out.println("After Test: Cleanup after <test> tag tests");
    }

    // Runs once before any test methods in this class
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: Run once before all test methods in this class");
    }

    // Runs once after all test methods in this class have run
    @AfterClass
    public void afterClass() {
        System.out.println("After Class: Run once after all test methods in this class");
    }

    // Runs before each test method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Run before each test method");
    }

    // Runs after each test method
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Run after each test method");
    }

    // First simple test method
    @Test
    public void test1() {
        System.out.println("Test 1 Executed");
    }

    // Second simple test method
    @Test
    public void test2() {
        System.out.println("Test 2 Executed");
    }
}

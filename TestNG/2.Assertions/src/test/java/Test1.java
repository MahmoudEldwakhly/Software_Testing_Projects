/*
 ============================================================================
 Name        : 2.TestNGAssertionsDemo.java
 Copyright   : Edges For Training
 Description : Demonstrates different TestNG assertions in separate test cases
 ============================================================================
*/

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test1 {

    // Tests equality of two strings
    @Test
    public void testAssertEquals() {
        String expected = "Hello";
        String actual = "Hello";
        Assert.assertEquals(actual, expected, "Strings should match");
    }

    // Ensures two integer values are not equal
    @Test
    public void testAssertNotEquals() {
        int a = 5;
        int b = 10;
        Assert.assertNotEquals(a, b, "Values should not be equal");
    }

    // Verifies a boolean condition is true
    @Test
    public void testAssertTrue() {
        boolean isActive = true;
        Assert.assertTrue(isActive, "The condition should be true");
    }

    // Verifies a boolean condition is false
    @Test
    public void testAssertFalse() {
        boolean isReady = false;
        Assert.assertFalse(isReady, "The condition should be false");
    }

    // Checks that an object is null
    @Test
    public void testAssertNull() {
        Object obj = null;
        Assert.assertNull(obj, "Object should be null");
    }

    // Checks that an object is not null
    @Test
    public void testAssertNotNull() {
        Object obj = new Object();
        Assert.assertNotNull(obj, "Object should not be null");
    }

    // Demonstrates soft assertions, allowing multiple assertions to run before failing at the end
    @Ignore
    @Test
    public void testSoftAssertExample() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("Selenium", "Selenium", "Strings must match");
        softAssert.assertTrue(false, "This is a failing assertion but test continues");
        softAssert.assertNotNull(null, "This will also fail but doesn't stop the test");

        System.out.println("All soft assertions evaluated, calling assertAll()...");
        // Collates all assertion results, failing the test if any failed
        softAssert.assertAll();
    }

    // Forces a test failure deliberately when a condition is false
    @Test
    public void testForceFail() {
        boolean condition = false;
        if (!condition) {
            Assert.fail("Condition was false - failing the test deliberately");
        }
    }
}

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HelloTestNG {
    
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    // priority = 1 → runs first among tests
    @Test(priority = 1)
    public void printMessage() {
        System.out.println("Hello TestNG");
    }

    // depends on printMessage
    @Test(priority = 2, dependsOnMethods = {"printMessage"})
    public void testSum() {
        int a = 5, b = 10;
        int result = a + b;
        System.out.println("Testing sum: " + result);
        Assert.assertEquals(result, 15, "Sum should be 15");
    }

    // depends on testSum, priority = 3
    @Test(priority = 3, dependsOnMethods = {"testSum"})
    public void testString() {
        String greeting = "Hello";
        System.out.println("Testing string: " + greeting);
        Assert.assertEquals(greeting, "Hello", "Greeting should match");
    }
}
/*
 ============================================================================
 Name        : TestManagementExample.java
 Copyright   : Edges For Training
 Description : Covers disabling/enabling tests, ignoring, dependencies,
               alwaysRun, and priorities in TestNG
 ============================================================================
*/

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Test1 {

    // Disabled: This test will not run
    @Test(enabled = false)
    public void disabledTest() {
        System.out.println("This test is disabled and will not run.");
    }

    // Enabled (default): This test will run
    @Test
    public void enabledTest() {
        System.out.println("This test is enabled and will run.");
        // Assert.assertTrue(true);
        Assert.fail();
    }

    // Ignored: This test will be skipped and reported as ignored
    @Ignore
    @Test
    public void ignoredTest() {
        System.out.println("This test is ignored and will not run.");
    }

    // Priority example: Will run before other priority=0/default tests
    @Test(priority = -1)
    public void highPriorityTest() {
        System.out.println("High priority test runs first (priority = -1).");
    }

    // Default priority (0): Will run in method order after negative priorities
    @Test
    public void defaultPriorityTest() {
        System.out.println("Default priority test runs in declaration order.");
    }

    // Lower priority value (runs after highPriorityTest but before defaultPriorityTest)
    @Test(priority = 1)
    public void lowPriorityTest() {
        System.out.println("Low priority test runs after default.");
    }

    // Dependency: This test depends on enabledTest (runs only if enabledTest passes)
    @Test(dependsOnMethods = "enabledTest")
    public void dependentTest() {
        System.out.println("dependentTest runs only after enabledTest succeeds.");
    }

    // Dependency with alwaysRun: Will run after enabledTest regardless of its result
    @Test(dependsOnMethods = "enabledTest", alwaysRun = true)
    public void alwaysRunDepTest() {
        System.out.println("alwaysRunDepTest runs even if enabledTest fails or is skipped.");
    }

}

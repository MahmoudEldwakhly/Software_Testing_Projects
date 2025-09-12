
package packageOne_testng;

/**
 *
 * @author mahmoud eldawakhly
 */
import org.testng.annotations.Test;

public class ClassOne {
    @Test
    public void method1() { System.out.println("packageOne.ClassOne - method1"); }

    @Test
    public void method2() { System.out.println("packageOne.ClassOne - method2"); }

    @Test
    public void method3() { System.out.println("packageOne.ClassOne - method3"); }
}
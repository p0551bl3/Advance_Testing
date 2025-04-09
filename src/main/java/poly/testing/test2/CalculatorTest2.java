package poly.testing.test2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest2 {
    Calculator2 calculator = new Calculator2();

    @Test
    public void testAdd() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(calculator.subtract(5, 3), 2);
    }
}

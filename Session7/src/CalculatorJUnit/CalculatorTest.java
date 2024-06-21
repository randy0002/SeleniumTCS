package CalculatorJUnit;

import org.junit.Test;

import static org.junit.Assert.fail;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        int n1 = 2;
        int n2 = 3;
        int expected = 5;
        int result = calculator.sum(n1, n2);
        if (result != expected) {
            fail("Fallo el metodo sum con los datos " + n1 + " y " + n2);
        }
    }

    @Test
    public void testDiff() {
        int n1 = 3;
        int n2 = 2;
        int expected = 1;
        int result = calculator.diff(n1, n2);
        if (result != expected) {
            fail("Fallo el metodo diff con los datos " + n1 + " y " + n2);
        }
    }
}

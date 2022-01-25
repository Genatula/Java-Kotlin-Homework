import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void sum() {
        assertEquals(5.0, calculator.calculate(2, "+", 3));
    }

    @Test
    public void sumWithZero() {
        assertEquals(5.0, calculator.calculate(5, "+", 0));
    }

    @Test
    public void sumWithNegative() {
        assertEquals(-5.0, calculator.calculate(-2, "+", -3));
    }

    @Test
    public void difference() {
        assertEquals(1.0, calculator.calculate(2, "-", 1));
    }

    @Test
    public void differenceWithZero() {
        assertEquals(2.0, calculator.calculate(2.0, "-", 0));
    }

    @Test
    public void differenceEqualsToZero() {
        assertEquals(0.0, calculator.calculate(2, "-", 2));
    }

    @Test
    public void differenceWithNegative() {
        assertEquals(5.0, calculator.calculate(2, "-", -3));
    }

    @Test
    public void sumEqualsToZero() {
        assertEquals(0.0, calculator.calculate(2, "+", -2));
    }

    @Test
    public void multiplication() {
        assertEquals(6.0, calculator.calculate(2, "*", 3));
    }

    @Test
    public void multiplicationWithZero() {
        assertEquals(0.0, calculator.calculate(2.0, "*", 0));
    }

    @Test
    public void multiplicationWithOneNegative() {
        assertEquals(-6.0, calculator.calculate(-2, "*", 3));
    }

    @Test
    public void multiplicationWithTwoNegatives() {
        assertEquals(6.0, calculator.calculate(2, "*", 3));
    }

    @Test
    public void division() {
        assertEquals(2.0 / 3, calculator.calculate(2, "/", 3));
    }

    @Test
    public void divisionEqualsToZero() {
        assertEquals(0.0, calculator.calculate(0, "/", 1));
    }

    @Test
    public void divisionWithOneNegative() {
        assertEquals(-1.0, calculator.calculate(1, "/", -1));
    }

    @Test
    public void divisionWithTwoNegatives() {
        assertEquals(1.0, calculator.calculate(3, "/", 3.0));
    }

    @Test
    public void divisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, "/", 0));
    }

    @Test
    public void notSupportedSign() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(1, ".", 1));
    }
}
import org.junit.Assert.*
import org.junit.Test
import kotlin.test.assertFailsWith

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun sum() {
        assertEquals(5.0, calculator.calculate(2, "+", 3))
    }

    @Test
    fun sumWithZero() {
        assertEquals(5.0, calculator.calculate(5, "+", 0))
    }

    @Test
    fun sumWithNegative() {
        assertEquals(-5.0, calculator.calculate(-2, "+", -3))
    }

    @Test
    fun difference() {
        assertEquals(1.0, calculator.calculate(2, "-", 1))
    }

    @Test
    fun differenceWithZero() {
        assertEquals(2.0, calculator.calculate(2.0, "-", 0))
    }

    @Test
    fun differenceEqualsToZero() {
        assertEquals(0.0, calculator.calculate(2, "-", 2))
    }

    @Test
    fun differenceWithNegative() {
        assertEquals(5.0, calculator.calculate(2, "-", -3))
    }

    @Test
    fun sumEqualsToZero() {
        assertEquals(0.0, calculator.calculate(2, "+", -2))
    }

    @Test
    fun multiplication() {
        assertEquals(6.0, calculator.calculate(2, "*", 3))
    }

    @Test
    fun multiplicationWithZero() {
        assertEquals(0.0, calculator.calculate(2.0, "*", 0))
    }

    @Test
    fun multiplicationWithOneNegative() {
        assertEquals(-6.0, calculator.calculate(-2, "*", 3))
    }

    @Test
    fun multiplicationWithTwoNegatives() {
        assertEquals(6.0, calculator.calculate(2, "*", 3))
    }

    @Test
    fun division() {
        assertEquals(2.0 / 3, calculator.calculate(2, "/", 3))
    }

    @Test
    fun divisionEqualsToZero() {
        assertEquals(0.0, calculator.calculate(0, "/", 1))
    }

    @Test
    fun divisionWithOneNegative() {
        assertEquals(-1.0, calculator.calculate(1, "/", -1))
    }

    @Test
    fun divisionWithTwoNegatives() {
        assertEquals(1.0, calculator.calculate(3, "/", 3.0))
    }

    @Test
    fun divisionByZero() {
        assertFailsWith<ArithmeticException> {
            calculator.calculate(1, "/", 0)
        }
    }

    @Test
    fun notSupportedSign() {
        assertFailsWith<IllegalArgumentException> {
            calculator.calculate(1, ".", 1)
        }
    }
}

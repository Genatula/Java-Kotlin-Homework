import org.junit.Assert.*
import org.junit.Test
import kotlin.test.assertFailsWith

class CalculatorInputParserTest {

    private val parser: AbstractParser = CalculatorInputParser()

    @Test
    fun parse() {
        val data = ArrayList<String>(listOf("2", "+", "2"))
        val newData = parser.parse(data)
        assertArrayEquals(data.toArray(), newData.toArray())
    }

    @Test
    fun validateWithLessThanThreeArgs() {
        val data = ArrayList<String>(listOf("2", "2"))
        assertFailsWith<IllegalArgumentException> {
            parser.parse(data)
        }
    }

    @Test
    fun validateWithMoreThanThreeArgs() {
        val data = ArrayList<String>(listOf("2", "+", "2", "+"))
        assertFailsWith<IllegalArgumentException> {
            parser.parse(data)
        }
    }

    @Test
    fun validateWithoutFirstNumber() {
        val data = ArrayList<String>(listOf("+","2", "2"))
        assertFailsWith<IllegalArgumentException> {
            parser.parse(data)
        }
    }

    @Test
    fun validateWithoutSecondNumber() {
        val data = ArrayList<String>(listOf("2", "2", "+"))
        assertFailsWith<IllegalArgumentException> {
            parser.parse(data)
        }
    }
}
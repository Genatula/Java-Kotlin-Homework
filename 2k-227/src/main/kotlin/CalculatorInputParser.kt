
import java.lang.NumberFormatException
import java.util.ArrayList
import kotlin.IllegalArgumentException

class CalculatorInputParser : AbstractParser() {
    override fun parse(data: ArrayList<String>): ArrayList<String> {
        validate(data)
        return data
    }

    override fun validate(data: ArrayList<String>) {
        if (data.size != 3) { throw IllegalArgumentException("Incorrect input: 3 arguments must be provided") }
        try {
            data[0].toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Incorrect input: the first argument must be a number")
        }
        try {
            data[2].toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Incorrect input: the third argument must be a number")
        }
    }
}
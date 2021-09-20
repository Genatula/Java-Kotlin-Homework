import java.lang.ArithmeticException
import java.lang.Double.parseDouble

class Calculator : AbstractCalculator() {
    override fun calculate(firstNum: Number, sign: String, secondNum: Number): Number {
        val firstValue = firstNum.toDouble()
        val secondValue = secondNum.toDouble()

        val answer = when (sign) {
            "+" -> firstValue + secondValue
            "-" -> firstValue - secondValue
            "*" -> firstValue * secondValue
            "/" -> {
                if (secondValue == 0.0) {
                    throw ArithmeticException("Division by zero is not allowed")
                }
                else {
                    firstValue / secondValue
                }
            }
            else -> throw IllegalArgumentException("Unsupported operation. Supported signs: +, -, *, /")
        }

        return answer
    }

}

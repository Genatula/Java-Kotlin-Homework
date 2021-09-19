import java.lang.ArithmeticException
import java.lang.Double.parseDouble

//public class Calculator extends AbstractCalculator {
//    @Override
//    public Number calculate(Number firstNum, String sign, Number secondNum) {
//        Double answer;
//        Double firstValue = Double.valueOf(String.valueOf(firstNum));
//        Double secondValue = Double.valueOf(String.valueOf(secondNum));
//
//        switch (sign) {
//            case "+" -> answer = firstValue + secondValue;
//            case "-" -> answer = firstValue - secondValue;
//            case "*" -> answer = firstValue * secondValue;
//            case "/" -> {
//                if (secondValue == 0.0) {
//                    throw new ArithmeticException("Division by zero is not allowed");
//                }
//                answer = firstValue / secondValue;
//            }
//            default -> throw new IllegalArgumentException("Provided sign is not supported. Supported signs : +, -, *, /");
//        }
//        return answer;
//    }
//}

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

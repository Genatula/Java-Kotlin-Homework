public class Calculator extends AbstractCalculator {
    @Override
    public Number calculate(Number firstNum, String sign, Number secondNum) {
        Double answer;
        Double firstValue = Double.valueOf(String.valueOf(firstNum));
        Double secondValue = Double.valueOf(String.valueOf(secondNum));

        switch (sign) {
            case "+" -> answer = firstValue + secondValue;
            case "-" -> answer = firstValue - secondValue;
            case "*" -> answer = firstValue * secondValue;
            case "/" -> {
                if (secondValue == 0.0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                answer = firstValue / secondValue;
            }
            default -> throw new IllegalArgumentException("Provided sign is not supported. Supported signs : +, -, *, /");
        }
        return answer;
    }
}

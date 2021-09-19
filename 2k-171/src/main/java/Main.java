import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>(List.of(args));
        AbstractParser parser = new CalculatorInputParser();
        AbstractCalculator calculator = new Calculator();

        data = parser.parse(data);
        Number firstValue = Double.parseDouble(data.get(0));
        Number secondValue = Double.parseDouble(data.get(2));
        String sign = (String) data.get(1);
        Number result = calculator.calculate(firstValue, sign, secondValue);

        System.out.println(result);
    }
}

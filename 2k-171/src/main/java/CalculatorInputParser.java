import java.util.ArrayList;

public class CalculatorInputParser extends AbstractParser {
    @Override
    public ArrayList<String> parse(ArrayList<String> data) {
        validate(data);
        return data;
    }

    @Override
    protected void validate(ArrayList<String> data) {
        if (data.size() != 3) {
            throw new IllegalArgumentException("Incorrect input: 3 arguments must be provided");
        }
        try {
            Double.parseDouble(data.get(0));
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Incorrect input: the first argument must be a number");
        }
        try {
            Double.parseDouble(data.get(2));
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Incorrect input: the third argument must be a number");
        }
    }
}

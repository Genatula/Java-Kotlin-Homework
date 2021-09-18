import java.util.ArrayList;

public class CalculatorInputParser extends AbstractParser{
    @Override
    public ArrayList<?> parse(ArrayList<?> data) {
        validate(data);
        return data;
    }

    @Override
    protected void validate(ArrayList<?> data) {
        if (data.size() != 3) {
            throw new IllegalArgumentException("Incorrect input: 3 arguments must be provided");
        }
        else if (!(data.get(0) instanceof Number)) {
            throw new IllegalArgumentException("Incorrect input: the first argument must be a number");
        }
        else if (!(data.get(2) instanceof Number)) {
            throw new IllegalArgumentException("Incorrect input: the third argument must be a number");
        }
        else if (!(data.get(1) instanceof String)) {
            throw new IllegalArgumentException("Incorrect input: the second argument must be a symbol");
        }
    }
}

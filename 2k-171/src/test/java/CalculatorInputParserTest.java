import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CalculatorInputParserTest {

    private final AbstractParser parser = new CalculatorInputParser();

    @Test
    public void parse() {
        ArrayList<String> data = new ArrayList<>(List.of("2", "+", "2"));
        ArrayList<String> newData = parser.parse(data);
        Assert.assertArrayEquals(new ArrayList[]{data}, new ArrayList[]{newData});
    }

    @Test
    public void validateWithLessThanThreeArgs() {
        ArrayList<String> data = new ArrayList<>(List.of("2", "2"));
        Assert.assertThrows(IllegalArgumentException.class, () -> parser.validate(data));
    }

    @Test
    public void validateWithMoreThanThreeArgs() {
        ArrayList<String> data = new ArrayList<>(List.of("2", "+", "2", "+"));
        Assert.assertThrows(IllegalArgumentException.class, () -> parser.validate(data));
    }

    @Test
    public void validateWithoutFirstNumber() {
        ArrayList<String> data = new ArrayList<>(List.of("+", "2", "2"));
        Assert.assertThrows(IllegalArgumentException.class, () -> parser.validate(data));
    }

    @Test
    public void validateWithoutSecondNumber() {
        ArrayList<String> data = new ArrayList<>(List.of("2", "2", "+"));
        Assert.assertThrows(IllegalArgumentException.class, () -> parser.validate(data));
    }
}
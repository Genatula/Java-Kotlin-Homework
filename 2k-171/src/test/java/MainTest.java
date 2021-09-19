import org.junit.Assert;
import org.junit.Test;


public class MainTest {

    @Test
    public void mainWithLessThanThreeArgs() {
        String[] args = new String[]{"2", "+"};
        Assert.assertThrows(IllegalArgumentException.class, () -> Main.main(args));
    }

    @Test
    public void mainWithMoreThanThreeArgs() {
        String[] args = new String[]{"2", "+", "2", "+"};
        Assert.assertThrows(IllegalArgumentException.class, () -> Main.main(args));
    }

    @Test
    public void mainWithoutFirstNumber() {
        String[] args = new String[]{"+", "2", "2"};
        Assert.assertThrows(IllegalArgumentException.class, () -> Main.main(args));
    }

    @Test
    public void mainWithoutSecondNumber() {
        String[] args = new String[]{"2", "2", "+"};
        Assert.assertThrows(IllegalArgumentException.class, () -> Main.main(args));
    }

    @Test
    public void mainDivisionByZero() {
        String[] args = new String[]{"2", "/", "0"};
        Assert.assertThrows(ArithmeticException.class, () -> Main.main(args));
    }

    @Test
    public void mainUnsupportedOperation() {
        String[] args = new String[]{"2", "2", "2"};
        Assert.assertThrows(IllegalArgumentException.class, () -> Main.main(args));
    }
}
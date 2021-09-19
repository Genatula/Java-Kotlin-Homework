import java.util.ArrayList;

public abstract class AbstractParser {
    public abstract ArrayList<String> parse(ArrayList<String> data);
    protected abstract void validate(ArrayList<String> data);
}

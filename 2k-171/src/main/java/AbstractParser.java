import java.util.ArrayList;

public abstract class AbstractParser {
    public abstract ArrayList<?> parse(ArrayList<?> data);
    protected abstract void validate(ArrayList<?> data);
}

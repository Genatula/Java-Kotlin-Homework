import java.util.ArrayList

abstract class AbstractParser {
    abstract fun parse(data: ArrayList<String>): ArrayList<String>
    abstract fun validate(data: ArrayList<String>)
}
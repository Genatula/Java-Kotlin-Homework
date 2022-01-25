import arrow.core.andThen
import arrow.core.partially1

class Calculator {
    fun calculate(vararg params: Pair<(Int) -> Int, Int>) : Int {
        val res = params.map {
            val v = it.first.partially1(it.second)
            val f = {x: Int -> x + v()}
            f
        }.reduce{ first, second -> first andThen second}
        return res(0)
    }

    val add = { x: Int, y: Int -> x + y }
    val subtract = { x: Int, y: Int -> x - y }
    val multiply = { x: Int, y: Int -> x * y }
    val divide = { x: Int, y: Int -> x / y }
}
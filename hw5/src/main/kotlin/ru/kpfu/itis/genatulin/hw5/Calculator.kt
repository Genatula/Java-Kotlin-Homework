package ru.kpfu.itis.genatulin.hw5

import org.springframework.stereotype.Component

@Component
class Calculator {
    fun add(arg1 : Int, arg2 : Int) : Int {
        return arg1 + arg2
    }

    fun subtract(arg1 : Int, arg2 : Int) : Int {
        return arg1 - arg2
    }

    fun multiply(arg1: Int, arg2: Int) : Int {
        return arg1 * arg2
    }

    fun divide(arg1: Int, arg2: Int) : Int {
        return arg1 / arg2
    }
}
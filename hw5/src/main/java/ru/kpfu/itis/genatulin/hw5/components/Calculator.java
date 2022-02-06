package ru.kpfu.itis.genatulin.hw5.components;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public Integer add(Integer arg1, Integer arg2) {
        return arg1 + arg2;
    }

    public Integer subtract(Integer arg1, Integer arg2) {
        return arg1 - arg2;
    }

    public Integer multiply(Integer arg1, Integer arg2) {
        return arg1 * arg2;
    }

    public Integer divide(Integer arg1, Integer arg2) {
        return arg1 / arg2;
    }
}

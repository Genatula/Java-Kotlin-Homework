package ru.kpfu.itis.genatulin.hw5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.genatulin.hw5.Calculator;
import ru.kpfu.itis.genatulin.hw5.entities.Operation;
import ru.kpfu.itis.genatulin.hw5.repositories.CalculationRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

@Service
public class CalculatorService {

    private final Calculator calculator;
    private final CalculationRepository calculationRepository;

    @Autowired
    public CalculatorService(Calculator calculator, CalculationRepository calculationRepository) {
        this.calculator = calculator;
        this.calculationRepository = calculationRepository;
    }

    public int calculate(int arg1, int arg2, Operation operation) {
        Class<? extends Calculator> calculatorClass = calculator.getClass();
        try {
            Method method = calculatorClass.getMethod(operation.name().toLowerCase(Locale.ROOT), Integer.class, Integer.class);
            Integer result = (Integer) method.invoke(calculator, arg1, arg2);
            return result;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return (Integer) null;
        }
    }

    private int findResult(int arg1, int arg2, Operation operation) {

    }
}

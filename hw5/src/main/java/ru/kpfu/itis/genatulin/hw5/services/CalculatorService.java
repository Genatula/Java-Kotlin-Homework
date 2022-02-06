package ru.kpfu.itis.genatulin.hw5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.genatulin.hw5.components.Calculator;
import ru.kpfu.itis.genatulin.hw5.entities.Calculation;
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

    public Integer calculate(int arg1, int arg2, Operation operation) throws NoSuchMethodException {
        Calculation calculation = calculationRepository.getCalculation(arg1, arg2, operation);
        if (calculation != null) {
            return calculation.getResult();
        }
        else {
            Class<? extends Calculator> calculatorClass = calculator.getClass();
            try {
                Method[] methods = calculatorClass.getMethods();
                Method method = calculatorClass.getMethod(operation.name().toLowerCase(Locale.ROOT), Integer.class, Integer.class);
                Integer result = (Integer) method.invoke(calculator, arg1, arg2);

                Calculation newCalculation = new Calculation();
                newCalculation.setArg1(arg1);
                newCalculation.setArg2(arg2);
                newCalculation.setOperation(operation);
                newCalculation.setResult(result);
                calculationRepository.saveCalculation(newCalculation);

                return result;
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}

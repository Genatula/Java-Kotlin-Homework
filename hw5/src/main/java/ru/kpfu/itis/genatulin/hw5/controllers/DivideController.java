package ru.kpfu.itis.genatulin.hw5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.genatulin.hw5.entities.Operation;
import ru.kpfu.itis.genatulin.hw5.services.CalculatorService;

@Controller
@RequestMapping(value = "/divide")
public class DivideController {
    private final CalculatorService service;

    @Autowired
    public DivideController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getResult(@RequestParam(name = "a") int arg1, @RequestParam(name = "b") int arg2) {
        try {
            Integer result = service.calculate(arg1, arg2, Operation.DIVIDE);
            return arg1 + " / " + arg2 + " = " + result;
        } catch (NoSuchMethodException e) {
            return "Something went wrong";
        }
    }
}

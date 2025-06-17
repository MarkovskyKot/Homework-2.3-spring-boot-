package com.markovsky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService, GlobalExceptionHandler globalExceptionHandler) {
        this.calculatorService = calculatorService;
    }


    @GetMapping
    public String showGreetings() {
        return calculatorService.showGreeting();
    }

    @GetMapping("/plus")
    public String sumOperation(@RequestParam(required = true, name = "num1") String num1Str,
                               @RequestParam(required = true, name = "num2") String num2Str) {
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            throw new InvalidParameterException("Параметры не могут быть пустыми!");
        }
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        int result = calculatorService.sum(num1, num2);
        return num1 + "+" + num2 + "=" + result;
    }

    @GetMapping("/minus")
    public String subtractOperation(@RequestParam(required = true, name = "num1") String num1Str,
                                    @RequestParam(required = true, name = "num2") String num2Str) {
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            throw new InvalidParameterException("Параметры не могут быть пустыми!");
        }
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        int result = calculatorService.subtract(num1, num2);
        return num1 + "-" + num2 + "=" + result;
    }

    @GetMapping("/multiply")
    public String multiplyOperation(@RequestParam(required = true, name = "num1") String num1Str,
                                    @RequestParam(required = true, name = "num2") String num2Str) {
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            throw new InvalidParameterException("Параметры не могут быть пустыми!");
        }
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        int result = calculatorService.multiply(num1, num2);
        return num1 + "*" + num2 + "=" + result;
    }

    @GetMapping("/divide")
    public String divideOperation(@RequestParam(required = true, name = "num1") String num1Str,
                                  @RequestParam(required = true, name = "num2") String num2Str) {
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            throw new InvalidParameterException("Параметры не могут быть пустыми!");
        }
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        if (num2 == 0) {
            return "Братан, нельзя так просто взять и разделить на ноль.";
        }
        int result = calculatorService.divide(num1, num2);
        return num1 + "/" + num2 + "=" + result;
    }

}

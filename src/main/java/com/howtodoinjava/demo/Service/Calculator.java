package com.howtodoinjava.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;


public class Calculator {
    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    private CalculatorService calculatorService;


    public int perform (int i, int j){
        return calculatorService.add(i,j)*i;
    }
}

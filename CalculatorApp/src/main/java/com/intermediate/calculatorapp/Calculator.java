package com.intermediate.calculatorapp;

public class Calculator {
    private double firstNumber;
    private double secondNumber;

    public Calculator() {}
    public Calculator(double firstNumber, double secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double addition(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double division(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }

    public double subtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double modulo(double firstNumber, double secondNumber) {
        return firstNumber % secondNumber;
    }

    public double calculation(String operator, double firstNumber, double secondNumber) {
        return switch(operator) {
            case "sum" -> addition(firstNumber, secondNumber);
            case "multiply" -> multiply(firstNumber, secondNumber);
            case "divide" -> division(firstNumber, secondNumber);
            case "subtract" -> subtraction(firstNumber, secondNumber);
            case "modulo" -> modulo(firstNumber, secondNumber);
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}

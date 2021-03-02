package com.epam.task.fifth.logic;


import java.util.Stack;

public class ExpressionCalculator implements Calculator {

    public static final String SPLITTER = " ";
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';


    @Override
    public double calculate(String expression) throws CalculatorException {
        expression = expression.substring(1, expression.length() - 1);

        Stack<Double> valuesStack = new Stack<>();


        String[] values = expression.split(SPLITTER);

        for (String value : values) {
            char currentCharacter = value.charAt(0);

            if (isNumber(currentCharacter)) {
                valuesStack.push(Double.parseDouble(value));
            } else {
                double secondNumber = valuesStack.pop();
                double firstNumber = valuesStack.pop();

                double result = makeOperation(firstNumber, secondNumber, currentCharacter);

                valuesStack.push(result);
            }
        }

        return valuesStack.pop();

    }

    private boolean isNumber(Character character) {
        return character >= '0' && character <= '9';
    }

    private double makeOperation(double firstNumber, double secondNumber, char operation) throws CalculatorException {
        double result;
        switch (operation) {
            case PLUS:
                result = firstNumber + secondNumber;
                break;
            case MINUS:
                result = firstNumber - secondNumber;
                break;
            case MULTIPLY:
                result = firstNumber * secondNumber;
                break;
            case DIVIDE:
                result = firstNumber / secondNumber;
                break;
            default:
                throw new CalculatorException("Wrong operation in expression");
        }
        return result;
    }

}

package com.epam.task.fifth.logic;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {

    public static final String EXPRESSION = "[7 2 3.0 * -]";

    @Test
    public void testCalculate() throws CalculatorException {
        //given
        ExpressionCalculator calculator = new ExpressionCalculator();
        //when
        double actual = calculator.calculate(EXPRESSION);
        //then
        Assert.assertEquals(1.0, actual, 1e-15);
    }
}

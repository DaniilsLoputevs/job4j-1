package ru.job4j.calculator;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    /**
     * Тест на прибавление.
     */

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Тест на вычитание.
     */

    @Test
    public void whenAddOneSubOneThenTwo() {
        Calculator calc = new Calculator();
        calc.sub(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }

    /**
     *Тест на умножение.
     */

    @Test
    public void whenAddOneMultipleOneThenTwo() {
        Calculator calc = new Calculator();
        calc.multple(5D, 5D);
        double result = calc.getResult();
        double expected = 25D;
        assertThat(result, is(expected));
    }

    /**
     * Тест на деление
     */
    @Test
    public void whenAddOneDivOneThenTwo() {
        Calculator calc = new Calculator();
        calc.div(10D, 5D);
        double result = calc.getResult();
        double expexted = 2D;
        assertThat(result, is(expexted));
    }
}
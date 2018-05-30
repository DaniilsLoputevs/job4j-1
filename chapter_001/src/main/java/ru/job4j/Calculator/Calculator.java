package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Calculator {
    /**
     * Внутреннее поле с типом данных double[result].
     */
    private double result;


    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * subtract.
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }

    /**
     * multiplication.
     */
    public void multple(double first, double second) {
        this.result = first * second;
    }

    /**
     * div.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Возвращает значение поля result.
     */
    public double getResult() {
        return this.result;

    }


}
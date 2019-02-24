package ru.job4j.calculator;

/**
 * calculator.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Calculator {
    /**
     * mathematical operations with variables.
     */
    private double result;


    public void add(double first, double second) {
        this.result = first + second;
    }


    public void sub(double first, double second) {
        this.result = first - second;
    }


    public void multple(double first, double second) {
        this.result = first * second;
    }


    public void div(double first, double second) {
        this.result = first / second;
    }

    public double getResult() {
        return this.result;

    }


}
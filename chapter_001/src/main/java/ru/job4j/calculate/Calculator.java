package ru.job4j.calculate;

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

    /**
     * method : addition.
     *
     * @param first
     * @param second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * @method subtract
     *
     * @param first
     * @param second
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }

    /**
     * @method  multiplication
     *
     * @param first
     * @param second
     */
    public void multple(double first, double second) {
        this.result = first * second;
    }

    /**
     * @method div
     *
     * @param first
     * @param second
     */
      public void div(double first, double second) {
          this.result = first  / second;
      }
    /**
     * @method : Возвращает значение поля result
     *
     * @return
     */
    public double getResult() {
        return this.result;

    }


}
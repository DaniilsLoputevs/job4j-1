package ru.job4j.ood.calculatorood;


import ru.job4j.calculator.Calculator;

import java.util.Set;

public class ScientificCalc implements Calculation {
    private IterCalc iterCalc;


    public ScientificCalc(IterCalc iterCalc) {
        this.iterCalc = iterCalc;
    }

    public Set<String> getActions() {
        return this.iterCalc.getActions();
    }

    /**
     * Метод операции сложения.
     *
     * @param first  первое значение.
     * @param second второе значение.
     * @return результат.
     */
    public double add(double first, double second) {
        return this.iterCalc.add(first, second);
    }

    /**
     * Метод операции вычитания
     *
     * @param first  первое значение.
     * @param second второе значение.
     * @return результат.
     */
    public double sub(double first, double second) {
        return this.iterCalc.sub(first, second);
    }

    /**
     * Метод операции умножения.
     *
     * @param first  первое значение.
     * @param second второе значение.
     * @return результат.
     */
    public double multiply(double first, double second) {
        return this.iterCalc.multiply(first, second);
    }

    /**
     * Метод операции деления.
     *
     * @param first  первое значение.
     * @param second второе значение.
     * @return результат.
     */
    public double div(double first, double second) {
        return this.iterCalc.div(first, second);
    }

    /**
     * Метод операции нахождения синуса
     *
     * @param first  - первое значение
     * @param second - второе значение
     * @return результат
     */
    public double sin(double first, double second) {
        return this.iterCalc.div(first, second);
    }

    /**
     * Метод операции нахождения косинуса.
     *
     * @param leg        - значение катета.
     * @param hypotenuse - значение гипотинузы.
     * @return результат.
     */
    public double cos(double leg, double hypotenuse) {
        return this.iterCalc.div(leg, hypotenuse);
    }

    /**
     * заполенение Map ключами-операциями.
     */
    public void init() {
        this.iterCalc.init();
        this.iterCalc.actions.put("sin", this::sin);
        this.iterCalc.actions.put("cos", this::cos);
    }

    /**
     * Метод доступа к операциями .
     *
     * @param op - ключ.
     * @param f  - первое значение.
     * @param s  - второе значение.
     * @return результат.
     */
    public double operation(String op, Double f, Double s) {
        return this.iterCalc.operation(op, f, s);
    }

    /**
     * Метод доступа к операциями используя предыдущее вычисление.
     *
     * @param op - ключ.
     * @param s  - значение.
     * @return результат.
     */
    public double operation(String op, Double s) {
        return this.iterCalc.operation(op, s);
    }

    public void show() {
        this.iterCalc.show();
    }


}

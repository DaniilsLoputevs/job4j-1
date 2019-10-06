package ru.job4j.ood.calculatorood;

import ru.job4j.calculator.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class IterCalc implements Calculation {
    private Calculator calculator;
    protected Map<String, BiFunction<Double, Double, Double>> actions;


    public IterCalc(Calculator calculator) {
        this.calculator = calculator;
        this.actions = new HashMap<>();
    }

    /**
     * Метод возвращает ключи для запуска методов
     *
     * @return ключи.
     */
    public Set<String> getActions() {
        return actions.keySet();
    }

    /**
     * Метод выполняет операцию сложения
     *
     * @param first  первое значение
     * @param second второе значение
     * @return результат.
     */
    public double add(double first, double second) {
        this.calculator.add(first, second);
        return this.calculator.getResult();
    }

    /**
     * Метод выполняет операцию вычитания
     *
     * @param first  первое значение
     * @param second второе значение
     * @return результат
     */
    public double sub(double first, double second) {
        this.calculator.sub(first, second);
        return this.calculator.getResult();
    }

    /**
     * Метод выполняет операцию умножения
     *
     * @param first  первое значение
     * @param second второе значение
     * @return результат
     */
    public double multiply(double first, double second) {
        this.calculator.multple(first, second);
        return this.calculator.getResult();
    }

    /**
     * Метод выполняет операцию деления
     *
     * @param first  первое значение
     * @param second второе значение
     * @return результат
     */
    public double div(double first, double second) {
        this.calculator.div(first, second);
        return this.calculator.getResult();
    }

    /**
     * Заполнение HashMap значениями (ключ-операция)
     */
    public void init() {
        this.actions.put("+", this::add);
        this.actions.put("-", this::sub);
        this.actions.put("*", this::multiply);
        this.actions.put("/", this::div);
    }

    /**
     * Метод доступа к операциям в Map
     *
     * @param op - требуемая операция
     * @param f  - первое значение
     * @param s  - второе значение
     * @return результат
     */
    @Override
    public double operation(String op, Double f, Double s) {
        this.actions.get(op).apply(f, s);
        return this.calculator.getResult();
    }

    /**
     * Метод доступа к операциям при использовании предыдущего результата вычисления
     *
     * @param op - требуемая операция
     * @param s  - вводимое значение
     * @return - результат
     */
    @Override
    public double operation(String op, Double s) {
        this.actions.get(op).apply(calculator.getResult(), s);
        return calculator.getResult();
    }

    /**
     * Метод отображения в меню - возвращаются доступные ключи
     */

    public void show() {
        this.actions.keySet().forEach(System.out::println);
    }

}

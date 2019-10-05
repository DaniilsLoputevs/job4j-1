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

    public Set<String> getActions() {
        return actions.keySet();
    }

    public double add(double first, double second) {
        this.calculator.add(first, second);
        return this.calculator.getResult();
    }

    public double sub(double first, double second) {
        this.calculator.sub(first, second);
        return this.calculator.getResult();
    }

    public double multiply(double first, double second) {
        this.calculator.multple(first, second);
        return this.calculator.getResult();
    }

    public double div(double first, double second) {
        this.calculator.div(first, second);
        return this.calculator.getResult();
    }


    public void init() {
        this.actions.put("+", this::add);
        this.actions.put("-", this::sub);
        this.actions.put("*", this::multiply);
        this.actions.put("/", this::div);
    }

    @Override
    public double operation(String op, Double f, Double s) {
        this.actions.get(op).apply(f, s);
        return this.calculator.getResult();
    }

    @Override
    public double operation(String op, Double s) {
        this.actions.get(op).apply(calculator.getResult(), s);
        return calculator.getResult();
    }

    public void show() {
        this.actions.keySet().forEach(System.out::println);
    }


    public static void main(String[] args) {
        IterCalc iterCalc = new IterCalc(new Calculator());
        iterCalc.init();
        iterCalc.show();
    }

}

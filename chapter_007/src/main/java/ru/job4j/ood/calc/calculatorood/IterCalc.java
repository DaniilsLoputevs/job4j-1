package ru.job4j.ood.calc.calculatorood;

import ru.job4j.calculator.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class IterCalc {
    private Calculator calculator;
    private Map<String, BiFunction<Double, Double, Double>> actions;


    public IterCalc() {
        this.calculator = new Calculator();
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

    public double operation(String op, Double f, Double s) {
        this.actions.get(op).apply(f, s);
        return calculator.getResult();
    }

    public double operation(String op, Double s) {
        this.actions.get(op).apply(calculator.getResult(), s);
        return calculator.getResult();
    }

    public void show() {
        this.actions.keySet().forEach(System.out::println);
    }


    public static void main(String[] args) {
        IterCalc iterCalc = new IterCalc();
        iterCalc.init();
        iterCalc.show();
    }

}

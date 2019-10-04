package ru.job4j.ood.calculatorood;


import ru.job4j.calculator.Calculator;

import java.util.Set;

public class ScientificCalc extends IterCalc {

    public ScientificCalc(Calculator calculator) {
        super(calculator);
    }

    @Override
    public Set<String> getActions() {
        return super.getActions();
    }

    @Override
    public double add(double first, double second) {
        return super.add(first, second);
    }

    @Override
    public double sub(double first, double second) {
        return super.sub(first, second);
    }

    @Override
    public double multiply(double first, double second) {
        return super.multiply(first, second);
    }

    @Override
    public double div(double first, double second) {
        return super.div(first, second);
    }

    public double sin(double first, double second) {
        return super.div(first, second);
    }

    public double cos(double leg, double hypotenuse) {
        return super.div(leg, hypotenuse);
    }

    @Override
    public void init() {
        super.init();
        this.actions.put("sin", this::sin);
        this.actions.put("cos", this::cos);
    }

    @Override
    public double operation(String op, Double f, Double s) {
        return super.operation(op, f, s);
    }

    @Override
    public double operation(String op, Double s) {
        return super.operation(op, s);
    }

    @Override
    public void show() {
        super.show();
    }

    public static void main(String[] args) {
        ScientificCalc s = new ScientificCalc(new Calculator());
        s.init();
        s.getActions().forEach(System.out::println);
    }
}

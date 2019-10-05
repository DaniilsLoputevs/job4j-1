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


    public double add(double first, double second) {
        return this.iterCalc.add(first, second);
    }

    public double sub(double first, double second) {
        return this.iterCalc.sub(first, second);
    }


    public double multiply(double first, double second) {
        return this.iterCalc.multiply(first, second);
    }


    public double div(double first, double second) {
        return this.iterCalc.div(first, second);
    }

    public double sin(double first, double second) {
        return this.iterCalc.div(first, second);
    }

    public double cos(double leg, double hypotenuse) {
        return this.iterCalc.div(leg, hypotenuse);
    }


    public void init() {
        this.iterCalc.init();
        this.iterCalc.actions.put("sin", this::sin);
        this.iterCalc.actions.put("cos", this::cos);
    }


    public double operation(String op, Double f, Double s) {
        return this.iterCalc.operation(op, f, s);
    }


    public double operation(String op, Double s) {
        return this.iterCalc.operation(op, s);
    }

    public void show() {
        this.iterCalc.show();
    }

    public static void main(String[] args) {
        ScientificCalc s = new ScientificCalc(new IterCalc(new Calculator()));
        s.init();
        s.getActions().forEach(System.out::println);
    }
}

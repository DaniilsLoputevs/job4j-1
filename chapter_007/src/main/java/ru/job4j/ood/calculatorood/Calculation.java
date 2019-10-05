package ru.job4j.ood.calculatorood;

public interface Calculation {

    double operation(String op, Double first, Double second);

    double operation(String op, Double first);
}

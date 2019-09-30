package ru.job4j.ood.calc;

import ru.job4j.calculator.Calculator;


public interface ContextExecutor {

    void execute(Calculator calculator);

    String show();
}

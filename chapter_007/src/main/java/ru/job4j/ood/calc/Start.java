package ru.job4j.ood.calc;

import ru.job4j.calculator.Calculator;


public class Start {
    private MenuCalculator menuCalculator;
    private Calculator calculator;

    public Start() {
        this.calculator = new Calculator();
        this.menuCalculator = new MenuCalculator(this.calculator);
    }


    public void init() {
        this.menuCalculator.show();
        do {
            this.menuCalculator.select();
        } while (this.menuCalculator.isWork());

    }

    public static void main(String[] args) {
        Start start = new Start();
        start.init();

    }
}

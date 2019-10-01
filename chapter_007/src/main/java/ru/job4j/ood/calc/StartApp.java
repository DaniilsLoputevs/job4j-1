package ru.job4j.ood.calc;

import ru.job4j.calculator.Calculator;



public class StartApp {
    private MenuCalculator menuCalculator;
    private Calculator calculator;

    public StartApp(MenuCalculator menuCalculator) {
        this.calculator = new Calculator();
        this.menuCalculator = menuCalculator;
    }


    public void init() {
        this.menuCalculator.show();
        do {
            this.menuCalculator.select();
        } while (this.menuCalculator.isWork());

    }

    public static void main(String[] args) {
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator());
        menuCalculator.init();
        StartApp startApp = new StartApp(menuCalculator);
        startApp.init();

    }
}

package ru.job4j.ood.calc;

import ru.job4j.calculator.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCalculator {
    private List<ContextExecutor> context;
    private Scanner scanner;
    private Calculator calculator;
    private boolean work;

    public MenuCalculator(Calculator calculator) {
        this.context = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.calculator = calculator;
        this.work = true;
        this.init();

    }

    /**
     * Инициализация меню
     */
    public void init() {
        this.context.add(new Add(0, "Сложение"));
        this.context.add(new Sub(1, "Вычитание"));
        this.context.add(new Multiply(2, "Умножение"));
        this.context.add(new Div(3, "Деление"));
        this.context.add(new Div(4, "Последний результат"));
        this.context.add(new Exit(5, "Выход"));
    }

    /**
     * Метод отображает меню в консоль
     */
    public void show() {
        for (ContextExecutor contextExecutor : this.context) {
            System.out.println(contextExecutor.show());
        }
    }

    public void select() {
        int key = Integer.parseInt(this.scanner.next());
        this.context.get(key).execute(this.calculator);
    }

    public boolean isWork() {
        return work;
    }

    /**
     * Класс отвечает за сложение в пункте меню.
     */
    private class Add extends Action implements ContextExecutor {


        public Add(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Calculator calculator) {
            double one = Double.parseDouble(scanner.next());
            double two = Double.parseDouble(scanner.next());
            calculator.add(two, one);
            System.out.println(calculator.getResult());
        }

        @Override
        public String show() {
            return this.showAction();
        }
    }

    /**
     * Класс отвечает за вычитание в пункте меню выполнения пункта меню
     */
    private class Sub extends Action implements ContextExecutor {

        public Sub(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Calculator calculator) {
            double one = Double.parseDouble(scanner.next());
            double two = Double.parseDouble(scanner.next());
            calculator.sub(two, one);
        }

        @Override
        public String show() {
            return this.showAction();
        }
    }

    /**
     * Класс отвечает за умножение
     */
    private class Multiply extends Action implements ContextExecutor {

        public Multiply(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Calculator calculator) {
            double one = Double.parseDouble(scanner.next());
            double two = Double.parseDouble(scanner.next());
            calculator.multple(two, one);

        }

        @Override
        public String show() {
            return this.showAction();
        }


    }

    private class Div extends Action implements ContextExecutor {

        public Div(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Calculator calculator) {
            double one = Double.parseDouble(scanner.next());
            double two = Double.parseDouble(scanner.next());
            calculator.div(two, one);

        }

        @Override
        public String show() {
            return this.showAction();
        }


    }
    private class Getlast extends Action implements ContextExecutor {

        public Getlast(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Calculator calculator) {
            double one = Double.parseDouble(scanner.next());
            double two = Double.parseDouble(scanner.next());
            calculator.div(two, one);

        }

        @Override
        public String show() {
            return this.showAction();
        }


    }

    private class Exit extends Action implements ContextExecutor {

        public Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Calculator calculator) {
            work = false;

        }

        @Override
        public String show() {
            return this.showAction();
        }


    }


    public static void main(String[] args) {
        MenuCalculator menuCalculator = new MenuCalculator(new Calculator());
        menuCalculator.init();
        menuCalculator.show();
        menuCalculator.select();
    }

}

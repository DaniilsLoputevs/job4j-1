package ru.job4j.ood.calc.calculatorood;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCalculator {
    private IterCalc iterCalc;
    private List<String> menu;
    private Scanner scanner;
    private ValidateInput validateInput;
    boolean work;

    public MenuCalculator(IterCalc iterCalc, ValidateInput validateInput) {
        this.iterCalc = iterCalc;
        this.menu = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.validateInput = validateInput;
        this.work = true;
    }

    public void show() {
        this.menu.forEach(System.out::println);
    }

    public void input() {
        String op;
        do {
            System.out.println("Ввведите команду");
            op = scanner.next();
            if (this.validateInput.checkInputOperation(op)) {
                System.out.println("введите первое число");
                Double f = scanner.nextDouble();
                System.out.println("введите второе число");
                Double s = scanner.nextDouble();
                System.out.println(this.iterCalc.operation(op, f, s));

            } else if (this.validateInput.checkInputMemoryUse(op)) {
                System.out.println("Введите команду");
                op = scanner.next();
                System.out.println("Введите число");
                Double f = scanner.nextDouble();
                System.out.println(this.iterCalc.operation(op, f));
            }


        } while (!this.validateInput.checkExit(op));
    }

    public void init() {
        this.menu.add("+");
        this.menu.add("-");
        this.menu.add("*");
        this.menu.add("/");
        this.menu.add("m");
        this.menu.add("exit");
    }


    public static void main(String[] args) {
        ValidateInput validateInput = new ValidateInput();
        validateInput.init();
        IterCalc iterCalc = new IterCalc();
        iterCalc.init();
        MenuCalculator menuCalculator = new MenuCalculator(iterCalc, validateInput);
        menuCalculator.init();
        menuCalculator.show();
        menuCalculator.input();
    }

}

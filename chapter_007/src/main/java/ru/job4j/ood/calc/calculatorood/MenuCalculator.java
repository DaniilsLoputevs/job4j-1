package ru.job4j.ood.calc.calculatorood;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class MenuCalculator {
    private IterCalc iterCalc;
    private List<String> menu;
    private Scanner scanner;
    private ValidateInput validateInput;
    private Consumer<String> output;
    boolean work;

    public MenuCalculator(IterCalc iterCalc, ValidateInput validateInput, Consumer<String> output) {
        this.iterCalc = iterCalc;
        this.menu = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.validateInput = validateInput;
        this.output = output;
        this.work = true;
    }

    public void show() {
        this.menu.forEach(output);
    }

    public void inputOutput() {
        String op;
        Double f;
        Double s;
        Double result;
        do {
            System.out.println("Ввведите команду");
            op = scanner.next();
            if (this.validateInput.checkInputOperation(op)) {
                this.output.accept("введите первое число");
                f = scanner.nextDouble();
                this.output.accept("введите второе число");
                s = scanner.nextDouble();
                result = this.iterCalc.operation(op, f, s);
                output.accept(result.toString());

            } else if (this.validateInput.checkInputMemoryUse(op)) {
                output.accept("Введите команду");
                op = scanner.next();
                output.accept("Введите число");
                f = scanner.nextDouble();
                result = this.iterCalc.operation(op, f);
                output.accept(result.toString());
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
        MenuCalculator menuCalculator = new MenuCalculator(iterCalc, validateInput, System.out::println);
        menuCalculator.init();
        menuCalculator.show();
        menuCalculator.inputOutput();
    }

}

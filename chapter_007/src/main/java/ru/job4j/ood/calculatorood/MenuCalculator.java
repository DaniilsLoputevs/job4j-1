package ru.job4j.ood.calculatorood;

import ru.job4j.calculator.Calculator;

import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class MenuCalculator {
    private Calculation calculation;
    private Set<String> menu;
    private Scanner scanner;
    private ValidateInput validateInput;
    private Consumer<String> output;
    boolean work;

    public MenuCalculator(Calculation calculation, Set<String> menu, ValidateInput validateInput, Consumer<String> output) {
        this.calculation = calculation;
        this.menu = menu;
        this.scanner = new Scanner(System.in);
        this.validateInput = validateInput;
        this.output = output;
        this.work = true;
    }

    /**
     * Метод отображения меню
     */
    public void show() {
        this.menu.forEach(output);
    }

    /**
     * Метод ввода и вывода данных
     */
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
                result = this.calculation.operation(op, f, s);
                output.accept(result.toString());

            } else if (this.validateInput.checkInputMemoryUse(op)) {
                output.accept("Введите команду");
                op = scanner.next();
                output.accept("Введите число");
                f = scanner.nextDouble();
                result = this.calculation.operation(op, f);
                output.accept(result.toString());
            }


        } while (!this.validateInput.checkExit(op));
    }


    public Set<String> getMenu() {
        return menu;
    }


}

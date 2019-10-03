package ru.job4j.ood.calc.calculatorood;

import ru.job4j.calculator.Calculator;

import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class MenuCalculator {
    private IterCalc iterCalc;
    private Set<String> menu;
    private Scanner scanner;
    private ValidateInput validateInput;
    private Consumer<String> output;
    boolean work;

    public MenuCalculator(IterCalc iterCalc, Set<String> menu, ValidateInput validateInput, Consumer<String> output) {
        this.iterCalc = iterCalc;
        this.menu = menu;
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


    public Set<String> getMenu() {
        return menu;
    }

    public static void main(String[] args) {
        ScientificCalc scientificCalc = new ScientificCalc(new Calculator());
        scientificCalc.init();
        MenuCalculator menuCalculator = new MenuCalculator(scientificCalc, Set.of("+", "-", "*", "/", "m", "sin", "cos", "exit"), new ValidateInput(Set.of("+", "-", "*", "/", "sin", "cos")), System.out::println);
        menuCalculator.show();
        menuCalculator.inputOutput();
    }

}

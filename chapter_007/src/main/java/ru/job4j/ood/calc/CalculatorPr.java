package ru.job4j.ood.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CalculatorPr {
    private ru.job4j.calculator.Calculator calculator;
    private UserMenu userMenu;
    private UserActions userActions;

    public CalculatorPr() {
        this.calculator = new ru.job4j.calculator.Calculator();
        this.userMenu = new UserMenu();
        this.userActions = new UserActions();
    }

    /**
     * Основной метод инициализации программы с меню и выбором действия
     */
    private void init() {
        Add add = new Add();
        add.inputData();

    }

    /**
     * Приватный класс отвечающий за действие сложения.
     */
    private class Add implements Input {

        @Override
        public void inputData() {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                do {
                    calculator.add(userActions.addActions(br.readLine()), userActions.addActions(br.readLine()));
                } while (userActions.isReady());
                System.out.println(calculator.getResult());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        CalculatorPr calculatorPr = new CalculatorPr();
        calculatorPr.init();
    }
}

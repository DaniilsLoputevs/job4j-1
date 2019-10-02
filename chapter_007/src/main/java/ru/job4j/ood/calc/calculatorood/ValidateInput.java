package ru.job4j.ood.calc.calculatorood;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ValidateInput {
    private Set<String> comands;

    public ValidateInput() {
        this.comands = new TreeSet<>();
    }


    public void init() {
        this.comands.add("+");
        this.comands.add("-");
        this.comands.add("/");
        this.comands.add("*");
        this.comands.add("m");
    }

    public boolean checkInput(String s) {
        return this.comands.contains(s);
    }

    public boolean checkExit(String s) {
        return s.equals("exit");
    }


    public static void main(String[] args) {
        ValidateInput validateInput = new ValidateInput();
        validateInput.init();
        System.out.println(validateInput.checkInput("10"));

        Set<String> a = new TreeSet<>();
        a.add("+");
        System.out.println(a.contains("+"));
    }
    }


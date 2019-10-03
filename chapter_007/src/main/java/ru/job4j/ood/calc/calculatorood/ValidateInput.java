package ru.job4j.ood.calc.calculatorood;

import java.util.Set;

public class ValidateInput {
    private Set<String> comands;

    public ValidateInput(Set<String> menuaction) {
        this.comands = menuaction;
    }

    public boolean checkInputOperation(String s) {
        return this.comands.contains(s);
    }

    public boolean checkInputMemoryUse(String s) {
        return s.equals("m");
    }

    public boolean checkExit(String s) {
        return s.equals("exit");
    }


}


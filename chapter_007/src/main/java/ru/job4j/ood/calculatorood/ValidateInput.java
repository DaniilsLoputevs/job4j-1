package ru.job4j.ood.calculatorood;

import java.util.Set;

public class ValidateInput {
    private Set<String> comands;

    public ValidateInput(Set<String> menuaction) {
        this.comands = menuaction;
    }

    /**
     * Метод проверяет что команда существует .
     *
     * @param s - введенная команда пользователя
     * @return true/false
     */
    public boolean checkInputOperation(String s) {
        return this.comands.contains(s);
    }

    /**
     * Метод проверяет что команда соответствует переиспользованию предыдущего вычисления
     *
     * @param s - введенная команда пользователя
     * @return true/false
     */
    public boolean checkInputMemoryUse(String s) {
        return s.equals("m");
    }

    /**
     * Метод проверяет что пользователь желает выйти из программы
     *
     * @param s - введеная команда пользователя
     * @return true/false
     */
    public boolean checkExit(String s) {
        return s.equals("exit");
    }


}


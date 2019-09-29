package ru.job4j.ood.calc;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {
    private List<String> actions;
    private boolean work;

    public UserMenu() {
        this.actions = new ArrayList<>();
        this.work = true;
        this.initial();
    }

    /**
     * Метод отображения меню пользователя
     */
    public void showMenu() {
        for (String value : this.actions) {
            System.out.println(value);
        }
    }

    /**
     * Инициализация пользовательского меню
     */
    private void initial() {
        this.actions.add("1.Add");
        this.actions.add("2.Sub");
        this.actions.add("3.Multiply");
        this.actions.add("4.Div");
        this.actions.add("5.Result");
        this.actions.add("6.Exit");
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public List<String> getActions() {
        return actions;
    }
}

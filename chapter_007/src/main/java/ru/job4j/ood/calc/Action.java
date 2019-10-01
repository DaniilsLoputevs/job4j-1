package ru.job4j.ood.calc;

public abstract class Action {
    private int key;
    private String name;

    public Action(int key, String name) {
        this.key = key;
        this.name = name;
    }

    private String showAction() {
        return String.format("%s : %s", this.key, this.name);
    }

    @Override
    public String toString() {
        return this.showAction();
    }
}

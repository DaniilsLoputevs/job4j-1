package ru.job4j.ood;

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


    private void initial() {
        this.actions.add("Add");
        this.actions.add("Sub");
        this.actions.add("Multiply");
        this.actions.add("Div");
        this.actions.add("Result");
        this.actions.add("Exit");
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

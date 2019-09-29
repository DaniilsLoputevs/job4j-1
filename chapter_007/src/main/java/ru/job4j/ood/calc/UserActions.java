package ru.job4j.ood.calc;

import java.util.ArrayList;
import java.util.List;

public class UserActions {
    private List<String> actions;
    private boolean ready;

    public UserActions() {
        this.actions = new ArrayList<>();
        this.ready = true;
    }


    public Double addActions(String value) {
        this.chekStop();
        this.actions.add(value);
        return Double.parseDouble(value);
    }

    private boolean chekStop() {
        boolean rs = true;
        if (actions.size() == 1) {
            this.ready = false;
        }
        return rs;
    }

    public boolean isReady() {
        return ready;
    }

    public static void main(String[] args) {
        List<String>  a = new ArrayList<>();
        a.add("s");
        System.out.println(a.size());
    }
}

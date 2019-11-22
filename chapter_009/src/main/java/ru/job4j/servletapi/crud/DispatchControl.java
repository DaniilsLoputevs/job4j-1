package ru.job4j.servletapi.crud;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DispatchControl {

    private Map<String, Function<String, Boolean>> controls = new HashMap<>();


    public Function<String, Boolean> add() {
        return s -> {


            return true;
        };
    }

    public static void main(String[] args) {
        DispatchControl dispatchControl = new DispatchControl();
        dispatchControl.controls.put("add", dispatchControl.add());

    }
}

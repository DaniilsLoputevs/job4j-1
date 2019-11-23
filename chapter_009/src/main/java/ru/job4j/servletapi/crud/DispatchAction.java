package ru.job4j.servletapi.crud;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DispatchAction {
    private final Validate validate = ValidateService.getInstance();
    private final Map<String, Function<Model, Boolean>> map = new HashMap<>();

    public DispatchAction() {
        init();
    }


    public Map<String, Function<Model, Boolean>> getMap() {
        return map;
    }


    private void init() {
        map.put("add", validate::add);
        map.put("update", validate::update);
    }
}

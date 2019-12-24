package ru.job4j.servletapi.crud;

import ru.job4j.servletapi.crud.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DispatchAction {
    private final Validate validate = ValidateService.getInstance();
    private final Map<String, Function<User, Boolean>> map = new HashMap<>();

    public DispatchAction() {
        init();
    }


    public Map<String, Function<User, Boolean>> getMap() {
        return map;
    }


    private void init() {
        map.put("add", validate::add);
        map.put("update", validate::update);
        map.put("delete", validate::delete);
        map.put("findbyid", validate::findById);

    }
}

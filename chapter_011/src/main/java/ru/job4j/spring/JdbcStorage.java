package ru.job4j.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JdbcStorage implements Storage {
    private final DbInterface dbInterface;

    @Autowired
    public JdbcStorage(DbInterface dbInterface) {
        this.dbInterface = dbInterface;
    }

    @Override
    public void add(User user) {

    }
}

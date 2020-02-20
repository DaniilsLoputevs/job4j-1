package ru.job4j.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserStorage {
    private final Storage storage;


    @Autowired
    public UserStorage(@Qualifier("jdbcStorage") final Storage storage) {
        this.storage = storage;
    }

    public User add(User user) {
        storage.add(user);
        return user;
    }

    public Storage getStorage() {
        return storage;
    }
}

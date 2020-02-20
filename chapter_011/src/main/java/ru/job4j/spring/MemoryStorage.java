package ru.job4j.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryStorage implements Storage {
    private final Map<Long, User> map = new HashMap<>();
    private long ids;

    @Override
    public void add(User user) {
        user.setId(ids++);
        map.put(user.getId(), user);
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memoryStorage = applicationContext.getBean(MemoryStorage.class);
    }
}

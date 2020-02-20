package ru.job4j.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStorageTest {

    @Test
    public void whenAddUserToMemoryAndStorageShouldReturnInsertedValue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memoryStorage = new MemoryStorage();
        UserStorage userStorage = new UserStorage(memoryStorage);
        assertThat(userStorage.add(new User("test")).getName(), is("test"));
        assertNotNull(applicationContext.getBean(MemoryStorage.class));
    }
}
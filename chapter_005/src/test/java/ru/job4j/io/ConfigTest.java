package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ConfigTest {
    Map<String, String> val;
    Config config;

    @Before
    public void init() {
        config = new Config("C:\\projects\\job4j\\chapter_005\\app.properties.txt");
        config.load();
        val = new HashMap<>();
        val.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        val.put("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/trackstudio");
        val.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        val.put("hibernate.connection.username", "postgres");
        val.put("hibernate.connection.password", "password");
    }

    @Test
    public void loadProperties() {
        Map<String, String> rs = config.getValues();
        assertEquals(val, rs);


    }

    @Test
    public void valuesReturnTest() {
        String rs = config.values("hibernate.connection.username");
        String rs1 = config.values("hibernate.dialect");
        assertEquals(rs, "postgres");
        assertEquals(rs1, "org.hibernate.dialect.PostgreSQLDialect");

    }
}
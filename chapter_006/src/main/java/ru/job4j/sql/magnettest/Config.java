package ru.job4j.sql.magnettest;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties val = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            val.load(in);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    public String get(String key) {
        return this.val.getProperty(key);
    }
}

package ru.job4j.io;

import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private Map<String, String> values;

    public Map<String, String> getValues() {
        return values;
    }

    /**
     * Конструктор класса Config
     *
     * @param path
     */
    public Config(final String path) {
        this.path = path;
        values = new HashMap<>();
    }

    /**
     * Метод загружает в Map ключ параметра и его значение
     */
    public void load() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path))) {
            String s;
            while (bufferedReader.ready()) {
                s = bufferedReader.readLine();
                if (s.contains("=")) {
                    String[] tmp = s.split("=");
                    this.values.put(tmp[0], tmp[1]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод должен возвращать значение ключа из Map
     *
     * @param key ключ искомого значения.
     * @return Значение эквивалентное ключу.
     */
    public String values(String key) {
        String rs = null;
        if (Objects.nonNull(key)) {
            rs = this.values.get(key);
        } else {
            throw new UnsupportedOperationException("Dont impl this method yet!");
        }
        return rs;
    }


    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

}

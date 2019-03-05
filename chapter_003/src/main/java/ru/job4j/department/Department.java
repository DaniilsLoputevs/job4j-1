package ru.job4j.department;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 05.03.2019
 */
public class Department {


    private Set<String> data = new TreeSet<>();
    /**
     * Убывание с использованием lambda
     */
    private Set<String> descending = new TreeSet<>((o1, o2) -> {
        int res;
        int minlenght = Math.min(o1.length(), o2.length());
        res = -o1.substring(0, minlenght).compareTo(o2.substring(0, minlenght));
        if (res == 0) {
            res = Integer.compare(o1.length(), o2.length());
        }
        return res;
    });

    /**
     * Добавление
     *
     * @param data Аргумент переменной длины
     */
    public void addDepartament(String... data) {
        Arrays.stream(data).forEach(this::add);
    }

    private void add(String department) {
        String[] slitted = department.split("\\\\");
        StringBuilder current = new StringBuilder();
        for (String s : slitted) {
            current = current.append(s);
            data.add(current.toString());
            descending.add(current.toString());
            current = current.append("\\");
        }
    }

    /**
     * Получение
     *
     * @return алфавитный порядок.
     */
    public String[] getData() {
        return data.toArray(new String[data.size()]);
    }

    /**
     * Получение
     *
     * @return обратный алфавитный порядок.
     */
    public String[] getDescending() {
        return descending.toArray(new String[descending.size()]);
    }
}



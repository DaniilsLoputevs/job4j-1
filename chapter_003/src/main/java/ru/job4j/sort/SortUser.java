package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 02.02.2019
 */
public class SortUser {
    /**
     * Метод возвращающий TreeSet
     *
     * @param list -Входящий List<User>
     * @return TreeSet<User>
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> sorted = new TreeSet<>(list);

        return sorted;
    }

    /**
     * Метод с реализацией Comparator по сортировке List по длинне имени.
     *
     * @param list Входящая структура данных.
     * @return Отсортированная структура данных.
     */
    public List<User> sortNameLenght(List<User> list) {
        return list.stream().sorted(Comparator.comparing(user -> user.getName().length())).collect(Collectors.toList());
    }

    /**
     * Метод с реализацией Comparator по сортировке List по имени и возрасту.
     *
     * @param list Входящая структура данных.
     * @return Отсортированная структура данных.
     */
    public List<User> sortByAllField(List<User> list) {
        return list.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getAge)).collect(Collectors.toList());
    }

}


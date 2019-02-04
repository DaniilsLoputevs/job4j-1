package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

}


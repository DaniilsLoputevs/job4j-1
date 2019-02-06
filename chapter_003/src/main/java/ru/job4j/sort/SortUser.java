package ru.job4j.sort;

import java.util.Comparator;
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

    /**
     * Метод с реализацией Comparator по сортировке List по длинне имени.
     *
     * @param list Входящая структура данных.
     * @return Отсортированная структура данных.
     */
    public List<User> sortNameLenght(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().length() - o2.getName().length();
                    }
                }
        );

        return list;
    }

    /**
     * Метод с реализацией Comparator по сортировке List по имени и возрасту.
     *
     * @param list Входящая структура данных.
     * @return Отсортированная структура данных.
     */
    public List<User> sortByAllField(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int res = o1.getName().compareTo(o2.getName());
                        if (res == 0) {
                            res = Integer.compare(o1.getAge(), o2.getAge());
                        }
                        return res;
                    }
                }
        );
        return list;
    }

}


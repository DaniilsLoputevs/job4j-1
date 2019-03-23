package ru.job4j.sort;

import java.util.Comparator;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 09.02.2019
 */
public class ListCompare implements Comparator<String> {

    /**
     * Метод реализует собственный вариант метода compare для сравнения двух String
     * @param o1 - Первая строка.
     * @param o2 - Вторвая строка.
     * @return результат  больше или меньшн 0 или 0 если строки равны.
     */
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int count = Math.min(o1.length(), o2.length());
        for (int i = 0; i < count; i++) {
            if (o1.charAt(i) != o2.charAt(i)) {
                result = Character.compare(o1.charAt(i), o2.charAt(i));
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(o1.length(), o2.length());
        }
        return result;
    }

}

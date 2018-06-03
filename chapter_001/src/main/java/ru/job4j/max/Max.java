package ru.job4j.max;

/**
 * Package for max| task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Max {

    public int max(int first, int second) {
        return first < second ? first : second;
    }

    public int summation(int first, int second) {
        return first + second;
    }

    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }

}
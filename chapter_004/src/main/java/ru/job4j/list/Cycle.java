package ru.job4j.list;


/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 10.04.2019
 */
public class Cycle<T> {

    /**
     * Метод поиска зацикленности в связном списке.
     *
     * @param value Cамоотносимый элемент.
     * @return boolean
     */

    public boolean findCycle(Node<T> value) {
        Node<T> first = value;
        Node<T> second = value;
        boolean rs = false;
        if (first == null || first.next == null) {
            return rs;
        } else {
            while (second != null && second.next != null) {
                first = first.next;
                second = second.next.next;
                if (first == second) {
                    rs = true;
                    break;
                }
            }
        }

        return rs;
    }

}

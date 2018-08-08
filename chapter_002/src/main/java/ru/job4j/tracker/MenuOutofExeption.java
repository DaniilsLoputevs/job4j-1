package ru.job4j.tracker;
/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 08.08.2018
 */
public class MenuOutofExeption extends RuntimeException {
    /**
     * Метод обрабатывающий возможные неверные данные введенные пользователем.
     * @param msg Сообщение об ошибке.
     */
    public MenuOutofExeption(String msg) {
        super(msg);
    }

}

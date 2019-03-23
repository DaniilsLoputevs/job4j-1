package ru.job4j.tracker;

import java.util.List;
/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 08.08.2018
 */

public interface Input {
    /**
     *  Интерфейс использующийся в программе Трекер
     *  question Сообщение
     * @param question
     * @return
     */
    String ask(String question);
    int ask(String question, List<Integer> range);
}

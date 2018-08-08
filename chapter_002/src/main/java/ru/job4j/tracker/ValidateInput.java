package ru.job4j.tracker;

import java.util.List;

/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 08.08.2018
 */

public class ValidateInput extends ConsoleInput {
    /**
     * @param question Сообщение
     * @param range    Варианты меню
     * @return Введенное значение пользователем
     */
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int val = -1;
        do {
            try {
                val = super.ask(question, range);
                invalid = false;
            } catch (MenuOutofExeption moe) {
                System.out.println("Ошибка: Введите верный пункт меню.");
            } catch (IndexOutOfBoundsException ibe) {
                System.out.println("Пожалуйста укажите верный пункт меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста введите правильные данные");
            }
        } while (invalid);
        return val;
    }
}

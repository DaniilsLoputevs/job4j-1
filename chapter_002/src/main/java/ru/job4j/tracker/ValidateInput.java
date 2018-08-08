package ru.job4j.tracker;

import java.util.List;

/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 08.08.2018
 */

public class ValidateInput implements Input {
    /**
     * Источник данных
     */
    private final Input input;

    /**
     * Конструктор
     *
     * @param input интерфейс
     */
    public ValidateInput(Input input) {
        this.input = input;
    }



    @Override
    public String ask(String question) {
        return this.ask(question);
    }

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
                val = this.input.ask(question, range);
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

package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1
 * @since 17.07.2018
 */
public class StartUI {
    /**
     * Поле используется для выхода из программы.
     */
    private boolean work = true;
    /**
     * Обеспечивает хранение заявок.
     */
    private final Tracker tracker;
    /**
     * Запрос данных у пользователя.
     */

    private final Input input;

    /**
     * Конструктор
     * @param input
     * @param tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;

    }


    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("-------Введите пункт меню------", range));
        } while (this.work);

    }

    public void stop() {
        work = false;
    }

    /**
     * Основной метод начинающий выполнение програмы
     * Содержит реализацию ValidateInput : обрабатываются коректные данные вводимые пользователем
     * Tracker : Основная реализация трекера.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();


    }
}

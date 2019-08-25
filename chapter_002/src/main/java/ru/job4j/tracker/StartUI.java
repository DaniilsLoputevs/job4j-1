package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
    private final ItTracker tracker;
    /**
     * Запрос данных у пользователя.
     */

    private final Input input;

    private final Consumer<String> output;

    /**
     * Конструктор
     *
     * @param input
     * @param tracker
     * @param output
     */
    public StartUI(Input input, ItTracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(output, input, (Tracker) tracker);
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
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();


    }
}

package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1
 * @since 17.07.2018
 */
public class StartUI {

    private boolean work = true;

    private final Tracker tracker;


    private final Input input;


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
            menu.select(input.ask("select", range));
        } while (this.work);

    }

    public void stop() {
        work = false;
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();


    }
}

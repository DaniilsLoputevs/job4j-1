package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 05.07.2018
 **/

public class MenuTracker {
    /**
     * Запрос данных пользователя.
     */
    private Input input;
    /**
     * Система учёта заявок .
     */
    private Tracker tracker;

    /**
     * Конструктор .
     *
     * @param input   Обьект типа Input.
     * @param tracker Обьект типа Tracker.
     */

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Действия пользователя.
     */
    private ArrayList<UserAction> actions = new ArrayList<>();

    /**
     * Метод для получения массива меню.
     *
     * @return длинна массива.
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив с меню внутренними классами которые реализуют функциональность.
     */

    public void fillActions(StartUI input) {
        this.actions.add(new AddItem(0, "-----Добавление новой заявки-----."));
        this.actions.add(new ShowItems(1, "-----Отобразить все заявки в системе------."));
        this.actions.add(new MenuTracker.EditItem(2, "-----Редактирование заявки------."));
        this.actions.add(new MenuTracker.DeleteItem(3, "-----Удаление заявки------."));
        this.actions.add(new FindItemById(4, "-----Поиск заявки по уникальному ID------"));
        this.actions.add(new FindItemsByName(5, "------Поиск заявок по имени.------"));
        this.actions.add(new ExitProgram(input, 6, "------Выход из программы.------"));
    }

    /**
     * Метод в зависимости от ключа выполняет определнное действие в массиве .
     *
     * @param key ключ действия
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит меню в консоль
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }


    private class AddItem implements UserAction {
        private int key;
        private String desc;

        public AddItem(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        /**
         * Пункт меню соответствующий добавлению заявки.
         *
         * @return ключ.
         */
        @Override
        public int key() {
            return this.key;

        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки.:");
            String desc = input.ask("Введите описание заявки.:");
            Item item = tracker.add(new Item(name, desc));
            System.out.println("Создана заявка : " + item.toString());
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "-----Добавление новой заявки-----.");
        }

    }

    private class ShowItems implements UserAction {
        private int key;
        private String desc;

        public ShowItems(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        /**
         * Пункт меню соотвестует отображению всех заявок в трекере.
         */

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------Все заявки в системе------");
            Item[] item = tracker.findAll();
            for (int i = 0; i < item.length; i++) {
                System.out.println("Task:" + item[i]);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Все заявки в системе");
        }
    }

    private class EditItem implements UserAction {
        private int key;
        private String desc;

        public EditItem(int key, String desc) {
            this.key = key;
            this.desc = desc;

        }

        /**
         * Пункт меню соответствует редактированию заявки по id.
         */
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----Редактирование заявки-----");
            String id = input.ask("Введите ID");
            String name = input.ask("Введите имя заявки");
            String desc = input.ask("Введите описание заявки");
            Item item = new Item(id, name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Ваша заявка отредактирована");

            } else {
                System.out.println("Ошибка редактирования");
            }


        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Edit Item by ID");
        }
    }

    private class DeleteItem implements UserAction {
        private int key;
        private String desc;

        public DeleteItem(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        /**
         * Пункт соответстует удаленю заявки из трекера.
         */
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----Введите айди заявки----");
            String id = input.ask("Введите ID заявки");
            if (tracker.delete(id)) {
                System.out.println("-----Ваша заявка была успешно удалена.-----");
            } else {
                System.out.println("------Ваша заявка не была удалена-----");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Delete Item by ID");
        }
    }

    private class FindItemById implements UserAction {
        private int key;
        private String desc;

        public FindItemById(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        /**
         * Пункт соотвестует поиску заявки по ID
         */
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID заявки");
            System.out.println("Ваша заявка:" + tracker.findById(id));

        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Find Item by ID");
        }

    }

    private class FindItemsByName implements UserAction {
        private int key;
        private String desc;

        public FindItemsByName(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        /**
         * Пункт меню соответствует поиску заявок по имени.
         */
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Ввведите имя заявки");
            System.out.println("Ваша заявка" + Arrays.toString(tracker.findByName(name)));
        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Поиск заявок по имени.");
        }
    }

    private class ExitProgram implements UserAction {
        private final StartUI input;
        private int key;
        private String desc;

        public ExitProgram(StartUI input, int key, String desc) {
            this.input = input;
            this.key = key;
            this.desc = desc;

        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.input.stop();
            System.out.println("-----Выход из программы-----");
        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Выход из програмы");
        }
    }


}
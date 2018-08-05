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
     * Метод заполняет массив.
     */

    public void fillActions() {
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от ключа выполняет определнное действие в массиве .
     *
     * @param key ключ действия.
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
            String name = input.ask("Enter the task's name:");
            String desc = input.ask("Enter the task's description :");
            Item item = tracker.add(new Item(name, desc));
            System.out.println("Create new task with name: " + item.toString());
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
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
            System.out.println("------All task in system------");
            Item[] item = tracker.findAll();
            for (int i = 0; i < item.length; i++) {
                System.out.println("Task:" + item[i]);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Show all Items");
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
            System.out.println("---Replace task.----");
            String id = input.ask("Enter ID");
            String name = input.ask("Enter name task");
            String desc = input.ask("Enter desc task");
            Item item = new Item(id, name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Your taks replace");

            } else {
                System.out.println("Error replace");
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
        private int key;
        private String desc;

        public ExitProgram(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----Выход из программы-----");
        }

        @Override
        public String info() {
            return String.format("%s. %s.", this.key(), "Выход из програмы");
        }
    }


}
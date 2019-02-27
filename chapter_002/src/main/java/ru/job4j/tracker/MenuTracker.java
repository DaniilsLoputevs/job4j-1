package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 05.07.2018
 **/

public class MenuTracker {
    private final Consumer<String> output;

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
     * @param output
     * @param input   Обьект типа Input.
     * @param tracker Обьект типа Tracker.
     */

    public MenuTracker(Consumer<String> output, Input input, Tracker tracker) {
        this.output = output;
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
        this.actions.add(new EditItem(2, "-----Редактирование заявки------."));
        this.actions.add(new DeleteItem(3, "-----Удаление заявки------."));
        this.actions.add(new FindItemById(4, "-----Поиск заявки по уникальному ID------"));
        this.actions.add(new FindItemsByName(5, "------Поиск заявок по имени.------"));
        this.actions.add(new ExitProgram(input, 6, "------Выход из программы.------"));
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
                output.accept(action.info());
            }
        }
    }

    /**
     * Внутренний класс расширяет абстракстный класс.
     */
    private class AddItem extends BaseAction {


        public AddItem(int key, String name) {
            super(key, name);

        }


        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки.:");
            String desc = input.ask("Введите описание заявки.:");
            Item item = tracker.add(new Item(name, desc));
            output.accept("Создана заявка : " + item.toString());
        }


    }

    /**
     * Внутренний класс расширяет абстрактный класс.
     */
    private class ShowItems extends BaseAction {


        public ShowItems(int key, String name) {
            super(key, name);

        }


        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------Все заявки в системе------");
            List<Item> finded = tracker.findAll();
            for (Item value : finded) {
                output.accept("Task:" + value.toString());
            }


        }

    }

    /**
     * Внутренний класс расширяет абстрактный класс.
     */
    private class EditItem extends BaseAction {


        public EditItem(int key, String name) {
            super(key, name);

        }


        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("-----Редактирование заявки-----");
            String id = input.ask("Введите ID");
            String name = input.ask("Введите имя заявки");
            String desc = input.ask("Введите описание заявки");
            Item item = new Item(id, name, desc);
            if (tracker.replace(id, item)) {
                output.accept("Ваша заявка отредактирована");

            } else {
                output.accept("Ошибка редактирования");
            }


        }

    }

    /**
     * Внутренний класс расширяет абстрактный класс.
     */
    private class DeleteItem extends BaseAction {


        public DeleteItem(int key, String name) {
            super(key, name);

        }

        /**
         * Пункт соответстует удаленю заявки из трекера.
         */


        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----Введите айди заявки----");
            String id = input.ask("Введите ID заявки");
            if (tracker.delete(id)) {
                output.accept("-----Ваша заявка была успешно удалена.-----");
            } else {
                output.accept("------Ваша заявка не была удалена-----");
            }
        }

    }

    /**
     * Внутренний класс расширяет абстракстный класс.
     */
    private class FindItemById extends BaseAction {


        public FindItemById(int key, String name) {
            super(key, name);

        }


        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID заявки");
            output.accept("Ваша заявка:" + tracker.findById(id));

        }


    }

    /**
     * Внутренний класс раширяет асбстрактный класс.
     */
    private class FindItemsByName extends BaseAction {


        public FindItemsByName(int key, String name) {
            super(key, name);


        }


        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Ввведите имя заявки");
            output.accept("Ваша заявка" + (tracker.findByName(name)));
        }

    }

    private class ExitProgram extends BaseAction {
        private final StartUI input;

        public ExitProgram(StartUI input, int key, String desc) {
            super(key, desc);
            this.input = input;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.input.stop();
            output.accept("-----Выход из программы-----");
        }

    }


}
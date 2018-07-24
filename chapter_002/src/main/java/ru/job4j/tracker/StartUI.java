package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1
 * @since 17.07.2018
 */
public class StartUI {
    /**
     * Константа меню ддя добавления заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отоброажения всех заявок.
     */
    private static final String SHOW_ALL_ITEMS = "1";
    /**
     * Константа меню для редактирования завяки.
     */
    private static final String EDIT_ITEMS = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска по ID.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска по имени.
     */
    private static final String ITEMS_BY_NAME = "5";
    /**
     * Константа меню для выхода из программы.
     */
    private static final String EXIT = "6";

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                // добавление заявки вынесено в отдельнй метод.
                this.createItem();
            } else if (SHOW_ALL_ITEMS.equals(answer)) {
                // Отображение всех заявок в отдельном методе.
                this.showAll();
            } else if (EDIT_ITEMS.equals(answer)) {
                //Редактирование заявки в отдельном методе.
                this.editItem();
            } else if (DELETE.equals(answer)) {
                //Удаление заявки в отдельном методе.
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                //Поиск по ID в отдельном методе.
                this.findById();
            } else if (ITEMS_BY_NAME.equals(answer)) {
                //по имени в отдельном методе.
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
                System.out.println("Программа успешно завершена.");
            }
        }

    }

    /**
     * Пункт в меню для добавления заявки.
     */
    private void createItem() {
        System.out.println("------Добавление новой заявки-----");
        String name = this.input.ask("Введите имя заявки");
        String desc = this.input.ask("Введите описание заявки.");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");

    }

    /**
     * Пункт в меню для отображения заявок в системе.
     */
    public void showAll() {
        System.out.println("------Список заявок в системе.------");
        Item[] item = tracker.findAll();
        for (int i = 0; i < item.length; i++) {
            System.out.println("Заявка:" + item[i]);
        }
    }

    /**
     * Пункт в меню для редактирования заявки в системе.
     */
    public void editItem() {
        System.out.println("----Редактирование заявки.-----");
        String id = this.input.ask("Введите ID заявки");
        String name = this.input.ask("Введите name заявки");
        String desc = this.input.ask("Введите desc заявки");
        Item item = new Item(id, name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("Ваша заявка отредактирована");

        } else {
            System.out.println("Ваша заявка не отредактирована.");
        }

    }


    /**
     * Пункт в меню реализующий метод удаления заявки по ID.
     */
    public void deleteItem() {
        System.out.println("----Введите айди заявки----");
        String id = this.input.ask("Введите ID заявки");
        if (tracker.delete(id)) {
            System.out.println("-----Ваша заявка была успешно удалена.-----");
        } else {
            System.out.println("------Ваша заявка не была удалена-----");
        }
    }

    /**
     * Пункт в меню реализующий метод поиска заявки по ID
     */
    public void findById() {
        String id = this.input.ask("Введите ID заявки");
        System.out.println("Ваша заявка:" + tracker.findById(id));
    }

    public void findByName() {
        String name = this.input.ask("Ввведите имя заявки");
        System.out.println("Ваша заявка" + Arrays.toString(tracker.findByName(name)));
    }

    private void showMenu() {
        System.out.println("------------------Меню.----------------");
        System.out.println("| 0.   Создание новой заявки           |");
        System.out.println("| 1.   Отобразить список всех заявок.  |");
        System.out.println("| 2.   Редактирование заявки по ID.    |");
        System.out.println("| 3.   Удаление заявки по ID.          |");
        System.out.println("| 4.   Поиск заявки по ID.             |");
        System.out.println("| 5.   Поиск заявки по имени.          |");
        System.out.println("----------------------------------------");
        System.out.println("| 6.   Выход из программы.             |");
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();


    }
}

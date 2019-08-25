package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Sergey Bolshanin(dinospb@gmail.com)
 * @version 0.1
 * @since 06.07.2018
 */
public class Tracker implements ItTracker {
    /**
     * Массив для хранение заявок.
     */
    private List<Item> items = new ArrayList<Item>();


    /**
     * Метод реализующий новую заявку
     *
     * @param item заявка
     * @return новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);

        return item;
    }

    /**
     * Метод генерирует уникальный id на основании времени и случайного числа
     *
     * @return
     */
    public static String generateId() {
        return new Date().toString() + Math.random();
    }

    public boolean replace(String id, Item item) {
        boolean res = false;
        for (int i = 0; i < items.size(); i++) {
            if (findById(id).equals(items.get(i))) {
                items.set(i, item);
                res = true;
                break;

            }
        }
        return res;
    }


    /**
     * Метод возвращения без null элементов
     *
     * @return итоговый массив.
     */
    public List<Item> findAll() {

        return new ArrayList<>(items);
    }

    /**
     * Метод удаления .
     *
     * @param id Идентификатор
     */
    public boolean delete(String id) {
        boolean res = false;
        for (int index = 0; index < items.size(); index++) {
            if ((items.get(index) != null) && (items.get(index).getId().equals(id))) {
                this.items.remove(index);
                res = true;
                break;
            }
        }
        return res;
    }


    /**
     * Метод получения списка по имени.
     *
     * @param key Имя
     * @return Возвращает элемент найденный по имени.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item value : items) {
            if (value.getName().equals(key)) {
                result.add(value);
            }
        }
        return result;
    }


    /**
     * Метод поиска по уникальному ключу
     *
     * @param id уникальный идентификатор.
     * @return Возвращает элемент найденный по ключу.
     */
    public Item findById(String id) {
        Item item = null;
        for (Item value : items) {
            if (value.getId().equals(id)) {
                item = value;

            }
        }
        return item;
    }


}
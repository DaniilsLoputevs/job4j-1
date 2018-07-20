package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Sergey Bolshanin(dinospb@gmail.com)
 * @version 0.1
 * @since 06.07.2018
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position;

    /**
     * Метод реализующий новую заявку
     *
     * @param item заявка
     * @return новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;

        return item;
    }

    /**
     * Метод генерирует уникальный id на основании времени и случайного числа
     *
     * @return
     */
    public String generateId() {
        return new Date().toString() + Math.random();
    }

    public void replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (item.getId().equals(id)) {
                item.setId(id);
                items[i] = item;
                break;

            }

        }
    }

    /**
     * Метод возвращения без null элементов
     *
     * @return итоговый массив.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Метод удаления .
     *
     * @param id Идентификатор
     */
    public void delete(String id) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                items[i] = null;
                System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                position--;
                break;
            }
        }
    }

    /**
     * Метод получения списка по имени.
     *
     * @param key Имя
     * @return Возвращает элемент найденный по имени.
     */
    public Item[] findByName(String key) {
        Item[] find = new Item[this.position];
        if (key != null) {
            int index = 0;
            for (int i = 0; i < this.position; i++) {
                if (key.equals(this.items[i].getName())) {
                    find[index++] = this.items[i];
                }
            }
            find = Arrays.copyOf(find, index);
        }

        return find;
    }

    /**
     * Метод поиска по уникальному ключу
     *
     * @param id уникальный идентификатор.
     * @return Возвращает элемент найденный по ключу.
     */
    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                item = this.items[i];
                break;

            }
        }
        return item;
    }
}
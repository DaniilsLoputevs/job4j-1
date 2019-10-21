package ru.job4j.ood.warehouse.implementation;


import ru.job4j.ood.warehouse.iterfaces.Refreshing;
import ru.job4j.ood.warehouse.template.Food;
import ru.job4j.ood.warehouse.template.AbstractStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает Контролер качества и распределения продуктов по различным структурам.
 */
public class Dispatcher implements Refreshing {

    private List<AbstractStorage> storages;

    /**
     * Конструктор принимающий List
     *
     * @param storages
     */
    public Dispatcher(List<AbstractStorage> storages) {
        this.storages = storages;
    }

    /**
     * Метод распределения продукта
     *
     * @param food - обьект продукта
     */
    public void distribution(Food food) {
        this.storages.forEach(abstractStorage -> abstractStorage.insert(food));
    }

    /**
     * Метод распределения
     *
     * @param foods список продуктов
     */
    public void distribution(List<Food> foods) {
        this.storages.forEach(abstractStorage -> foods.forEach(abstractStorage::insert));
    }


    public List<AbstractStorage> getStorages() {
        return storages;
    }

    /**
     * Метод собирает все продукты из хранилищ в tmp список и перераспределяет их заново согласно стратегии и очищает хранилище продуктов .
     */

    @Override
    public void refresh() {
        List<Food> tmp = new ArrayList<>();
        storages.forEach(abstractStorage -> tmp.addAll(abstractStorage.getFoodlist()));
        storages.forEach(abstractStorage -> abstractStorage.getFoodlist().clear());
        tmp.forEach(this::distribution);
    }
}

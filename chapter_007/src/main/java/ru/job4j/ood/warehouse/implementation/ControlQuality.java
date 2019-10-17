package ru.job4j.ood.warehouse.implementation;


import ru.job4j.ood.warehouse.iterfaces.Refreshing;
import ru.job4j.ood.warehouse.template.Food;
import ru.job4j.ood.warehouse.template.AbstractStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает Контролер качества и распределения продуктов по различным структурам.
 */
public class ControlQuality implements Refreshing {

    private List<AbstractStorage> abstractStorages;

    /**
     * Конструктор принимающий List
     *
     * @param abstractStorages
     */
    public ControlQuality(List<AbstractStorage> abstractStorages) {
        this.abstractStorages = abstractStorages;
    }

    /**
     * Метод распределения продукта
     *
     * @param food - обьект продукта
     */
    public void distribution(Food food) {
        this.abstractStorages.forEach(abstractStorage -> abstractStorage.insert(food));
    }

    /**
     * Метод распределения
     *
     * @param foods список продуктов
     */
    public void distribution(List<Food> foods) {
        this.abstractStorages.forEach(abstractStorage -> foods.forEach(abstractStorage::insert));
    }


    public List<AbstractStorage> getAbstractStorages() {
        return abstractStorages;
    }

    /**
     * Метод собирает все продукты из хранилищ в tmp список и перераспределяет их заново согласно стратегии и очищает хранилище продуктов .
     */

    @Override
    public void refresh() {
        List<Food> tmp = new ArrayList<>();
        abstractStorages.forEach(abstractStorage -> tmp.addAll(abstractStorage.getFoodlist()));
        abstractStorages.forEach(abstractStorage -> abstractStorage.getFoodlist().clear());
        tmp.forEach(this::distribution);
    }
}

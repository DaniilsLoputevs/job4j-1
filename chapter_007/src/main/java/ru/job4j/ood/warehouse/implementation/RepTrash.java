package ru.job4j.ood.warehouse.implementation;


import ru.job4j.ood.warehouse.iterfaces.Strategy;
import ru.job4j.ood.warehouse.template.AbstractStorage;
import ru.job4j.ood.warehouse.template.Food;

import java.util.List;

public class RepTrash extends AbstractStorage {
    private AbstractStorage abstractStorage;

    public RepTrash(AbstractStorage abstractStorage, String title, List<Food> foodlist, Strategy strategy) {
        super(title, foodlist, strategy);
        this.abstractStorage = abstractStorage;
    }

    @Override
    public void insert(Food food) {
        if (food.isReprod()) {
            this.abstractStorage.insert(food);
        }
    }

    @Override
    public List<Food> getFoodlist() {
        return this.abstractStorage.getFoodlist();
    }
}

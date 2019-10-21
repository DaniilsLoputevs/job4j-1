package ru.job4j.ood.warehouse.implementation;


import ru.job4j.ood.warehouse.iterfaces.Strategy;
import ru.job4j.ood.warehouse.template.AbstractStorage;
import ru.job4j.ood.warehouse.template.Food;

import java.util.List;

public class RepTrash extends AbstractStorage {
    private AbstractStorage storage;

    public RepTrash(AbstractStorage storage, String title, List<Food> foodlist, Strategy strategy) {
        super(title, foodlist, strategy);
        this.storage = storage;
    }

    @Override
    public void insert(Food food) {
        if (food.isReprod()) {
            this.storage.insert(food);
        }
    }

    @Override
    public List<Food> getFoodlist() {
        return this.storage.getFoodlist();
    }
}

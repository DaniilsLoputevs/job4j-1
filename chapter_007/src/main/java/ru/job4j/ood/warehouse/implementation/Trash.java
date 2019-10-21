package ru.job4j.ood.warehouse.implementation;

import ru.job4j.ood.warehouse.iterfaces.Strategy;
import ru.job4j.ood.warehouse.template.AbstractStorage;
import ru.job4j.ood.warehouse.template.Food;

import java.util.List;

public class Trash extends AbstractStorage {

    public Trash(String title, List<Food> foodlist, Strategy strategy) {
        super(title, foodlist, strategy);
    }

    @Override
    public void insert(Food food) {
        if (this.getStrategy().checkState(food)) {
            this.getFoodlist().add(food);
        }
    }
}

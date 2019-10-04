package ru.job4j.ood.warehouse.implementation;

import ru.job4j.ood.warehouse.template.AbstractStorage;
import ru.job4j.ood.warehouse.template.Food;

import java.util.List;

public class SimpleStore extends AbstractStorage {

    public SimpleStore(String title, List<Food> foodlist) {
        super(title, foodlist);
    }

    @Override
    public void insert(Food food) {
        this.getFoodlist().add(food);

    }
}

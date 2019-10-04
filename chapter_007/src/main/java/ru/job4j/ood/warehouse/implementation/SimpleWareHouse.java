package ru.job4j.ood.warehouse.implementation;

import ru.job4j.ood.warehouse.template.Food;
import ru.job4j.ood.warehouse.template.AbstractStorage;

import java.util.List;

public class SimpleWareHouse extends AbstractStorage {

    public SimpleWareHouse(String title, List<Food> foodlist) {
        super(title, foodlist);
    }

    @Override
    public void insert(Food food) {
        this.getFoodlist().add(food);
    }

}

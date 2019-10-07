package ru.job4j.ood.warehouse.implementation;

import ru.job4j.ood.warehouse.iterfaces.Strategy;
import ru.job4j.ood.warehouse.template.Food;
import ru.job4j.ood.warehouse.template.AbstractStorage;

import java.util.List;

public class SimpleWareHouse extends AbstractStorage implements Strategy {

    public SimpleWareHouse(String title, List<Food> foodlist, Strategy strategy) {
        super(title, foodlist, strategy);
    }

    @Override
    public void insert(Food food) {
        this.getFoodlist().add(food);
    }

    @Override
    public void operation(Food food) {
        this.getFoodlist().add(food);
    }
}

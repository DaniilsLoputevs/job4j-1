package ru.job4j.ood.warehouse.implementation;

import ru.job4j.ood.warehouse.iterfaces.Strategy;
import ru.job4j.ood.warehouse.template.AbstractStorage;
import ru.job4j.ood.warehouse.template.Food;

import java.util.List;

public class SimpleStore extends AbstractStorage implements Strategy {

    public SimpleStore(String title, List<Food> foodlist, Strategy strategy) {
        super(title, foodlist, strategy);
    }

    @Override
    public void insert(Food food) {
        this.getFoodlist().add(food);

    }

    @Override
    public void operation(Food food) {
        food.setPrice(food.getPrice() * food.getDiscount());
        this.insert(food);

    }
}

package ru.job4j.ood.warehouse.template;

import ru.job4j.ood.warehouse.iterfaces.StorageInterface;
import ru.job4j.ood.warehouse.iterfaces.Strategy;

import java.util.List;

public abstract class AbstractStorage implements StorageInterface {
    private Strategy strategy;
    private List<Food> foodlist;
    private String title;

    public AbstractStorage(String title, List<Food> foodlist, Strategy strategy) {
        this.title = title;
        this.foodlist = foodlist;
        this.strategy = strategy;
    }

    public List<Food> getFoodlist() {
        return foodlist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

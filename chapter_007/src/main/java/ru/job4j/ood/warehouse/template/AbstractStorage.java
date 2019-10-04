package ru.job4j.ood.warehouse.template;

import ru.job4j.ood.warehouse.iterfaces.StorageInterface;

import java.util.List;

public abstract class AbstractStorage implements StorageInterface {
    private List<Food> foodlist;
    private String title;

    public AbstractStorage(String title, List<Food> foodlist) {
        this.title = title;
        this.foodlist = foodlist;
    }

    public List<Food> getFoodlist() {
        return foodlist;
    }

    public void setFoodlist(List<Food> foodlist) {
        this.foodlist = foodlist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

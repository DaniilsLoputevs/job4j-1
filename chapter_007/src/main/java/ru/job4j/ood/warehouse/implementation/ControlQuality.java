package ru.job4j.ood.warehouse.implementation;


import ru.job4j.ood.warehouse.template.AbstractStorage;
import ru.job4j.ood.warehouse.template.Food;

import java.util.List;

public class ControlQuality {

    private List<AbstractStorage> abstractStorages;

    public ControlQuality(List<AbstractStorage> abstractStorages) {
        this.abstractStorages = abstractStorages;
    }


    public void distribution(Food food) {
        this.abstractStorages.forEach(abstractStorage -> abstractStorage.insert(food));
    }

    public void distribution(List<Food> foods) {
        this.abstractStorages.forEach(abstractStorage -> foods.forEach(abstractStorage::insert));
    }


    public List<AbstractStorage> getAbstractStorages() {
        return abstractStorages;
    }

}

package ru.job4j.ood.warehouse.implementation;

import ru.job4j.ood.warehouse.iterfaces.StorageInterface;
import ru.job4j.ood.warehouse.iterfaces.Strategy;
import ru.job4j.ood.warehouse.template.Food;

public class WareHouseApp implements StorageInterface, Strategy {
    private SimpleWareHouse wareHouse;
    private SimpleStore store;
    private SimpleTrash trash;

    @Override
    public void insert(Food food) {

    }

    @Override
    public void checker(Food food) {

    }
}

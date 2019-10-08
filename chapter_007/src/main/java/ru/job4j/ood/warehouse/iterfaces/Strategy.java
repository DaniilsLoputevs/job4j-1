package ru.job4j.ood.warehouse.iterfaces;


import ru.job4j.ood.warehouse.template.Food;


public interface Strategy {

    boolean checkState(Food food);
}

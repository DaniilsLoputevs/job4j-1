package ru.job4j.ood.warehouse.iterfaces;


import ru.job4j.ood.warehouse.template.Food;

import java.time.LocalDate;

public interface Strategy {

    boolean operation(Food food);

    double percent();
}

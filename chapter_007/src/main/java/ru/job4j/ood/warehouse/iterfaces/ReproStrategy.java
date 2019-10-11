package ru.job4j.ood.warehouse.iterfaces;

import ru.job4j.ood.warehouse.template.RepFood;

public interface ReproStrategy extends Strategy {

    boolean checkState(RepFood food);

    boolean checkRepro(RepFood repFood);
}

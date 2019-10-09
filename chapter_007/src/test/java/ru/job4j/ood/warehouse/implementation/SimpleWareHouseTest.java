package ru.job4j.ood.warehouse.implementation;

import org.junit.Test;
import ru.job4j.ood.warehouse.strategys.FreshStrategy;
import ru.job4j.ood.warehouse.template.Beef;
import ru.job4j.ood.warehouse.template.Food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleWareHouseTest {

    @Test
    public void insertTwoFoodValueAndWareHouselogicInsertOneValue() {
        List<Food> test = this.initialList();
        SimpleWareHouse simpleWareHouse = new SimpleWareHouse("Warehouse", new ArrayList<>(), new FreshStrategy());
        test.forEach(food -> simpleWareHouse.insert(food));
        assertThat(simpleWareHouse.getFoodlist().size(), is(1));

    }


    private List<Food> initialList() {
        List<Food> a = new ArrayList<>();
        LocalDate created = LocalDate.now().minusDays(2);
        LocalDate expired = created.plusDays(10);
        a.add(new Beef("beef", expired, created, 2000, 10));
        a.add(new Beef("beef", expired, created.minusDays(10), 2000, 10));
        return a;
    }
}
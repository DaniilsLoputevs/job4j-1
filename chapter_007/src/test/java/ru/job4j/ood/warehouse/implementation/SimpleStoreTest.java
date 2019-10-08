package ru.job4j.ood.warehouse.implementation;

import org.junit.Test;
import ru.job4j.ood.warehouse.strategys.ShopStrategy;
import ru.job4j.ood.warehouse.template.Beef;
import ru.job4j.ood.warehouse.template.Food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleStoreTest {

    @Test
    public void testInsertingValueAndCheckDiscount() {
        List<Food> test = this.initialList();
        SimpleStore simpleStore = new SimpleStore("teststore", new ArrayList<>(), new ShopStrategy());
        test.forEach(food -> simpleStore.insert(food));
        assertThat(simpleStore.getFoodlist().size(), is(2));
        assertThat(simpleStore.getFoodlist().get(0).getPrice(), is(1800.0));
        assertThat(simpleStore.getFoodlist().get(1).getPrice(), is(2700.0));
    }

    private List<Food> initialList() {
        List<Food> a = new ArrayList<>();
        LocalDate created = LocalDate.now();
        LocalDate expired = created.plusDays(30);
        a.add(new Beef("test", expired, created, 2000, 10));
        a.add(new Beef("val", expired, created, 3000, 10));
        return a;
    }
}
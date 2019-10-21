package ru.job4j.ood.warehouse.implementation;

import org.junit.Test;
import ru.job4j.ood.warehouse.strategys.FreshStrategy;
import ru.job4j.ood.warehouse.strategys.ReproduceStrategy;
import ru.job4j.ood.warehouse.strategys.ShopStrategy;
import ru.job4j.ood.warehouse.strategys.TrashStrategy;
import ru.job4j.ood.warehouse.template.AbstractStorage;
import ru.job4j.ood.warehouse.template.Beef;
import ru.job4j.ood.warehouse.template.Food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DispatcherTest {

    @Test
    public void distribution() {
        Dispatcher dispatcher = new Dispatcher(this.initialList());
        dispatcher.distribution(this.initialFoodList());
        assertThat(dispatcher.getStorages().get(0).getFoodlist().size(), is(1));
        assertThat(dispatcher.getStorages().get(1).getFoodlist().size(), is(1));
        assertThat(dispatcher.getStorages().get(2).getFoodlist().size(), is(1));
        assertThat(dispatcher.getStorages().get(3).getFoodlist().size(), is(0));
        dispatcher.refresh();


    }

    @Test
    public void testingRefresh() {
        Dispatcher dispatcher = new Dispatcher(this.initialList());
        dispatcher.distribution(this.initialFoodList());
        assertThat(dispatcher.getStorages().get(0).getFoodlist().size(), is(1));
        assertThat(dispatcher.getStorages().get(1).getFoodlist().size(), is(1));
        assertThat(dispatcher.getStorages().get(2).getFoodlist().size(), is(1));
        assertThat(dispatcher.getStorages().get(3).getFoodlist().size(), is(0));
        dispatcher.refresh();
        assertThat(dispatcher.getStorages().get(0).getFoodlist().size(), is(1));
        assertThat(dispatcher.getStorages().get(1).getFoodlist().size(), is(1));
        assertThat(dispatcher.getStorages().get(2).getFoodlist().size(), is(1));
        assertThat(dispatcher.getStorages().get(3).getFoodlist().size(), is(0));


    }

    private List<AbstractStorage> initialList() {
        List<AbstractStorage> abs = new ArrayList<>();
        abs.add(new Store("teststore", new ArrayList<>(), new ShopStrategy()));
        abs.add(new Trash("testtrash", new ArrayList<>(), new TrashStrategy()));
        abs.add(new Warehouse("testwarehouse", new ArrayList<>(), new FreshStrategy()));
        abs.add(new RepTrash(new Trash("testdec", new ArrayList<>(), new TrashStrategy()), "testreproducer", new ArrayList<>(), new ReproduceStrategy()));
        return abs;
    }

    private List<Food> initialFoodList() {
        List<Food> a = new ArrayList<>();
        LocalDate createdstore = LocalDate.now().minusDays(9);
        LocalDate expiredstore = LocalDate.now().plusDays(24);
        a.add(new Beef("beefstore", expiredstore, createdstore, 2000, 10));
        LocalDate createdtrash = LocalDate.now().minusDays(8);
        LocalDate expiredtrash = LocalDate.now().plusDays(2);
        a.add(new Beef("trashbeef", expiredtrash, createdtrash, 2000, 10));
        LocalDate createdwarehouse = LocalDate.now().minusDays(2);
        LocalDate expiredWarehouse = LocalDate.now().plusDays(12);
        a.add(new Beef("warehousebeef", expiredWarehouse, createdwarehouse, 2000, 10));
        return a;
    }
}
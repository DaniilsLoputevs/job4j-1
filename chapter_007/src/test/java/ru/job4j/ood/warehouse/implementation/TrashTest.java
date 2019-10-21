package ru.job4j.ood.warehouse.implementation;

import org.junit.Test;
import ru.job4j.ood.warehouse.strategys.TrashStrategy;
import ru.job4j.ood.warehouse.template.Beef;
import ru.job4j.ood.warehouse.template.Food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrashTest {

    @Test
    public void insertTrashStore() {
        Trash trash = new Trash("testtrash", new ArrayList<>(), new TrashStrategy());
        List<Food> test = this.initialList();
        test.forEach(food -> trash.insert(food));
        assertThat(trash.getFoodlist().size(), is(2));
    }

    private List<Food> initialList() {
        List<Food> a = new ArrayList<>();
        LocalDate created = LocalDate.now().minusDays(8);
        LocalDate expired = LocalDate.now().plusDays(2);
        a.add(new Beef("test", expired, created, 2000, 10));
        a.add(new Beef("test", expired, created, 2000, 10));
        return a;
    }
}
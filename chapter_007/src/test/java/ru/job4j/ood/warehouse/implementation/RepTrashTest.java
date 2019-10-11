package ru.job4j.ood.warehouse.implementation;

import org.junit.Test;
import ru.job4j.ood.warehouse.strategys.ReproduceStrategy;
import ru.job4j.ood.warehouse.template.Food;
import ru.job4j.ood.warehouse.template.Vegetables;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RepTrashTest {

    @Test
    public void insert() {
        RepTrash repTrash = new RepTrash(new SimpleTrash("trash", new ArrayList<>(), new ReproduceStrategy()), "testrepro", new ArrayList<>(), new ReproduceStrategy());
        List<Food> a = this.initialList();
        a.forEach(repTrash::insert);
        assertThat(repTrash.getFoodlist().size(), is(1));
    }

    private List<Food> initialList() {
        List<Food> rs = new ArrayList<>();
        rs.add(new Vegetables("test1", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 1000, 2, true));
        rs.add(new Vegetables("test2", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 1000, 2, false));
        return rs;
    }

}
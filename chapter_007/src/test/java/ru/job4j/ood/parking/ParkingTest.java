package ru.job4j.ood.parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void manageParking() {
        Parking test = init(1, 1);
        assertThat(test.manageParking(new Auto("test", 5)), is(false));
        assertThat(test.manageParking(new Auto("test", 1)), is(true));
        assertThat(test.freeplace(), is(1));
    }

    @Test
    public void checkFreePlaceInparking() {
        assertThat(init(5, 5).freeplace(), is(10));
    }

    private Parking init(int a, int t) {
        return new Parking(a, t);
    }

    @Test
    public void unplaceCar() {
        Parking test = init(4, 4);
        test.manageParking(new Auto("123", 2));
        test.manageParking(new Auto("321", 2));
        assertThat(test.unplace("321"), is(true));
        assertThat(test.freeplace(), is(6));
        assertThat(test.unplace("123"), is(true));
        assertThat(test.unplace("444"), is(false));
        assertThat(test.freeplace(), is(8));
    }
}
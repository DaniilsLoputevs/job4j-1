package ru.job4j.ood.parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AutoTest {

    @Test
    public void findplace() {
        Auto auto = new Auto("test", 1);
        assertThat(auto.findplace(), is(1));
        assertThat(auto.numberCar(), is("test"));
    }
}
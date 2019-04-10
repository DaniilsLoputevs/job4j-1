package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CycleTest {
     Cycle<String> cycle;
     Node<String> stringNode1;
     Node<String> stringNode2;
     Node<String> stringNode3;
     Node<String> stringNode4;

    @Before
    public void init() {
        cycle = new Cycle<>();
        stringNode1 = new Node<>("1 значение");
        stringNode2 = new Node<>("2 значение");
        stringNode3 = new Node<>("3 значение");
        stringNode4 = new Node<>("4 значение");
        stringNode1.setNext(stringNode2);
        stringNode2.setNext(stringNode3);
        stringNode3.setNext(stringNode4);
        stringNode4.setNext(stringNode1);
    }

    @Test
    public void findCycleInCyclicShouldReturnTrue() {
        Cycle<String> cycle = new Cycle<>();
        assertThat(cycle.findCycle(stringNode1), is(true));
    }

    @Test
    public void cantFindCyclicInLinketShouldReturnFalse() {
        stringNode4.setNext(null);
        assertThat(cycle.findCycle(stringNode1), is(false));
    }

    @Test
    public void findCycleInTheMiddleOfLinkedShouldReturnTrue() {
        stringNode3.setNext(stringNode2);
        assertThat(cycle.findCycle(stringNode1), is(true));
    }
}
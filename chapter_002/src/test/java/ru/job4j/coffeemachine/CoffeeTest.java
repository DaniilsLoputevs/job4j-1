package ru.job4j.coffeemachine;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Package for OOP basic task
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1
 * @since 12.10.2018
 */
public class CoffeeTest {
    /**
     * Тест на возврат 65
     *
     * @value - 100
     * @price - 35
     */
    @Test
    public void whenBack65() {
        Coffee coffee = new Coffee();
        ArrayList<Integer> back = new ArrayList<>();
        back.add(10);
        back.add(10);
        back.add(10);
        back.add(10);
        back.add(10);
        back.add(10);
        back.add(5);
        assertThat(coffee.change(100, 35), is(back));
    }
    /**
     * Тест на возврат 15
     *
     * @value - 50
     * @price - 35
     */
    @Test
    public void whenBack15() {
        Coffee coffee = new Coffee();
        ArrayList<Integer> back = new ArrayList<>();
        back.add(10);
        back.add(5);
        assertThat(coffee.change(50, 35), is(back));
    }
    /**
     * Тест на возврат номинала всех монет
     *
     * @value - 63
     * @price - 35
     */
    @Test
    public void whenBack28() {
        Coffee coffee = new Coffee();
        ArrayList<Integer> back = new ArrayList<>();
        back.add(10);
        back.add(10);
        back.add(5);
        back.add(2);
        back.add(1);
        assertThat(coffee.change(63, 35), is(back));
    }

}
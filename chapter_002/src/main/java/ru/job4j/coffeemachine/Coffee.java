package ru.job4j.coffeemachine;

import java.util.ArrayList;

/**
 * Package for OOP basic task
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1
 * @since 12.10.2018
 */
public class Coffee {
    /**
     * Метод возвращающий сдачу с наимешньшем колличеством монет.
     *
     * @param value Купюра.
     * @param price Цена продукта.
     * @return Автоматически расширяеммый массив с монетами сдачи.
     */
    ArrayList<Integer> change(int value, int price) {
        int money = value > price ? value - price : 0;
        ArrayList<Integer> back = new ArrayList<>();
        int[] coins = {10, 5, 2, 1};
        for (int coin : coins) {
            while (money >= coin) {
                money = money - coin;
                back.add(coin);

            }
        }
        return back;
    }
}
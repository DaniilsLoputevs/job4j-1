package ru.job4j.loop;

/**
 * Package for loop task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    public String rightTrl(int height) {
        // Буфер результата.
        StringBuilder screen = new StringBuilder();
        //Ширина пирамиды  будет равна высоте.
        int weight = height;
        //Внеший цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            //Внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
                //Если строка равна ячейки, то рисуем галочку.
                //В данном случае определяем сколько галок будет в строке
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }

            }
            //добавляем перевод строки
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }


    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= weight - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    public String pyramide(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
        } screen.append(System.lineSeparator());

        return screen.toString();
    }



}
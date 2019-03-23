package ru.job4j.pseudo;

/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 26.07.2018
 */
public class Square implements Shape {
    /**
     * @return Фигура
     *  метод по прорисовке фигуры используя интерфейс Shape.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++");
        pic.append(System.lineSeparator());
        pic.append("+++++");
        pic.append(System.lineSeparator());
        pic.append("+++++");
        return pic.toString();
    }
}


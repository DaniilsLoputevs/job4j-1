package ru.job4j.pseudo;

/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 26.07.2018
 */

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Метод вывода фигур на консоль
     *
     * @param args
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        Square square = new Square();
        paint.draw(square);
        Triangle triangle = new Triangle();
        paint.draw(triangle);


    }
}
